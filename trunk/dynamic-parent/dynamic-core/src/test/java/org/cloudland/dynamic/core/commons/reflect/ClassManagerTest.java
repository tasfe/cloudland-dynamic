package org.cloudland.dynamic.core.commons.reflect;

import static org.junit.Assert.*;

import org.cloudland.dynamic.core.commons.reflect.MethodManager.MethodEntry;
import org.cloudland.dynamic.core.dao.bean.Table;
import org.junit.Before;
import org.junit.Test;

public class ClassManagerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetMethodEntry() {
		
		Table table = new Table();
		table.setName("测试表");
		
		MethodManager manager = new MethodManager(table);
		MethodEntry entry = manager.getMethodEntry("name");
		assertEquals("获取结果与设置结果不一致!", "测试表", entry.get());
		
		entry.set("TestTable");
		assertEquals("获取结果与设置结果不一致!", "TestTable", table.getName());
		
	}
	
	@Test
	public void testGetAllMethodEntry() {
		
		Table table = new Table();
		//table.setName("测试表");
		
		MethodManager manager = new MethodManager(table);
		for (MethodEntry entry : manager.getAllMethodEntry()) {
			System.out.println(entry.name());
		}
		
	}

}
