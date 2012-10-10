package org.cloudland.dynamic.erp.dao.sys;

import static org.junit.Assert.*;

import org.cloudland.dynamic.erp.dao.sys.entity.DataVerify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataVerifyAccessTest {

	private DataVerify verify = null;
	
	@Before
	public void setUp() throws Exception {
		verify = new DataVerify();
		verify.setId("");
		verify.setRule("NotNull");
		verify.setMessage("不能为空！");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		DataVerifyAccess access = new DataVerifyAccess();
		int recode = access.add(verify);
		assertEquals("新增验证规则失败！", 1, recode);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		DataVerifyAccess access = new DataVerifyAccess();
		verify = access.get("A60EFE1C90154BAC92F3052AC388397A");
		assertEquals("没有获取到此编号对应的正确验证规则对象信息！", "NotNull", verify.getRule());
	}

}
