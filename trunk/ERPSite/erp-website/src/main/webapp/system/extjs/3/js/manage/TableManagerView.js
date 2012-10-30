// JavaScript Document
Ext.onReady(function(){
	
	Ext.QuickTips.init();
	// turn on validation errors beside the field globally
    Ext.form.Field.prototype.msgTarget = 'side';
	//Ext.MessageBox.alert('Status', 'Changes saved successfully.');

	var tabs = new Ext.TabPanel({
        //renderTo:Ext.getBody(),
        //width:450,
		height:290,
        activeTab:0,
		minButtonWidth:100,
        //frame:true,
		//plain:true,
      	defaults:{autoHeight:true, anchor:"100%"}, 
        items:[
            {
				title:'常规',
				defaults:{autoHeight:true, bodyStyle:'padding:10 14 10 14'}, 
				//xtype:'form',				
				//frame:true,				
				items:
				[
					{
						xtype:'form',
						//height:300,
						labelAlign: 'top',
						//height:300,
						defaults:{anchor:"99%, 100%", autoHeight:true, bodyStyle:'padding:0 6 0 6'},
						//autoHeight:false,
						border:false,		
						items:
						[
							{
								xtype:'textfield', 
								fieldLabel:'名称', 
								emptyText:'建议使用中文',
								name:'TableName',
								allowBlank:false,
								blankText:org.cloundland.erp.Validate.NOT_NULL,
								maxLength:2,
								maxLengthText:org.cloundland.erp.Validate.MAX_LENGTH
								//vtype:'NotNull'
								//vtypeText:'不能为空'
							},
							{
								xtype:'icombo',
								fieldLabel:'状态', 
								name:'TableStatus',						
								data:[{key:'0', value:'禁用'},{key:'1', value:'正常'}],
								value:'1'
							},
							{
								xtype:'fieldset',
								title:'属性',
								defaults:{anchor:"98%"},
								items:
								[
									{
										xtype:'textfield', 
										fieldLabel:'物理名称', 
										emptyText:'数据库表名',
										name:'TablePhysicalName',
										allowBlank:false,										
										blankText:org.cloundland.erp.Validate.NOT_NULL,
										maxLength:2,
										maxLengthText:org.cloundland.erp.Validate.MAX_LENGTH
									},							
									{
										xtype:'icombo', 
										fieldLabel:'类型', 
										name:'TableType', 
										data:[{key:'0', value:'表'},{key:'1', value:'视图'}],
										value:'1'
									}
								]
							}
						]
					}
									
				]
			},
            {
				title: '列定义',
				xtype:'form',
				//height:300,
				defaults:{anchor:"100%, 100%", autoHeight:true},
				autoHeight:false,		
				//frame:true,
				labelAlign: 'top',
				items:
				[
					{
						xtype:'ieditorgrid',
						name:'ieditGrid',						
						clicksToEdit: 1,		
						
						colModel:/*new org.cloundland.erp.component.EditGridColumn({
							columns:*/
							[
								{
									id:'name',
									header:'名称',
									editType:'field',
									width:120
								},
								{
									id:'colunmPhysicalName',
									header: '物理名称',
									editType:'field',
									width:160
								},
								{
									id:'valueType',
									header: '类型',									
									width:60,
									editType:'combo',
									editData:[{key:'0', value:'字符串'},{key:'1', value:'数字'}]
								},
								{
									id: 'length',
									header: '长度',
									editType:'field',
									width:50
								},
								{
									id: 'status',
									header: '状态',
									dataIndex: 'status',
									width:60,
									editType:'combo',
									editData:[{key:'0', value:'禁用'},{key:'1', value:'正常'}]
								},
								{
									xtype: 'actioncolumn',
									width: 30,
									items: [{
										icon:'js/extjs/3.3.1/images/delete.gif',  // Use a URL in the icon config
										tooltip:'删除',
										handler:function(_grid, _rowIndex, _colIndex) {
											alert(1);											
										}
									}]									 
								}								
							],
						//}),
						
						/*store:new Ext.data.JsonStore({
							fields:
							[
								'name',
								'colunmPhysicalName',
								'valueType',
								'length',
								'status'
							]						
						}),*/
										
						listeners:
						{
							'render':function(_this){								
															
								var grid = _this;
								var store = grid.getStore();
								//alert(grid.getStore().recordType);
								
								// access the Record constructor through the grid's store
								var Plant = store.recordType;
								var p = new Plant({
									name: '',
									colunmPhysicalName: '',
									valueType:'',
									length:'',
									status:''
								});
								
								//grid.stopEditing();
								//alert(1);
								store.insert(0, p);
								//grid.startEditing(0, 0);
							},
							'rowclick':function(_grid, _rowIndex, _event){
								
								//iWrite();
								if (_rowIndex > 0) {
									var record = _grid.getStore().getAt(_rowIndex - 1);
									alert(record.isValid());
									alert(record.get("name"));
								}
								
								 
								var store = _grid.getStore();													
								var rowsCount = store.getCount();								
																														
								if (_rowIndex == (--rowsCount)) {
									var Plant = store.recordType;
									var p = new Plant({
										name: '',
										colunmPhysicalName: '',
										valueType:'',
										length:'',
										status:''
									});
									//_grid.stopEditing();
									store.insert(rowsCount + 1, p);
									
									
									//if (_columnIndex > 0) {
										//_grid.startEditing(rowsCount, 1);
									//}
									//_grid.getSelectionModel().selectNext();
								}
								
								//iWrite(_grid.getStore().getAt(0).get('valueType'));
															
							}
						}
											
					}
				]
			}
        ]
    });
	
	
	var win = new org.cloundland.erp.component.Window({
                //xtype:'iwindows',
				title:'数据结果管理',
                //layout:'fit',
                width:500,
                //height:350,
                closeAction:'hide',
                //plain: true,
				
				
				items:[tabs],
				
				buttons: [{
                    text:'Submit',
                    disabled:true
                },{
                    text: 'Close',
                    handler: function(){
                        win.hide();
                    }
                }]
	}).show();


})