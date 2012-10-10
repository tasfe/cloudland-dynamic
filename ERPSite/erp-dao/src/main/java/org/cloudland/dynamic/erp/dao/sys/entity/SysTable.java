/**
  *
  * @Title SysTable.java
  * @Package org.cloudland.dynamic.erp.dao.sys.entity
  * @Description <p>TODO</p>
  * @author Administrator
  * @date 2012-10-10
  * @version 1.0
  */
package org.cloudland.dynamic.erp.dao.sys.entity;

import java.util.List;

/**
 * 系统表结构信息描述类
 * @ClassName SysTable
 * @Description TODO
 * @author Lei
 * @date 2012-10-10 下午05:25:53
 *
 */
public class SysTable {

	/**
	  * @Fields id 编号
	  */
	private String id;
	
	/**
	  * @Fields name 表名称
	  */
	private String name;
	
	/**
	  * @Fields physicalName 物理名称
	  */
	private String physicalName;
	
	/**
	  * @Fields status 状态
	  */
	private String status;
	
	/**
	  * @Fields type 表类型
	  */
	private String type;
	
	/**
	  * @Fields columns 列对象集合
	  */
	private List<SysColumn> columns;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<SysColumn> getColumns() {
		return columns;
	}

	public void setColumns(List<SysColumn> columns) {
		this.columns = columns;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
