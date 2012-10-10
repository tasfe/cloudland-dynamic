package org.cloudland.dynamic.erp.dao.sys;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.cloudland.dynamic.erp.dao.sys.entity.SysColumn;
import org.cloudland.dynamic.erp.dao.sys.entity.SysTable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SysTableAccessTest {
	
	/**
	  * @Fields table 测试数据对象
	  */
	SysTable table = null;
	
	@Before
	public void setUp() throws Exception {

		List<SysColumn> columns = new ArrayList<SysColumn>(3);
		SysColumn column = null;
		for (String name : new String[]{"name", "age", "address"}) {
			column = new SysColumn();
			column.setId("");
			column.setTableId("");
			column.setName(name);
			column.setPhysicalName("Test_Column_" + name);
			column.setValueType("0");
			column.setLength("20");
			column.setStatus("1");
			
			columns.add(column);
		}
		
		table = new SysTable();
		table.setId("");
		table.setName("测试学生基本信息表");
		table.setPhysicalName("Test_Student_Info");
		table.setStatus("1");
		table.setType("0");
		table.setColumns(columns);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		SysTableAccess access = new SysTableAccess();
		int recode = access.add(table);
		assertEquals("保存数据失败！", 1, recode);
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

		SysTableAccess access = new SysTableAccess();
		SysTable table = access.get("493B8F0754DE439DBC43027DD2F98EBB");
		assertEquals("查询表结果不正确！", "测试学生基本信息表", table.getName());
		
		SysColumn column = table.getColumns().get(0);
		assertEquals("查询列结果不正确！", "name", column.getName());
				
	}

}
