/**
  *
  * @Title StyleParameter.java
  * @Package org.cloudland.dynamic.construct.model.bean
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-8-2
  * @version 1.0
  */
package org.cloudland.dynamic.construct.model.bean;

import org.cloudland.dynamic.construct.model.Type;

/**
 * 参数的HTML样式描述类
 * @ClassName StyleParameter
 * @Description TODO
 * @author Lei
 * @date 2012-8-2 下午05:08:34
 *
 */
public class HTMLStyle {

	/**
	  * @Fields id 样式编号
	  */
	private String id;
	
	/**
	  * @Fields displayName 显示名称
	  */
	private String displayName;
	
	/**
	  * @Fields displayType 显示样式 
	  */
	private Type displayType;
	
	/**
	  * @Fields width 宽度
	  */
	private int width;
	
	/**
	  * @Fields height 高度
	  */
	private int height;
	
	/**
	  * @Fields order 显示顺序
	  */
	private int order;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Type getDisplayType() {
		return displayType;
	}

	public void setDisplayType(Type displayType) {
		this.displayType = displayType;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
}
