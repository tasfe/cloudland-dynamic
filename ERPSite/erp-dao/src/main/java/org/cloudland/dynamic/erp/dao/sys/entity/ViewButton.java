/**
  *
  * @Title ViewButton.java
  * @Package org.cloudland.dynamic.erp.dao.sys.entity
  * @Description <p>TODO</p>
  * @author Administrator
  * @date 2012-10-11
  * @version 1.0
  */
package org.cloudland.dynamic.erp.dao.sys.entity;

/**
 * 视图按钮描述类
 * @ClassName ViewButton
 * @Description TODO
 * @author Lei
 * @date 2012-10-11 上午11:24:10
 *
 */
public class ViewButton {

	/**
	  * @Fields id 编号
	  */
	private String id;
	
	/**
	  * @Fields viewId 视图编号
	  */
	private String viewId;
	
	/**
	  * @Fields name 按钮名称
	  */
	private String name;
	
	/**
	  * @Fields event 按钮事件
	  */
	private String event;
	
	/**
	  * @Fields order 按钮顺序
	  */
	private String order;

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

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getViewId() {
		return viewId;
	}

	public void setViewId(String viewId) {
		this.viewId = viewId;
	}
	
}
