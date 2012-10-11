package org.cloudland.dynamic.erp.dao.sys;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.cloudland.dynamic.erp.core.commons.number.UUID32;
import org.cloudland.dynamic.erp.dao.sys.entity.ViewData;
import org.junit.Before;
import org.junit.Test;

public class ViewDataAccessTest {
	
	private List<ViewData> array = new ArrayList<ViewData>(3);

	@Before
	public void setUp() throws Exception {
		ViewData data = null;
		for (String order : new String[]{"1", "2", "3"}){
			data = new ViewData();
			data.setId(UUID32.get());
			data.setViewId("58CA0721CCB74E919A2FC13C06A30DFF");
			data.setSysColumnId("系统列" + order);
			data.setStyleId("系统样式" + order);
			data.setVerifyId("验证" + order);
			data.setDataMappingId("映射" + order);
			data.setOrder(order);
			
			array.add(data);
		}
		
	}

	@Test
	public void testAdd() {
		ViewDataAccess access = new ViewDataAccess();
		int recode = 0;
		for (ViewData data : array) {
			recode = 0;
			recode = access.add(data);
			assertEquals("新增模型数据失败！", 1, recode);
		}
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
		fail("Not yet implemented");
	}

	@Test
	public void testGetSpecifyData() {
		ViewDataAccess access = new ViewDataAccess();
		array = access.getSpecifyData("58CA0721CCB74E919A2FC13C06A30DFF");
		assertEquals("未查询到指定视图编号对应的数据！", 3, array.size());
		for (ViewData data : array) {
			assertEquals("获取的模型数据并不正确！", "58CA0721CCB74E919A2FC13C06A30DFF", data.getViewId());
		}
	}

}
