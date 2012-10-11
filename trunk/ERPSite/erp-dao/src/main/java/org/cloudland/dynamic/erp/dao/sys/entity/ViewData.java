/**
  *
  * @Title ViewData.java
  * @Package org.cloudland.dynamic.erp.dao.sys.entity
  * @Description <p>TODO</p>
  * @author Administrator
  * @date 2012-10-11
  * @version 1.0
  */
package org.cloudland.dynamic.erp.dao.sys.entity;

/**
 * 视图使用的数据描述类
 * @ClassName ViewData
 * @Description TODO
 * @author Lei
 * @date 2012-10-11 上午10:02:25
 *
 */
public class ViewData {
	
	/**
	  * @Fields id 编号
	  */
	private String id;
	
	/**
	  * @Fields viewId 视图编号
	  */
	private String viewId;
	
	/**
	  * @Fields sysColumnId 系统列编号
	  */
	private String sysColumnId;
	
	/**
	  * @Fields styleId 样式编号
	  */
	private String styleId;
	
	/**
	  * @Fields verifyId 验证编号
	  */
	private String verifyId;
	
	/**
	  * @Fields dataMappingId 数据映射编号
	  */
	private String dataMappingId;
	
	/**
	  * @Fields order 顺序
	  */
	private String order;

	public String getViewId() {
		return viewId;
	}

	public void setViewId(String viewId) {
		this.viewId = viewId;
	}

	public String getSysColumnId() {
		return sysColumnId;
	}

	public void setSysColumnId(String sysColumnId) {
		this.sysColumnId = sysColumnId;
	}

	public String getStyleId() {
		return styleId;
	}

	public void setStyleId(String styleId) {
		this.styleId = styleId;
	}

	public String getVerifyId() {
		return verifyId;
	}

	public void setVerifyId(String verifyId) {
		this.verifyId = verifyId;
	}

	public String getDataMappingId() {
		return dataMappingId;
	}

	public void setDataMappingId(String dataMappingId) {
		this.dataMappingId = dataMappingId;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
