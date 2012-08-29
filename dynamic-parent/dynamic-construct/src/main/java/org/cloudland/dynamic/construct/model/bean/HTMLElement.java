/**
  *
  * @Title ParameterStyleDescribe.java
  * @Package org.cloudland.dynamic.construct.model.bean
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-8-15
  * @version 1.0
  */
package org.cloudland.dynamic.construct.model.bean;

/**
 * HTML显示元素描述类
 * @ClassName ParameterStyleDescribe
 * @Description TODO 暂缺数据的正确性检查描述类
 * @author Lei
 * @date 2012-8-15 下午8:43:20
 *
 */
public class HTMLElement {
	
	/**
	  * @Fields dataParameterId 数据参数编号
	  */
	private String dataParameterId;
	
	/**
	  * @Fields htmlStyle Html样式描述
	  */
	private HTMLStyle htmlStyle;
	
	public HTMLElement(final String dataParamId, final HTMLStyle htmlStyle){
		this.dataParameterId = dataParamId;
		this.htmlStyle = htmlStyle;
	}

	public String getDataParameterId() {
		return dataParameterId;
	}

	public void setDataParameterId(String dataParameterId) {
		this.dataParameterId = dataParameterId;
	}

	public HTMLStyle getHtmlStyle() {
		return htmlStyle;
	}

	public void setHtmlStyle(HTMLStyle htmlStyle) {
		this.htmlStyle = htmlStyle;
	}
	
}
