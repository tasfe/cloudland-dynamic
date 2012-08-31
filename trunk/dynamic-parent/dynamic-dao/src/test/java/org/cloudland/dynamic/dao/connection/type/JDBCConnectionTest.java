/**
  *
  * @Title JDBCConnectionTest.java
  * @Package org.cloudland.dynamic.dao.connection.type
  * @Description <p>TODO</p>
  * @author Administrator
  * @date 2012-8-31
  * @version 1.0
  */
package org.cloudland.dynamic.dao.connection.type;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * JDBC连接测试类
 * @ClassName JDBCConnectionTest
 * @Description TODO
 * @author Administrator
 * @date 2012-8-31 下午03:08:01
 *
 */
public class JDBCConnectionTest {

	/**
	 *
	 * @Title setUp
	 * @Description TODO
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link org.cloudland.dynamic.dao.connection.type.JDBCConnection#createConnection()}.
	 */
	@Test
	public void testCreateConnection() {
	}

	/**
	 * Test method for {@link org.cloudland.dynamic.dao.connection.Connection#get()}.
	 */
	@Test
	public void testGet() {
		JDBCConnection conn = new JDBCConnection();
		assertNotNull("JDBC创建数据库连接失败!", conn.get());
	}

}
