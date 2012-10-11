/**
  *
  * @Title SysMenu.java
  * @Package org.cloudland.dynamic.erp.dao.sys.entity
  * @Description <p>TODO</p>
  * @author Administrator
  * @date 2012-10-11
  * @version 1.0
  */
package org.cloudland.dynamic.erp.dao.sys.entity;

/**
 * 系统菜单描述类
 * @ClassName SysMenu
 * @Description TODO
 * @author Administrator
 * @date 2012-10-11 上午11:48:52
 *
 */
public class SysMenu {

	/**
	  * @Fields id 编号
	  */
	private String id;
	
	/**
	  * @Fields name 名称
	  */
	private String name;
	
	/**
	  * @Fields adderssId 地址编号
	  */
	private String adderssId;
	
	/**
	  * @Fields parentId 父级菜单编号
	  */
	private String parentId;

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

	public String getAdderssId() {
		return adderssId;
	}

	public void setAdderssId(String adderssId) {
		this.adderssId = adderssId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
}
