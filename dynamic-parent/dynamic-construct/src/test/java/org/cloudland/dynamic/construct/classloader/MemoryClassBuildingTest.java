package org.cloudland.dynamic.construct.classloader;

import java.util.ArrayList;

import org.cloudland.dynamic.construct.classloader.MemoryClassBuilding;
import org.cloudland.dynamic.construct.classloader.bean.ClassBean;
import org.junit.Before;
import org.junit.Test;

public class MemoryClassBuildingTest {
	

	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void testBuilding(){
		
		ArrayList<ClassBean.ClassField> array = new ArrayList<ClassBean.ClassField>();
		ClassBean.ClassField name = new ClassBean.ClassField(ClassBean.ClassField.Modifier.PRIVATE, ClassBean.ClassField.Type.STRING, "name");
		array.add(name);
		ClassBean.ClassField enable = new ClassBean.ClassField(ClassBean.ClassField.Modifier.PRIVATE, ClassBean.ClassField.Type.BOOLEAN, "enable");
		array.add(enable);
		
		ClassBean bean = new ClassBean();
		bean.setClassName("org.dynamic.entity.Test");
		bean.setFields(array);
		
		String javaSource = MemoryClassBuilding.building(bean);
		System.out.println(javaSource);

	}

}
