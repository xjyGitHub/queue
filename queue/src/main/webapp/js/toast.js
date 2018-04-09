/**
 * mobile web toast提示框 使用方式：
 * webToast("你好","bottom",1000);
 * webToast("hello","bottom"); 
 * webToast("toast",1000); 
 * webToast("jq");
 */
function webToast() {
	// 默认设置
	var dcfg = {
		msg : "提示信息",
		postion : "top",// 展示位置，可能值：bottom,top,middle,默认top：是因为在mobile
		// web环境下，输入法在底部会遮挡toast提示框
		time : 2000,// 展示时间
	};
	// *********************以下为参数处理******************
	var len = arguments.length;
	var arg0 = arguments[0];
	if (arguments.length > 0) {
		dcfg.msg = arguments[0];
		dcfg.msg = arg0;

		var arg1 = arguments[1];
		var regx = /(bottom|top|middle)/i;
		var numRegx = /[1-9]\d*/;
		if (regx.test(arg1)) {
			dcfg.postion = arg1;
		} else if (numRegx.test(arg1)) {
			dcfg.time = arg1;
		}

		var arg2 = arguments[2];
		var numRegx = /[1-9]\d*/;
		if (numRegx.test(arg2)) {
			dcfg.time = arg2;
		}
	}
	// *********************以上为参数处理******************
	var ret = "<div class='web-toast'><div class='cx-mask-transparent'></div>"
			+ dcfg.msg + "</div>";
	if ($(".web-toast").length <= 0) {
		$("body").append(ret);
	} else {// 如果页面有web-toast 先清除之前的样式
		$(".web-toast").css("left", "");

		ret = "<div class='cx-mask-transparent'></div>" + dcfg.msg;
		$(".web-toast").html(ret);
	}
	var w = $(".web-toast").width(), ww = $(window).width();
	$(".web-toast").fadeIn();
	$(".web-toast").css("left", (ww - w) / 2 - 20);
	if ("bottom" == dcfg.postion) {
		$(".web-toast").css("bottom", 50);
		$(".web-toast").css("top", "");// 这里为什么要置空
	} else if ("top" == dcfg.postion) {
		$(".web-toast").css("bottom", "");
		$(".web-toast").css("top", 50);
	} else if ("middle" == dcfg.postion) {
		$(".web-toast").css("bottom", "");
		$(".web-toast").css("top", "");
		var h = $(".web-toast").height(), hh = $(window).height();
		$(".web-toast").css("bottom", (hh - h) / 2 - 20);
	}
	setTimeout(function() {
		$(".web-toast").fadeOut();
	}, dcfg.time);
}