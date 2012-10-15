// JavaScript Document
Ext.onReady(function(){
	
	Ext.QuickTips.init();

	//Ext.MessageBox.alert('Status', 'Changes saved successfully.');

	var tabs = new Ext.TabPanel({
        renderTo:Ext.getBody(),
        //width:450,
		//height: 500,
        activeTab:1,
		minButtonWidth:100,
        //frame:true,
		plain:true,
      	defaults:{autoHeight:true}, 
        items:[
            {
				title:'常规',
				defaults:{autoHeight:true, bodyStyle:'padding:10px'}, 
				//xtype:'form',				
				//frame:true,				
				items:
				[
					{
						xtype:'form',
						height:300,
						labelAlign: 'top',
						height:300,
						defaults:{anchor:"100%", autoHeight:true},
						autoHeight:false,
						border:false,		
						items:
						[
							{
								xtype:'field', 
								fieldLabel:'名称[建议使用中文]', 
								name:'TableName'
							},
							{
								xtype:'icombo',
								fieldLabel:'状态', 
								name:'TableStatus',										
								data:[{key:'1', value:'测试1'},{key:'2', value:'测试2'}]
							},
							{
								xtype:'fieldset',
								title:'属性',
								defaults:{anchor:"100%"},
								items:
								[
									{xtype:'field', fieldLabel:'物理名称', name:'TablePhysicalName'},							
									{xtype:'icombo', fieldLabel:'类型', name:'TableType', data:[{key:'1', value:'表'},{key:'2', value:'视图'}]}
								]
							}
						]
					}
									
				]
			},
            {
				title: '列定义',
				xtype:'form',
				height:300,
				defaults:{anchor:"100%", autoHeight:true},
				autoHeight:false,		
				//frame:true,
				labelAlign: 'top',
				items:
				[
					{
						xtype:'editorgrid',
						name:'editGrid',
						border:false,
						//boxMaxHeight: 100,
						height: 300,
						//frame: true,
						autoHeight:false,
						columnLines:true,
						disableSelection:true,
						clicksToEdit: 1,
						
						//enableColumnHide:false,
						
						enableHdMenu:false,
						
						colModel:new Ext.grid.ColumnModel({
						   	defaults: {
								sortable: true // columns are not sortable by default           
							},
							columns:
							[
								{
									id: 'name',
									header: '名称',
									dataIndex: 'name',
									width: 120,
									// use shorthand alias defined above
									editor: new Ext.form.TextField({
										allowBlank: false
									})
								},
								{
									id: 'colunmPhysicalName',
									header: '物理名称',
									dataIndex: 'colunmPhysicalName',
									width: 160,
									// use shorthand alias defined above
									editor: new Ext.form.TextField({
										allowBlank: false
									})
								},
								{
									id: 'valueType',
									header: '类型',
									dataIndex: 'valueType',
									width: 60,
									renderer:function(_value, _metadata, _rowRecord, _rowIndex, _colIndex, _store){										
											var coBoxKey = _rowRecord.get('valueType');	
											var record = this.editor.getStore().getById(coBoxKey);									
											return record ? record.get('value') : '';
										},
									// use shorthand alias defined above
									editor: {
										xtype:'icombo',																		
										data:[{key:'0', value:'字符串'},{key:'1', value:'数字'}]
									}
								},
								{
									id: 'length',
									header: '长度',
									dataIndex: 'length',
									width: 50,
									// use shorthand alias defined above
									editor: new Ext.form.TextField({
										allowBlank: false
									})
								},
								{
									id: 'status',
									header: '状态',
									dataIndex: 'status',
									width: 60,
									// use shorthand alias defined above
									renderer:function(_value, _metadata, _rowRecord, _rowIndex, _colIndex, _store){										
											var coBoxKey = _rowRecord.get('status');	
											var record = this.editor.getStore().getById(coBoxKey);									
											return record ? record.get('value') : '';
										},
									// use shorthand alias defined above
									editor: {
										xtype:'icombo',																		
										data:[{key:'0', value:'禁用'},{key:'1', value:'正常'}]
									}
								}
							]
						}),
						
						store:new Ext.data.JsonStore({
							fields:
							[
								'name',
								'colunmPhysicalName',
								'valueType',
								'length',
								'status'
							]						
						}),
										
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
							'rowclick':function(_grid, _rowIndex , _event){
								
								//iWrite();
								 
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
									_grid.stopEditing();
									store.insert(rowsCount + 1, p);
									_grid.startEditing(rowsCount, 0);
									
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


})