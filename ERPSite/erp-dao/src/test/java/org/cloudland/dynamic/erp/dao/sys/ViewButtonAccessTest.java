package org.cloudland.dynamic.erp.dao.sys;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.cloudland.dynamic.erp.core.commons.number.UUID32;
import org.cloudland.dynamic.erp.dao.sys.entity.ViewButton;
import org.junit.Before;
import org.junit.Test;

public class ViewButtonAccessTest {
	
	private List<ViewButton> array = new ArrayList<ViewButton>(3);

	@Before
	public void setUp() throws Exception {
		ViewButton button = null;
		for (String order : new String[]{"1", "2", "3"}){
			button = new ViewButton();
			button.setId(UUID32.get());
			button.setViewId("58CA0721CCB74E919A2FC13C06A30DFF");
			button.setName("测试按钮" + order);
			button.setEvent("测试事件" + order);
			button.setOrder(order);
			
			array.add(button);
		}
	}

	@Test
	public void testAdd() {
		ViewButtonAccess access = new ViewButtonAccess();
		int recode = 0;
		for (ViewButton button : array) {
			recode = 0;
			recode = access.add(button);
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
		ViewButtonAccess access = new ViewButtonAccess();
		array = access.getSpecifyData("58CA0721CCB74E919A2FC13C06A30DFF");
		assertEquals("未查询到指定视图编号对应的按钮数据！", 3, array.size());
		for (ViewButton data : array) {
			assertEquals("获取的模型数据并不正确！", "58CA0721CCB74E919A2FC13C06A30DFF", data.getViewId());
		}
	}

}
