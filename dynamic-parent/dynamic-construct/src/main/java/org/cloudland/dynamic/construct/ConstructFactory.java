/**
  *
  * @Title ConstructFactory.java
  * @Package org.cloudland.dynamic.construct
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-8-2
  * @version 1.0
  */
package org.cloudland.dynamic.construct;

import org.cloudland.dynamic.construct.model.DataConstructManager;

/**
 * 构建工厂类
 * @ClassName ConstructFactory
 * @Description TODO
 * @author Lei
 * @date 2012-8-2 下午04:39:57
 *
 */
public class ConstructFactory {
	
	/**
	  * 构造函数 
	  */
	private ConstructFactory(){}
	
	public DataConstructManager getDataConstructManager (){
		return DataConstructManager.getInstance();
	}

}
