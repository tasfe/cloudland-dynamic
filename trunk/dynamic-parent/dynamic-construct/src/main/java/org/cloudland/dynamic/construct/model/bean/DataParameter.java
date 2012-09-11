/**
  *
  * @Title Parameter.java
  * @Package org.cloudland.dynamic.construct.model
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-8-2
  * @version 1.0
  */
package org.cloudland.dynamic.construct.model.bean;

/**
 * 参数信息类
 * @ClassName Parameter
 * @Description TODO
 * @author Lei
 * @date 2012-8-2 下午04:24:31
 *
 */
public class DataParameter {

	/**
	  * @Fields id 参数编号
	  */
	private String id;
	
	/**
	  * @Fields fieldName 类字段属性名
	  */
	private String fieldName;
	
	/**
	  * @Fields name 参数名称
	  */
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
}
