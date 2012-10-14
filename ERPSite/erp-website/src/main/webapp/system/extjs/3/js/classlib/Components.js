// 自定义组建类
Ext.namespace('org.cloundland.erp.component');

// 选择菜单自定义主键类
org.cloundland.erp.component.LComboBox = Ext.extend(Ext.form.ComboBox, {
	// constructor Begin
	constructor:function(_config){
			

		var config = 
		{
			editable:false, // 不允许编辑
			triggerAction:'all', // 显示所有可选项
			emptyText:'请选择...', // 选择提示信息
			selectOnFocus:false,
			displayField:'value',
			valueField:'key',
			mode:'local',
			store: new Ext.data.JsonStore({fields:['key', 'value'], data: _config.data})
		};
		
		// 将 _config 内容拷贝到 config 中
		Ext.apply(config, _config);	
		
		org.cloundland.erp.component.LComboBox.superclass.constructor.call(this, config);
	}// constructor End

});
Ext.reg('icombo', org.cloundland.erp.component.LComboBox); // 注册该组建

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