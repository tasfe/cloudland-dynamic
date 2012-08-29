/**
  *
  * @Title DataStructure.java
  * @Package org.cloudland.dynamic.construct
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-8-13
  * @version 1.0
  */
package org.cloudland.dynamic.construct.model;

import java.util.Collection;

/**
 * 结构操作，规范接口
 * @ClassName DataStructure
 * @Description TODO
 * @author Lei
 * @date 2012-8-13 下午8:58:22
 *
 */
public interface Structure <P>{

	/**
	  * 获取结构名称
	  * @Title getName
	  * @Description TODO
	  * @return
	  */
	String getName();
	
	/**
	  * 根据参数编号获取该编号指定的参数对象
	  * @Title getParameter
	  * @Description TODO
	  * @param id
	  * @return
	  */
	P getParameter(final String id);
	
	/**
	  * 获取该结构中，包含的所有参数对象
	  * @Title getParameters
	  * @Description TODO
	  * @return
	  */
	Collection<P> getParameters();
	
}
