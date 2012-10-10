/**
  *
  * @Title SysColumn.java
  * @Package org.cloudland.dynamic.erp.dao.sys.entity
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-10-10
  * @version 1.0
  */
package org.cloudland.dynamic.erp.dao.sys.entity;

/**
 * 系统列信息描述类
 * @ClassName SysColumn
 * @Description TODO
 * @author Lei
 * @date 2012-10-10 下午6:46:17
 *
 */
public class SysColumn {
	
	/**
	  * @Fields id 编号
	  */
	private String id;
	
	/**
	  * @Fields name 列名称
	  */
	private String name;
	
	/**
	  * @Fields physicalName 物理名称
	  */
	private String physicalName;
	
	/**
	  * @Fields valueType 值类型
	  */
	private String valueType;
	
	/**
	  * @Fields length 长度
	  */
	private String length;
	
	/**
	  * @Fields status 状态
	  */
	private String status;
	
	/**
	  * @Fields tableId 表编号
	  */
	private String tableId;

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

	public String getPhysicalName() {
		return physicalName;
	}

	public void setPhysicalName(String physicalName) {
		this.physicalName = physicalName;
	}

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}
	
}
