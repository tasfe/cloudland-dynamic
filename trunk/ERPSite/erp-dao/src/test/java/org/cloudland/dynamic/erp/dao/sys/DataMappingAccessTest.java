package org.cloudland.dynamic.erp.dao.sys;

import static org.junit.Assert.*;

import org.cloudland.dynamic.erp.dao.sys.entity.DataMapping;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataMappingAccessTest {

	private DataMapping mapping = null;
	
	@Before
	public void setUp() throws Exception {
		mapping = new DataMapping();
		mapping.setId("");
		mapping.setSourceType("0");
		mapping.setDictionaryId("001");
		mapping.setCustomSQL("SELECT * FROM dict");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		DataMappingAccess access = new DataMappingAccess();
		int recode = access.add(mapping);
		assertEquals("新增数据映射关系数据失败！", 1, recode);
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
		DataMappingAccess access = new DataMappingAccess();
		mapping = access.get("5E1624B6E9684C2EA89C9E0A3FD765E5");
		assertEquals("获取指定编号的数据映射关系数据失败！", "0", mapping.getSourceType());
	}

}
