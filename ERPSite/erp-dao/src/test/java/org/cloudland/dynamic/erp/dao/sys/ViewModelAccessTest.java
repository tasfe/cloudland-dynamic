package org.cloudland.dynamic.erp.dao.sys;

import static org.junit.Assert.*;

import org.cloudland.dynamic.erp.dao.sys.entity.ViewModel;
import org.junit.Before;
import org.junit.Test;

public class ViewModelAccessTest {
	
	/**
	  * @Fields view 视图模型对象测试数据
	  */
	private ViewModel view = null;

	@Before
	public void setUp() throws Exception {
		view = new ViewModel();
		view.setId("BD9E0FE486E542EF90539C15A6F0AE2C");
		view.setViewName("测试显示模型");
		view.setViewType("自定义页面");
		view.setViewModeURL("页面地址");
		view.setDataSourceType("数据库源类型");
		view.setDataSource("表名");
		view.setViewMaxNumber("20");
	}

	@Test
	public void testAdd() {
		ViewModelAccess access = new ViewModelAccess();
		int recode = access.add(view);
		assertEquals("新增视图模型数据失败！", 1, recode);
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
		ViewModelAccess access = new ViewModelAccess();
		view = access.get(view.getId());
		
		assertNotNull("未查找到指定编号的数据信息！", view);
		assertEquals("查找指定编号的数据失败！", "测试显示模型", view.getViewName());
	}

}
