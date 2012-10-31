Ext.onReady(function(){
	Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
	
	var url = '/treeData1.txt';
	
	var viewport = new Ext.Viewport({
		layout:'border',
		items:
		[
			// create instance immediately
			new Ext.BoxComponent({
				region: 'north',
				height: 60, // give north and south regions a height
				autoEl: {
					tag: 'div',
					html:'<p>ERP后台管理系统</p>'
				}
			}), 
			{
                region:'west',
                //id: 'west-panel', // see Ext.getCmp() below
                title:'管理平台',
                split: true,
                width:200,
                minSize:175,
                maxSize:200,
                //collapsible: true,
                margins:'0 0 5 5',
                layout: {
                    type:'accordion',
                    animate:true,
					titleCollapse:false
                },
                items: 
				[					
					{								
						xtype:'treepanel',
						title:'系统设置',
						border:false,
						autoScroll:true,
						split:true,			
						root:new Ext.tree.AsyncTreeNode({
							//id:'root',
							text:'根节点',
							loader:new Ext.tree.TreeLoader({url:url})
							/*expanded:true,
							children:
							[
								{
									text:'表结构管理',
									leaf:true,
									href:'#',
									hrefTarget:''
								}, 
								{
									text:'显示样式管理',
									leaf:true
								}, 
								{
									text:'验证规则管理',
									leaf:true
								},
								{
									text:'数据映射关系管理',
									leaf:true
								},
								{
									text:'菜单管理',
									leaf:true
								},
								{
									text:'请求地址管理',
									leaf:true
								},
								{
									text:'显示视图管理',
									leaf:true
								},
								{
									text:'数字字典',
									leaf:true
								}
							]*/
						})
						//rootVisible:false
					},
							
					{
						title:'暂未开发',
						//html: '<p>Some settings in here.</p>',
						border:false,
						disabled:true
						//iconCls: 'settings'
					}
				]
            },
			{
				// lazily created panel (xtype:'panel' is default)
				region:'center',
                margins:'0 5 5 0',
                //cls:'empty',
                //bodyStyle:'background:#f1f1f1',
                html:'<br/><br/>&lt;管理工具&gt;'
			}
		]
	
	});
























});