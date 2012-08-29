/**
  *
  * @Title DataConstructManagerTest.java
  * @Package org.cloudland.dynamic.construct.model
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-8-14
  * @version 1.0
  */
package org.cloudland.dynamic.construct.model;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.cloudland.dynamic.construct.model.bean.DataModel;
import org.cloudland.dynamic.construct.model.bean.DataParameter;
import org.cloudland.dynamic.core.commons.number.UUID32;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @ClassName DataConstructManagerTest
 * @Description TODO
 * @author Lei
 * @date 2012-8-14 下午8:04:18
 *
 */
public class DataConstructManagerTest {
	
	/**
	  * @Fields manager 测试对象
	  */
	private DataConstructManager manager;

	/**
	 *
	 * @Title setUp
	 * @Description TODO
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		manager = DataConstructManager.getInstance();
	}

	/**
	 *
	 * @Title tearDown
	 * @Description TODO
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.cloudland.dynamic.construct.model.DataConstructManager#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		DataConstructManager manager = DataConstructManager.getInstance();
		assertNotNull("DataConstructManager.getInstance() 获取对象为空！", manager);
	}

	/**
	 * Test method for {@link org.cloudland.dynamic.construct.model.DataConstructManager#getDataConstruct(java.lang.String)}.
	 */
	@Test
	public void testGetDataConstruct() {
		
		int paraLength = 5;
		DataParameter[] array = new DataParameter[paraLength];
		for (int i = 0; i < paraLength; i++) {
			array[i] = new DataParameter();
			array[i].setId(UUID32.get());
			array[i].setName("dataConstruct" + i);
		}
		DataModel model = new DataModel();
		model.setId(UUID32.get());
		model.setName("TestModel");
		model.setDataParameters(Arrays.asList(array));
		manager.add(model);// 添加模型内容
		
		// 接口获取调试
		Structure<DataParameter> sturct = manager.getDataConstruct(model.getId());
		assertEquals("获取数据结构名称失败！", model.getName(), sturct.getName());
		for (DataParameter para : array) {
			assertEquals("获取数据结构内部参数对象失败！", para.getId(), sturct.getParameter(para.getId()).getId());
		}
	}

	/**
	 * Test method for {@link org.cloudland.dynamic.construct.model.DataConstructManager#add(org.cloudland.dynamic.construct.model.bean.DataModel)}.
	 */
	@Test
	public void testAdd() {
		
		int paraLength = 5;
		DataParameter[] array = new DataParameter[paraLength];
		for (int i = 0; i < paraLength; i++) {
			array[i] = new DataParameter();
			array[i].setId(UUID32.get());
			array[i].setName("add" + i);
		}
		
		DataModel model = new DataModel();
		model.setId(UUID32.get());
		model.setName("TestModel");
		model.setDataParameters(Arrays.asList(array));
		
		manager.add(model);// 添加模型内容
		
		assertNotNull("未能获取到编号为[" + model.getId() + "]的结构对象！", manager.getDataConstruct(model.getId()));
	}

	/**
	 * Test method for {@link org.cloudland.dynamic.construct.model.DataConstructManager#update(org.cloudland.dynamic.construct.model.bean.DataModel)}.
	 */
	@Test
	public void testUpdate() {
		
		int paraLength = 5;
		DataParameter[] array = new DataParameter[paraLength];
		for (int i = 0; i < paraLength; i++) {
			array[i] = new DataParameter();
			array[i].setId(UUID32.get());
			array[i].setName("test" + i);
		}
		DataModel model = new DataModel();
		model.setId(UUID32.get());
		model.setName("TestModel");
		model.setDataParameters(Arrays.asList(array));
		manager.add(model);// 添加模型内容
		
		// 修改原参数
		for (int i = 0; i < array.length; i++) {
			array[i].setName("update" + i);
		}
		model.setName("updateModel");
		manager.update(model);// 更新数据结构对象
		
		// 接口获取调试
		Structure<DataParameter> sturct = manager.getDataConstruct(model.getId());
		assertEquals("更新模型名称失败！", "updateModel", sturct.getName());
		for (int i = 0; i < array.length; i++) {
			assertEquals("更新模型内部参数对象失败！", "update" + i, sturct.getParameter(array[i].getId()).getName());
		}
	}

	/**
	 * Test method for {@link org.cloudland.dynamic.construct.model.DataConstructManager#remove(org.cloudland.dynamic.construct.model.bean.DataModel)}.
	 */
	@Test
	public void testRemove() {
		int paraLength = 5;
		DataParameter[] array = new DataParameter[paraLength];
		for (int i = 0; i < paraLength; i++) {
			array[i] = new DataParameter();
			array[i].setId(UUID32.get());
			array[i].setName("test" + i);
		}
		DataModel model = new DataModel();
		model.setId(UUID32.get());
		model.setName("TestModel");
		model.setDataParameters(Arrays.asList(array));
		manager.add(model);// 添加模型内容
		
		// 删除模型对象
		manager.remove(model);
		
		assertNull("删除指定编号[" + model.getId() + "]的模型失败 !", manager.getDataConstruct(model.getId()));
	}

	/**
	 * Test method for {@link org.cloudland.dynamic.construct.model.DataConstructManager#addParameter(java.lang.String, org.cloudland.dynamic.construct.model.bean.DataParameter)}.
	 */
	@Test
	public void testAddParameter() {
		
		DataModel model = new DataModel();
		model.setId(UUID32.get());
		model.setName("TestModel");
		manager.add(model);// 添加模型内容
		
		// 新建一个参数对象
		DataParameter para = new DataParameter();
		para.setId(UUID32.get());
		para.setName("addParameter");
		
		// 向指定模型中，新增参数对象
		manager.addParameter(model.getId(), para);
		
		// 接口获取调试
		Structure<DataParameter> sturct = manager.getDataConstruct(model.getId());
		assertEquals("添加新的参数对象失败！", "addParameter", sturct.getParameter(para.getId()).getName());
	}

	/**
	 * Test method for {@link org.cloudland.dynamic.construct.model.DataConstructManager#updateParameter(org.cloudland.dynamic.construct.model.bean.DataParameter)}.
	 */
	@Test
	public void testUpdateParameter() {
		
		int paraLength = 5;
		DataParameter[] array = new DataParameter[paraLength];
		for (int i = 0; i < paraLength; i++) {
			array[i] = new DataParameter();
			array[i].setId(UUID32.get());
			array[i].setName("addParameter" + i);
		}
		DataModel model = new DataModel();
		model.setId(UUID32.get());
		model.setName("TestModel");
		model.setDataParameters(Arrays.asList(array));
		manager.add(model);// 添加模型内容
		
		// 修改原参数
		for (int i = 0; i < array.length; i++) {
			array[i].setName("updateParameter" + i);
		}
		
		// 迭代更新参数对象
		for (DataParameter para : array) {
			manager.updateParameter(para);
		}
		
		// 接口获取调试
		Structure<DataParameter> sturct = manager.getDataConstruct(model.getId());
		for (DataParameter para : array) {
			assertEquals("更新参数对象失败！", para.getName(), sturct.getParameter(para.getId()).getName());
		}
	}

	/**
	 * Test method for {@link org.cloudland.dynamic.construct.model.DataConstructManager#removeParameter(org.cloudland.dynamic.construct.model.bean.DataParameter)}.
	 */
	@Test
	public void testRemoveParameter() {
		int paraLength = 5;
		DataParameter[] array = new DataParameter[paraLength];
		for (int i = 0; i < paraLength; i++) {
			array[i] = new DataParameter();
			array[i].setId(UUID32.get());
			array[i].setName("addParameter" + i);
		}
		DataModel model = new DataModel();
		model.setId(UUID32.get());
		model.setName("TestModel");
		model.setDataParameters(Arrays.asList(array));
		manager.add(model);// 添加模型内容
		
		// 迭代删除参数对象
		for (DataParameter para : array) {
			manager.removeParameter(para);
		}
		
		Structure<DataParameter> sturct = manager.getDataConstruct(model.getId());
		assertEquals("删除参数对象失败！", 0, sturct.getParameters().size());
	}

}
