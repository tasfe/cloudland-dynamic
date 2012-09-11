package org.cloudland.dynamic.core.commons.database;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
  * 
  * @ClassName DataAdaptationTest
  * @Description TODO
  * @author Lei
  * @date 2012-8-31 下午11:51:40
  *
  */
public class DataAdaptationTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testToJava() {
		
		Object isNull = "1";
		Object result = DataAdaptation.toJava(isNull, boolean.class);
		assertEquals("转换为Java对象，预期结果与实际结果不一致!", true, result);
		assertEquals("转换为Java对象，预期对象类型与实际类型不一致!", Boolean.class, result.getClass());
		
		Object length = "50";
		result = DataAdaptation.toJava(length, int.class);
		assertEquals("转换为Java对象，预期结果与实际结果不一致!", 50, result);
		assertEquals("转换为Java对象，预期对象类型与实际类型不一致!", Integer.class, result.getClass());
	}

	@Test
	public void testToDataBase() {
		
		boolean isNull = false;
		Object result = DataAdaptation.toDataBase(isNull);
		assertEquals("预期结果与实际结果不一致!", "0", result);
		
		String name = "测试";
		result = DataAdaptation.toDataBase(name);
		assertEquals("预期结果与实际结果不一致!", "测试", result);
	}

}
