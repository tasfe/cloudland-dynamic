/**
  *
  * @Title StyleModel.java
  * @Package org.cloudland.dynamic.construct.model.bean
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-8-2
  * @version 1.0
  */
package org.cloudland.dynamic.construct.model.bean;

import java.util.List;

/**
 * 样式模型描述类
 * @ClassName StyleModel
 * @Description TODO
 * @author Lei
 * @date 2012-8-2 下午05:07:56
 *
 */
public class StyleModel<E> {

	/**
	  * @Fields id 样式模型编号
	  */
	private String id;
	
	/**
	  * @Fields name 样式模型名称
	  */
	private String name;
	
	/**
	  * @Fields htmlElements HTML元素类
	  */
	private List<E> htmlElements;

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

	public List<E> getHtmlElements() {
		return htmlElements;
	}

	public void setHtmlElements(List<E> htmlElements) {
		this.htmlElements = htmlElements;
	}
	
}
