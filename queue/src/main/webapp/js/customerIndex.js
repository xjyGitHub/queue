//获取焦点
$('#telephone').focus();
//失去焦点时触发方法
$('#telephone').blur(judgeTelephoneNum);

$('#desk_type').blur(judgeDeskType);
//值发生改变的时候触发方法
$('#desk_type').change(judgeDeskType);
//点击的时候触发方法
$('#get_order_num_button').click(judge);


//判断手机号
function judgeTelephoneNum(){
	//手机号的正则表达式
	var pattern = /^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\d{8}$/;
	//获取值
	var value = $('#telephone').val();
	//判断获取的值是否符合正则表达式
	if(!pattern.test(value)){
		//移除class里面的样式
		$('#telephone_msg').removeClass("hidden");
		//给文本类的标签赋值，比如<span>,<h1>,<p>等
		//如果是输入框这些，则是用  .val(数据)  
		$('#telephone_msg').html("请输入正确的手机号码");
		return false;
	}else{
		//添加class里面的样式
		$('#telephone_msg').addClass("hidden");
		$('#telephone_msg').html("");
		return true;
	}
}
//判断是否有选择桌位类型
function judgeDeskType(){
	if($('#desk_type').val()==0){		
		$('#desk_type_msg').removeClass("hidden");
		$('#desk_type_msg').html("请选择桌位类型");
		return false;
	}else{
		$('#desk_type_msg').addClass("hidden");
		$('#desk_type_msg').html("");
		return true;
	};
}

//判断录入的数据是否都合法

function judge(){
	var result = judgeTelephoneNum()+judgeDeskType();
	if(result==2){
		alert("取号成功");
	}else{
		alert("取号失败");
	}
}

function getNum() {
	
	var telephone = $('#telephone').val();
	var deskType = $('#desk_type').val();
	
//	var url = "customer/getNum.do";
//	var = "";
	
}




