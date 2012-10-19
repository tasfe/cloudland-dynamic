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
			store: new Ext.data.JsonStore({idProperty:'key', fields:['key', 'value'], data: _config.data})
		};
		
		// 将 _config 内容拷贝到 config 中
		Ext.apply(config, _config);	
		
		org.cloundland.erp.component.LComboBox.superclass.constructor.call(this, config);
	}// constructor End

});
Ext.reg('icombo', org.cloundland.erp.component.LComboBox); // 注册该组建


// 编辑表格列模型类
org.cloundland.erp.component.EditGridColumn = Ext.extend(Ext.grid.ColumnModel, {

	// constructor Begin
	constructor:function(_config) {
		
		var colModel = new Array(_config.columns.length); 		
		
		for (i = 0; i < _config.columns.length; i++) {		
			//iWrite("===" + org.cloundland.erp.component.EditGridColumn.getColunmStyle(_config.columns[i]));		
			colModel[i] = _config.columns[i].editType ? org.cloundland.erp.component.EditGridColumn.getColunmStyle(_config.columns[i]) : _config.columns[i];
			//iWrite(_config.columns[i]);	
		}
		
		//iWrite(colModel);
		var config =
		{
			defaults:{
				sortable:false, // 不可以排序
				resizable:false // 不可以调整宽度
			},
			columns:colModel
		}
		// 将 _config 内容拷贝到 config 中
		Ext.apply(config, _config);	
		
		org.cloundland.erp.component.EditGridColumn.superclass.constructor.call(this, config);
	}// constructor End
	
});
// 根据类型名称创建列显示样式
org.cloundland.erp.component.EditGridColumn.getColunmStyle = function(columnObj){		
		var col;
		
		var dataindex = columnObj.id;
		var typeName = columnObj.editType;
		if (typeName == "field") { // 文本方式编辑
			col = 
			{
				dataIndex:dataindex,
				editor:new Ext.form.TextField({
					allowBlank:false,
					blankText:'此值不可以为空',
					blankText:org.cloundland.erp.Validate.NOT_NULL,
					maxLength:2,
					maxLengthText:org.cloundland.erp.Validate.MAX_LENGTH,
					listeners:{
						'blur':function(_this){
							alert(_this.id);
							_this.focus();
							
						}
					}				
					//vtype:'NotNull'
				})
			};		
		} else if (typeName == "combo") { // 下拉菜单方式便捷
			col = 
			{
				dataIndex:dataindex,
				renderer:function(_value, _metadata, _rowRecord, _rowIndex, _colIndex, _store){										
						var coBoxKey = _rowRecord.get(columnObj.id);	
						var record = this.editor.getStore().getById(coBoxKey);									
						return record ? record.get('value') : '';
				},
				// use shorthand alias defined above
				editor:{
					xtype:'icombo',																		
					data:columnObj.editData
				}
			};
		}
		
		// 将扩充的类型添加到原对象中
		Ext.apply(columnObj, col); 
		
}


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