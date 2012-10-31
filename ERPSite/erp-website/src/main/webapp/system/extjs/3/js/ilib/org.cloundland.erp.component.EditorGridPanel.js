// 自定义组建类
Ext.namespace('org.cloundland.erp.component');

// 编辑表格
org.cloundland.erp.component.EditorGridPanel = Ext.extend(Ext.grid.EditorGridPanel, {
	
	// constructor Begin
	constructor:function(_config) {

		// 获取配置中的数据源		
		var store = _config.store;
		// 判断传入的列模型是否为数组，如果是数组采取自定义方法处理，不是采用Ext的默认方法处理
		if (Ext.isArray(_config.colModel)) {
			// 获取传入的列模型
			var colModel = _config.colModel;
			// 没有定义数据源则默认定义Json格式数据源
			if (Ext.isEmpty(store)) {
				// json 字段
				var jsonFields = new Array(colModel.length);		
				for (i = 0; i < colModel.length; i++) {
					//iWrite(_config.colModel[i]);			
					jsonFields[i] = colModel[i].id;
				}		
				// json 数据格式
				store = new Ext.data.JsonStore({fields:jsonFields});
			}			
			// 定义列模型对象
			_config.colModel = new org.cloundland.erp.component.EditGridColumn({columns:colModel});		
		} else {			
			// 没有定义数据源则默认定义Json格式数据源
			if (Ext.isEmpty(store)) {
				// json 字段
				var jsonFields = [];
				for (i = 0; i < _config.colModel.getColumnCount(); i++) {	
					if (!Ext.isEmpty(_config.colModel.columns[i].editType)) {
						jsonFields.push(_config.colModel.columns[i].id);
					}			
				}		
				// json 数据格式
				store = new Ext.data.JsonStore({fields:jsonFields});
			}
		}
		
		// 默认配置
		var config = 
		{
			enableHdMenu:false, // 禁用菜单上的按钮
			border:false, // 隐藏Panel边框					
			autoHeight:false,
			columnLines:true, // 显示表格线
			disableSelection:true,
			store:store		
		};
		
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
			//iWrite(colModel[i]);	
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
					//blankText:'此值不可以为空',
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
