/**
  *
  * @Title ConstructType.java
  * @Package org.cloudland.dynamic.construct.model
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-8-2
  * @version 1.0
  */
package org.cloudland.dynamic.construct.model;

/**
 * 结构类型接口
 * @ClassName ConstructType
 * @Description TODO
 * @author Lei
 * @date 2012-8-2 下午05:30:08
 *
 */
public interface Type {

	/**
	  * HTML显示样式类型
	  * @ClassName DisplayType
	  * @Description TODO
	  * @author Lei
	  * @date 2012-8-2 下午05:30:56
	  *
	  */
	enum HTMLDisplayType implements Type {
		TEXT, SELECT, HIDDEN, PASSWORD, RADIO, CHECKBOX;
	}
}
