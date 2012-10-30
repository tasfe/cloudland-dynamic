function iWrite(obj){
	
	var htmlWirte = [];
	htmlWirte.push ("<PRE style='font-size:12px;'>");
    htmlWirte.push ("<FONT color=blue>时间: </FONT><FONT color=red>" + new Date() + "</FONT>");
    htmlWirte.push ("<BR/>");
	
    htmlWirte.push(obj + "<br>");
    
	if(obj){
		
		for(index in obj){
			if(typeof obj[index] != 'function'){
				htmlWirte.push(index + ":" + obj[index] + "<br>");
			}
		}
		
	}else{
		htmlWirte.push(null);
	}
	htmlWirte.push("</PRE>");
	
	var wirteInfo = window.open("","errorInfo","");
	wirteInfo.document.write(htmlWirte.join(""));
	
}