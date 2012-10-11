/**
  *
  * @Title ViewModel.java
  * @Package org.cloudland.dynamic.erp.dao.sys.entity
  * @Description <p>TODO</p>
  * @author Administrator
  * @date 2012-10-11
  * @version 1.0
  */
package org.cloudland.dynamic.erp.dao.sys.entity;

/**
 * 视图模型描述类
 * @ClassName ViewModel
 * @Description TODO
 * @author Lei
 * @date 2012-10-11 上午09:14:39
 *
 */
public class ViewModel {

	/**
	  * @Fields id 编号
	  */
	private String id;
	
	/**
	  * @Fields viewName 视图名称
	  */
	private String viewName;
	
	/**
	  * @Fields viewType 视图类型
	  */
	private String viewType;
	
	/**
	  * @Fields viewModeURL 视图模型地址
	  */
	private String viewModeURL;
	
	/**
	  * @Fields dataSourceType 数据源类型
	  */
	private String dataSourceType;
	
	/**
	  * @Fields dataSource 数据源
	  */
	private String dataSource;
	
	/**
	  * @Fields viewMaxNumber 页面显示最大参数
	  */
	private String viewMaxNumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public String getViewType() {
		return viewType;
	}

	public void setViewType(String viewType) {
		this.viewType = viewType;
	}

	public String getViewModeURL() {
		return viewModeURL;
	}

	public void setViewModeURL(String viewModeURL) {
		this.viewModeURL = viewModeURL;
	}

	public String getDataSourceType() {
		return dataSourceType;
	}

	public void setDataSourceType(String dataSourceType) {
		this.dataSourceType = dataSourceType;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getViewMaxNumber() {
		return viewMaxNumber;
	}

	public void setViewMaxNumber(String viewMaxNumber) {
		this.viewMaxNumber = viewMaxNumber;
	}
	
}
