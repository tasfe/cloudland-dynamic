// 自定义组建类
Ext.namespace('org.cloundland.erp.component');

// 编辑表格
org.cloundland.erp.component.EditorGridPanel = Ext.extend(Ext.grid.EditorGridPanel, {
	
	// constructor Begin
	constructor:function(_config) {
		
		var col = new Array(_config.colModel.length);	
		
		// json 字段
		var jsonFields = new Array(_config.colModel.length);		
		for (i = 0; i < _config.colModel.length; i++) {
			//iWrite(_config.colModel[i]);			
			jsonFields[i] = _config.colModel[i].id;
			col[i] = _config.colModel[i];
		}		
		// json 数据格式
		var jsonStore = new Ext.data.JsonStore({fields:jsonFields});
		
		var colModel = new org.cloundland.erp.component.EditGridColumn({
			columns:col
		});
		
		var config = 
		{
			enableHdMenu:false, // 禁用菜单上的按钮
			border:false, // 隐藏Panel边框					
			autoHeight:false,
			columnLines:true, // 显示表格线
			disableSelection:true,
			store:jsonStore,
			colModel:colModel
			//clicksToEdit: 1,			
		};
		
		Ext.copyTo(_config, config, 'colModel');
		// 将 _config 内容拷贝到 config 中
		Ext.apply(config, _config);				
		org.cloundland.erp.component.EditorGridPanel.superclass.constructor.call(this, config);	
	}// constructor End


});
Ext.reg('ieditorgrid', org.cloundland.erp.component.EditorGridPanel); // 注册该组建

// 编辑表格列模型类
org.cloundland.erp.component.EditGridColumn = Ext.extend(Ext.grid.ColumnModel, {

	// constructor Begin
	constructor:function(_config) {
		
		var colModel = new Array(_config.columns.length); 		
		
		for (i = 0; i < _config.columns.length; i++) {		
			//iWrite("===" + org.cloundland.erp.component.EditGridColumn.getColunmStyle(_config.columns[i]));		
			colModel[i] = _config.columns[i].editType ? org.cloundland.erp.component.EditGridColumn.getColunmStyle(_config.columns[i]) : _config.columns[i];
			iWrite(colModel[i]);	
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
					maxLengthText:org.cloundland.erp.Validate.MAX_LENGTH
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
		
		return columnObj;
		
}
