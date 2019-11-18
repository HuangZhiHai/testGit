function $(id){return document.getElementById(id)}

function user_input(){
	var name = $("id").value;
	var password = $("password").value;
	if(name=="" || password==""){
		alert("用户名或密码不能为空！");
		return false;
		}else{
			return true;
			}	
	}

function LoadBlogParts(){
	var swfUrl = rootUrl+"/common/clock.swf";
	var swfTitle = "honehoneclock";
	var sUrl = swfUrl;	
	var sHtml = "";
	sHtml += '<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0" width="160" height="70" id="' + swfTitle + '" align="middle">';
	sHtml += '<param name="allowScriptAccess" value="always" />';
	sHtml += '<param name="movie" value="' + sUrl + '" />';
	sHtml += '<param name="quality" value="high" />';
	sHtml += '<param name="bgcolor" value="#ffffff" />';
	sHtml += '<param name="wmode" value="transparent" />';
	sHtml += '<embed wmode="transparent" src="' + sUrl + '" quality="high" bgcolor="#ffffff" width="160" height="70" name="' + swfTitle + '" align="middle" allowScriptAccess="always" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />';
	sHtml += '</object>';
	document.write(sHtml);
}
function loginFunction(){
	if($("#id").val() != "" && $("#id").val() != null && $("#id").val() != undefined){
		if($("#password").val() != "" && $("#password").val() != null && $("#password").val() != undefined){
			$.ajax({
				url:"login.action",
				type:"post",
				dataType:"json",
				data:{"userName":$("#id").val(),
					  "password":$("#password").val()},
				success:function(data){
					if(data){
						window.location.href = "toMain.action";
					}else{
						$("#loginMessage").html("用户名或密码错误！")
					}
				}
			});
		}else{
			$("#loginMessage").html("请输入密码！")
			return;
		}
	}else{
		$("#loginMessage").html("请输入用户名！")
		return;
	}
}
function regiestSumbmit(){
	/*注册提交*/
		var username = $("#username").val();
		var nickname = $("#nickname").val();
		var password = $("#PWD").val();
		var finalPWD = $("#finalPWD").val();
		if(username != "" && username != null && username != undefined){
			if(nickname != "" && nickname != null && nickname != undefined){
				if(password != "" && password != null && password != undefined){
					if(finalPWD != "" && finalPWD != null && finalPWD != undefined){
						if(password == finalPWD){
							$.ajax({
								url:"toSubmitData.action",
								type:"post",
								dataType:"json",
								data:serializeForm($('#reg-form')),
								success:function(data){
									if(data.data!='success'){
										$("#regiestMessage").html(data.data)
									}else{
										$("#regiestMessage").html("注册成功");
										closeRegiest();
									}
								},
								error:function(){
									window.location.href="toMain.action";
								}
							});
						}else{
							$("#regiestMessage").html("两次输入密码不一致！")
							$("#finalPWD").focus();
							return;
						}
					}else{
						$("#regiestMessage").html("请再次确认密码！")
						$("#finalPWD").focus();
						return;
					}
				}else{
					$("#regiestMessage").html("请输入密码！")
					$("#password").focus();
					return;
				}
			}else{
				$("#regiestMessage").html("请输入昵称！")
				$("#nickname").focus();
				return;
			}
		}else{
			$("#regiestMessage").html("请输入用户名！")
			$("#username").focus();
			return;
		}
}
/*关闭窗口*/
function closeRegiest(){
	var left=($(window).width()*(1-0.35))/2;
	var top=($(window).height()*(1-0.5))/2;
	$(".box").show().animate({
		width:"-$(window).width()*0.35",
		height:"-$(window).height()*0.5",
		left:"-"+left+"px",
		top:"-"+top+"px"
		},2000,function(){
			 var width1 = $(window).width()*0.35;
			 var height1 =$(window).height()*0.5;
			 console.log(width1);
			$(this).css({width:width1,height:height1}).hide();
		});

}
/**********HTML初始化后为其按钮绑定函数**********/


