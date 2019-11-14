function getContextPath(){
	/*
	 * 假如网址是http://localhost:8080/ErGe/login/login.jsp
	 * 然后window.location.href的值就是上面的网址 
	 */
	var path=window.location.href;
	var lastIndex=path.indexOf("ErGe");
	path=path.substring(0,lastIndex+4);
	return path;
}
//js方法：序列化表单 			
function serializeForm(form){//人员查询
	var obj = {};
	$.each(form.serializeArray(),function(index){
		if(obj[this['name']]){
			obj[this['name']] = obj[this['name']] + ','+this['value'];
		} else {
			obj[this['name']] =this['value'];
		}
	});
	return obj;
}
