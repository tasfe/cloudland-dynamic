/**
  *
  * @Title DisplayStyle.java
  * @Package org.cloudland.dynamic.erp.dao.sys.entity
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-10-10
  * @version 1.0
  */
package org.cloudland.dynamic.erp.dao.sys.entity;

/**
 * 显示样式描述类
 * @ClassName DisplayStyle
 * @Description TODO
 * @author Lei
 * @date 2012-10-10 下午9:16:13
 *
 */
public class DisplayStyle {

	/**
	  * @Fields id 编号
	  */
	private String id;
	
	/**
	  * @Fields name 样式名称 
	  */
	private String name;
	
	/**
	  * @Fields display_style 显示样式
	  */
	private String displayStyle;
	
	/**
	  * @Fields width 宽度
	  */
	private String width;
	
	/**
	  * @Fields height 高度
	  */
	private String height;

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

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getDisplayStyle() {
		return displayStyle;
	}

	public void setDisplayStyle(String displayStyle) {
		this.displayStyle = displayStyle;
	}
	
}
