$('#account').focus();
$('#account').blur(judgeAccout);
$('#password').blur(judgePassword);
$('#permission').change(judgePermission);
$('#login_button').click(judge);


function judgeAccout(){
	// \w 匹配字母、数字、下划线。等价于'[A-Za-z0-9_]'。
	var reg = /^\w{8,12}$/;
	var value = $('#account').val();
	if(reg.test(value)){
		$('#account_msg').addClass("hidden");
		$('#account_msg').html("");
		return true;
	}else{
		$('#account_msg').removeClass("hidden");
		$('#account_msg').html("账号由8-12位数字、字母或下划线任意组合");
		return false;
	}	
}
function judgePassword(){
	var reg = /^[A-Za-z0-9]{8,12}$/;
	var value = $('#password').val();
	if(reg.test(value)){
		$('#password_msg').addClass("hidden");
		$('#password_msg').html("");
		return true;
	}else{
		$('#password_msg').removeClass("hidden");
		$('#password_msg').html("密码由8-12位数字或字母任意组合");
		return false;
	}
}
function judgePermission(){
	if($('#permission').val()==0){		
		$('#permission_msg').removeClass("hidden");
		$('#permission_msg').html("请选择身份");
		return false;
	}else{
		$('#permission_msg').addClass("hidden");
		$('#permission_msg').html("");
		return true;
	}
}

function judge(){
	var result = judgeAccout()+judgePassword()+judgePermission();
	if(result==3){
		//alert("登录成功");
		var url= "user/login.do";
		var account = $('#account').val();
		var password = $('#password').val();
		var permission = $('#permission').val();
		var data={account:account,password:password,permission:permission};
		$.post(url,data,function(result){
			if(result.state==200){
				if(result.data.permission==1){
					window.location.href="user/toAdminView.do"
				}
				if(result.data.permission==2){
					window.location.href="user/toWaiterView.do"
				}
			}else{
				if(result.message=='账号不存在'){
					$('#account_msg').removeClass("hidden");
					$('#account_msg').html(result.message);
				}else{
					$('#account_msg').addClass("hidden");
					$('#account_msg').html("");
				}
				if(result.message=='密码不正确'){
					$('#password_msg').removeClass("hidden");
					$('#password_msg').html(result.message);
				}else{
					$('#password_msg').addClass("hidden");
					$('#password_msg').html("");
				}
				if(result.message=='身份不匹配'){
					$('#permission_msg').removeClass("hidden");
					$('#permission_msg').html(result.message);
				}else{
					$('#permission_msg').addClass("hidden");
					$('#permission_msg').html("");
				}
				
			}
		})
	}else{
		alert("登录失败");		
	}
}

/*
 * 显示密码
 */
function eyeOpen() {
	$("#password").attr("type", "text");
	$("#eye-open-close").attr("onclick", "eyeClose()");
	$("#eye-open-close").html(
			"<span class=\"glyphicon glyphicon-eye-open\"></span>");
	$("#eye-open-close").css("color", "#2e6da4");
}

/*
 * 隐藏密码
 */
function eyeClose() {
	$("#password").attr("type", "password");
	$("#eye-open-close").attr("onclick", "eyeOpen()");
	$("#eye-open-close").html(
			"<span class=\"glyphicon glyphicon-eye-close\"></span>");
	$("#eye-open-close").css("color", "#555");
}

