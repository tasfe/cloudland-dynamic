/**
  *
  * @Title DataVerify.java
  * @Package org.cloudland.dynamic.erp.dao.sys.entity
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-10-10
  * @version 1.0
  */
package org.cloudland.dynamic.erp.dao.sys.entity;

/**
 * 数据验证规则信息类
 * @ClassName DataVerify
 * @Description TODO
 * @author Lei
 * @date 2012-10-10 下午9:25:48
 *
 */
public class DataVerify {

	/**
	  * @Fields id 编号
	  */
	private String id;
	
	/**
	  * @Fields rule 验证规则
	  */
	private String rule;
	
	/**
	  * @Fields message 提示信息
	  */
	private String message;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
