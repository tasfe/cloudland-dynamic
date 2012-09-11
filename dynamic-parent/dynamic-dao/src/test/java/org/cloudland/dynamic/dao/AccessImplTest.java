package org.cloudland.dynamic.dao;

import static org.junit.Assert.*;

import org.cloudland.dynamic.core.dao.Access;
import org.cloudland.dynamic.core.dao.bean.Column;
import org.cloudland.dynamic.core.dao.bean.Table;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
  * 
  * @ClassName AccessImplTest
  * @Description TODO
  * @author Lei
  * @date 2012-8-31 下午10:52:01
  *
  */
public class AccessImplTest {
	
	/**
	  * @Fields access 数据库操作对象
	  */
	private Access access;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		access = AccessFactory.openAccess();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAccessImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetConnection() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		
		Column col = new Column();
		col.setName("name");
		col.setType("varchar2");
		col.setLength(50);
		col.setRemark("cc");
		col.setEmpty(false);
		col.setPrimaryKey(false);
		
		access.insert(col);
	
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testExecuteUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testExecuteQuery() {
		fail("Not yet implemented");
	}

}
