/**
  *
  * @Title UUID32Test.java
  * @Package org.cloudland.dynamic.core.commons.number
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-8-14
  * @version 1.0
  */
package org.cloudland.dynamic.erp.core.comons.number;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @ClassName UUID32Test
 * @Description TODO
 * @author Lei
 * @date 2012-8-14 下午8:22:35
 *
 */
public class UUID32Test {

	/**
	 * Test method for {@link org.cloudland.dynamic.core.commons.number.UUID32#get()}.
	 */
	@Test
	public void testGet() {
		String uuid = UUID32.get();
		System.out.println("UUID 输出：" + uuid);
		assertNotNull("没有获取到 UUID32 产生的编号！", uuid);
	}

}
