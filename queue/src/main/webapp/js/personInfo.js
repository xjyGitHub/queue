
//获取个人信息
function getPersonInfo() {
	var account = $('#accountID').html();
	var data={account:account};
	var url = "/queue/user/getInfo.do";
	$.get(url,data,function(result){
		if(result.state==200){
			$('#model_account').val(result.data.account);
			$('#model_name').val(result.data.name);
			$('#model_gender').val(result.data.gender);
			$('#model_telephone').val(result.data.telephone);
		}else{
			console.log("查询失败");
		}
	});	
}

//更改账号信息
function updateUser() {
	var account = $('#model_account').val();
	var name = $('#model_name').val();
	var gender = $('#model_gender').val();
	var telephone = $('#model_telephone').val();
	var data={account:account,name:name,gender:gender,telephone:telephone};
	var url = "/queue/user/updateUser.do";
	$.ajax({
		url:url,
		data:data,
		success:function(result){
			$('#closeBtn').click();
			webToast(result.message, "middle", 1200);
		}
	});	
	
	
}