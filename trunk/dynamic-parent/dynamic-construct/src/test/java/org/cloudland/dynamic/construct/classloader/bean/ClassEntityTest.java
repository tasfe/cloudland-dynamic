package org.cloudland.dynamic.construct.classloader.bean;

import org.cloudland.dynamic.construct.classloader.bean.ClassBean;
import org.cloudland.dynamic.construct.classloader.bean.ClassBean.ClassField;
import org.junit.Test;

public class ClassEntityTest {

	@Test
	public void testClassEntity() {
		
		ClassBean.ClassField field = new ClassBean.ClassField();
		field.setModifier(ClassField.Modifier.PRIVATE);
		field.setType(ClassBean.ClassField.Type.STRING);
		field.setName("name");
		
	}

}
