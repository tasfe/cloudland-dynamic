package org.cloudland.dynamic.construct.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.cloudland.dynamic.construct.model.bean.HTMLElement;
import org.cloudland.dynamic.construct.model.bean.HTMLStyle;
import org.cloudland.dynamic.construct.model.bean.StyleModel;
import org.junit.Before;
import org.junit.Test;

public class HTMLDisplayModelManagerTest {

	/**
	 * @Fields manager 测试对象
	 */
	private HTMLDisplayModelManager manager;

	@Before
	public void setUp() throws Exception {
		manager = HTMLDisplayModelManager.getInstance();

		// 创建HTML样式
		HTMLStyle style = new HTMLStyle();
		style.setId("B0A7E2BFD4C14AEF94C4762335F8E182");// 设置样式编号
		style.setDisplayName("姓名");// 显示名称
		style.setDisplayType(Type.HTMLDisplayType.TEXT);// HTML样式
		style.setWidth(200);// 宽度
		style.setHeight(500);// 高度
		style.setOrder(1);// 显示顺序
		//System.out.println("style Id:=" + style.getId());

		// 将样式与数据参数关系映射
		String dataParamId = "F8FDE733C31C433B8C06BA2FC970F574";
		HTMLElement element = new HTMLElement(dataParamId, style);
		//System.out.println("dataParamId:=" + dataParamId);
		
		// 添加模型内样式与数据参水映射关系集合
		ArrayList<HTMLElement> htmlElements = new ArrayList<HTMLElement>();
		htmlElements.add(element);

		// 创建样式模型
		StyleModel<HTMLElement> model = new StyleModel<HTMLElement>();
		model.setId("938C17210B944795AC2D3C5A6D409877");
		model.setName("单元测试模型");
		model.setHtmlElements(htmlElements);
		//System.out.println("model Id:=" + model.getId());

		// 添加样式模型
		manager.addModel(model);
	}

	@Test
	public void testGetInstance() {
		HTMLDisplayModelManager manager = HTMLDisplayModelManager.getInstance();
		assertNotNull("HTMLDisplayModelManager.getInstance() 获取对象为空！", manager);
	}

	@Test
	public void testGetDataConstruct() {
		Structure<HTMLElement> structure = manager.getDataConstruct("938C17210B944795AC2D3C5A6D409877");
		assertEquals("样式模型名称比对失败!", "单元测试模型", structure.getName());
		HTMLStyle style = structure.getParameter("F8FDE733C31C433B8C06BA2FC970F574").getHtmlStyle();
		assertEquals("HTML显示名称比对失败!", "姓名", style.getDisplayName());
		assertEquals("HTML显示类型别对失败!", Type.HTMLDisplayType.TEXT, style.getDisplayType());
	}

	/*
	 * @Test 
	 * public void testAddHTMLStyle() { 
	 * 		fail("Not yet implemented"); 
	 * }
	 */

	@Test
	public void testUpdateHTMLStyle() {
		// 创建HTML样式
		HTMLStyle style = new HTMLStyle();
		style.setId("B0A7E2BFD4C14AEF94C4762335F8E182");// 设置样式编号
		style.setDisplayName("Name");// 显示名称
		style.setDisplayType(Type.HTMLDisplayType.SELECT);// HTML样式
		style.setWidth(200);// 宽度
		style.setHeight(500);// 高度
		style.setOrder(1);// 显示顺序
		
		manager.updateHTMLStyle(style);
		
		Structure<HTMLElement> structure = manager.getDataConstruct("938C17210B944795AC2D3C5A6D409877");
		style = structure.getParameter("F8FDE733C31C433B8C06BA2FC970F574").getHtmlStyle();
		assertEquals("HTML显示名称比对失败!", "Name", style.getDisplayName());
		assertEquals("HTML显示类型别对失败!", Type.HTMLDisplayType.SELECT, style.getDisplayType());
	}

	@Test
	public void testRemoveHTMLStyle() {
		
		HTMLStyle style = new HTMLStyle();
		style.setId("B0A7E2BFD4C14AEF94C4762335F8E182");// 设置样式编号
		
		// 移除样式
		manager.removeHTMLStyle(style);
		
		Structure<HTMLElement> structure = manager.getDataConstruct("938C17210B944795AC2D3C5A6D409877");
		style = structure.getParameter("F8FDE733C31C433B8C06BA2FC970F574").getHtmlStyle();
		assertNull("样式没有成功移除!", style);
	}

	@Test
	public void testAddModel() {

		Structure<HTMLElement> structure = manager.getDataConstruct("938C17210B944795AC2D3C5A6D409877");
		assertEquals("样式模型名称比对失败!", "单元测试模型", structure.getName());
		HTMLStyle style = structure.getParameter("F8FDE733C31C433B8C06BA2FC970F574").getHtmlStyle();
		assertEquals("HTML显示名称比对失败!", "姓名", style.getDisplayName());
		assertEquals("HTML显示类型别对失败!", Type.HTMLDisplayType.TEXT, style.getDisplayType());
	}

	@Test
	public void testUpdateModel() {
		// 创建HTML样式
		HTMLStyle style = new HTMLStyle();
		style.setId("B0A7E2BFD4C14AEF94C4762335F8E182");// 设置样式编号
		style.setDisplayName("Name");// 显示名称
		style.setDisplayType(Type.HTMLDisplayType.SELECT);// HTML样式
		style.setWidth(200);// 宽度
		style.setHeight(500);// 高度
		style.setOrder(1);// 显示顺序

		// 将样式与数据参数关系映射
		String dataParamId = "F8FDE733C31C433B8C06BA2FC970F574";
		HTMLElement element = new HTMLElement(dataParamId, style);

		// 添加模型内样式与数据参水映射关系集合
		ArrayList<HTMLElement> htmlElements = new ArrayList<HTMLElement>();
		htmlElements.add(element);

		// 创建样式模型
		StyleModel<HTMLElement> model = new StyleModel<HTMLElement>();
		model.setId("938C17210B944795AC2D3C5A6D409877");
		model.setName("单元测试更新模型");
		model.setHtmlElements(htmlElements);

		// 添加样式模型
		manager.updateModel(model);

		Structure<HTMLElement> structure = manager.getDataConstruct(model.getId());
		assertEquals("样式模型名称比对失败!", "单元测试更新模型", structure.getName());
		style = structure.getParameter(dataParamId).getHtmlStyle();
		assertEquals("HTML显示名称比对失败!", "Name", style.getDisplayName());
		assertEquals("HTML显示类型别对失败!", Type.HTMLDisplayType.SELECT, style.getDisplayType());
	}

	@Test
	public void testRemoveModel() {
		
		StyleModel<HTMLElement> model = new StyleModel<HTMLElement>();
		model.setId("938C17210B944795AC2D3C5A6D409877");
		
		manager.removeModel(model);
		
		Structure<HTMLElement> structure = manager.getDataConstruct("938C17210B944795AC2D3C5A6D409877");
		assertNull("未能成功删除样式模型!", structure);
	}

}
