Ext.namespace('org.cloundland.erp');

// 标题常量
org.cloundland.erp.Header = Ext.emptyFn;
org.cloundland.erp.Header.ERR_TITLE = '错误提示';

// 消息常量

// 验证常量
org.cloundland.erp.Validate = Ext.emptyFn;
org.cloundland.erp.Validate.NOT_NULL = '此值不能为空!';
org.cloundland.erp.Validate.MAX_LENGTH = '允许输入的最大长度为:{0}';


// 不为空验证
Ext.apply(Ext.form.VTypes, {
	NotNull:function(value, field){	
		//alert(org.cloundland.erp.Validate.NOT_NULL);
		return false;
	},
	NotNullText:'而是看看'
});