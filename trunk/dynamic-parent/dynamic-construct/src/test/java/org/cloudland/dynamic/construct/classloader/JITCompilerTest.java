package org.cloudland.dynamic.construct.classloader;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.cloudland.dynamic.construct.classloader.JITCompiler;
import org.cloudland.dynamic.construct.classloader.impl.JDK6Compiler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JITCompilerTest {
	
	/**
	  * @Fields compiler 动态编译对象
	  */
	private JITCompiler compiler;

	@Before
	public void setUp() throws Exception {
		compiler = new JDK6Compiler("target\\classes");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCompiler() {
		String className = "org.dynamic.entity.Test";
		String javaContent = "package org.dynamic.entity;public class Test{private String name;public void setName(String name){this.name = name;}public String getName (){return this.name;}private boolean enable;public void setEnable(boolean enable){this.enable = enable;}public boolean isEnable (){return this.enable;}}";
		compiler.add(className, javaContent);
		
		
		boolean isSuccess = false;
		if ((isSuccess = compiler.compiler())){// 动态编译
			try {
				Class<?> clazz = Class.forName(className);

				Object obj = clazz.newInstance();
				// write method
				Method method = clazz.getDeclaredMethod("setEnable", boolean.class);
				method.invoke(obj, new Object[]{true});
				
				method = clazz.getMethod("setName", String.class);
				method.invoke(obj, new Object[]{"测试用例"});
				
				// read method
				method = clazz.getMethod("isEnable", new Class<?>[]{});
				Object result = method.invoke(obj, new Object[]{});
				assertEquals("预期结果与实际结果不匹配!\r\n", true, result);
				
				method = clazz.getMethod("getName", new Class<?>[]{});
				result = method.invoke(obj, new Object[]{});
				assertEquals("预期结果与实际结果不匹配!\r\n", "测试用例", result);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		} else {
			fail("动态编译失败！" );
		}
	}

}
