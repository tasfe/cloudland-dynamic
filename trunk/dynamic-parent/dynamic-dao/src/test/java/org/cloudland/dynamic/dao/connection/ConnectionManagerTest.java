package org.cloudland.dynamic.dao.connection;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
  * 数据库连接管理测试类
  * @ClassName ConnectionManagerTest
  * @Description TODO
  * @author Administrator
  * @date 2012-8-31 下午03:38:33
  *
  */
public class ConnectionManagerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetConnection() {
		Connection conn = ConnectionManager.getConnection();
		assertNotNull("获取Connection对象失败!", conn.get());
	}

}
