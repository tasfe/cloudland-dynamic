/**
  *
  * @Title UUID32.java
  * @Package org.cloudland.dynamic.core.commons.number
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-8-14
  * @version 1.0
  */
package org.cloudland.dynamic.core.commons.number;

import java.util.UUID;

/**
 * 
 * @ClassName UUID32
 * @Description TODO
 * @author Lei
 * @date 2012-8-14 下午8:14:15
 *
 */
public abstract class UUID32 {
	
	/**
	  * 获取UUID长度32位号码
	  * @Title get
	  * @Description TODO
	  * @return
	  */
	public static String get(){
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
}
