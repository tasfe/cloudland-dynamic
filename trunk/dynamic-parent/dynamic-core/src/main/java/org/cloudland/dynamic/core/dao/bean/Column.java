/**
  *
  * @Title Column.java
  * @Package org.cloudland.dynamic.core.dao.bean
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-8-29
  * @version 1.0
  */
package org.cloudland.dynamic.core.dao.bean;

/**
 * 数据库列描述对象
 * @ClassName Column
 * @Description TODO
 * @author Lei
 * @date 2012-8-29 下午8:46:55
 *
 */
public class Column {

	/**
	  * @Fields name 列名
	  */
	private String name;
	
	/**
	  * @Fields type 类型
	  */
	private String type;
	
	/**
	  * @Fields length 长度
	  */
	private int length;
	
	/**
	  * @Fields isNull 是否允许为空
	  */
	private boolean isNull;
	
	/**
	  * @Fields isPrimary 是否是主键列
	  */
	private boolean isPrimary;
	
	/**
	  * @Fields remark 备注
	  */
	private String remark;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean isNull() {
		return isNull;
	}

	public void setNull(boolean isNull) {
		this.isNull = isNull;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
