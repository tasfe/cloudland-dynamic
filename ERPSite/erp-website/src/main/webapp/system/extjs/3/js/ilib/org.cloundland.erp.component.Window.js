// 自定义组建类
Ext.namespace('org.cloundland.erp.component');

org.cloundland.erp.component.Window = Ext.extend(Ext.Window, {

	// constructor Begin
	constructor:function(_config){
		
		// 根据内嵌容器的宽度重新设置窗体宽度
		var windowHeight = _config.items[0].height + 60;
		
		var config = 
		{
			layout:'fit',
			border:false,
			resizable:false, // 禁止调整大小
			height:windowHeight
		};
		
		// 将 _config 内容拷贝到 config 中
		Ext.apply(config, _config);	
		
		org.cloundland.erp.component.Window.superclass.constructor.call(this, config);
	}// constructor End

});
Ext.reg('iwindows', org.cloundland.erp.component.Window); // 注册该组建