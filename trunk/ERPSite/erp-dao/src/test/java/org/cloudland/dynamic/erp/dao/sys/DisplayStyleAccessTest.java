package org.cloudland.dynamic.erp.dao.sys;

import static org.junit.Assert.*;

import org.cloudland.dynamic.erp.dao.sys.entity.DisplayStyle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DisplayStyleAccessTest {

	/**
	  * @Fields style 样式对象测试数据
	  */
	private DisplayStyle style = null;
	
	@Before
	public void setUp() throws Exception {
		style = new DisplayStyle();
		style.setId("");
		style.setName("测试显示样式");
		style.setDisplayStyle("0");
		style.setWidth("10000");
		style.setHeight("123456");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		DisplayStyleAccess access = new DisplayStyleAccess();
		int recode = access.add(style);
		assertEquals("保存样式数据失败！", 1, recode);
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
		DisplayStyleAccess access = new DisplayStyleAccess();
		DisplayStyle style = access.get("93F757257E054B98B3E6A4DA8D201091");
		assertEquals("查询指定编号的样式信息不存在！", "测试显示样式", style.getName());
	}

}
