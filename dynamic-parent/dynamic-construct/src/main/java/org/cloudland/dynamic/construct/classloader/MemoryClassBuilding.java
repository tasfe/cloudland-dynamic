/**
  *
  * @Title MemoryClassBuilding.java
  * @Package org.dynamic.construct.classloader
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-7-28
  * @version 1.0
  */
package org.cloudland.dynamic.construct.classloader;

import org.cloudland.dynamic.construct.classloader.bean.ClassBean;


/**
 * 内存直接构建JavaBean源码内容类
 * @ClassName MemoryClassBuilding
 * @Description TODO
 * @author Lei
 * @date 2012-7-28 上午09:51:22
 *
 */
public abstract class MemoryClassBuilding {

	/**
	  * 构建 JavaBean 源码内容
	  * @Title beanSourcebuilding
	  * @Description TODO
	  * @param beanInfo
	  * @return
	  */
	private static String beanSourcebuilding(final ClassBean beanInfo){
		
		String methodName;
		char[] c;
		
		// 字段和字段的set、get方法源码字符串
		StringBuilder fieldMethod = new StringBuilder();
		for (ClassBean.ClassField field : beanInfo.getFields()) {
			// 定义类字段变量
			fieldMethod.append(field.getModifier()).append(" ").append(field.getType()).append(" ").append(field.getName()).append(";");
			
			c = field.getName().toCharArray();
			if (c[0] >= 'a' && c[0] <= 'z') {
				c[0] -= 32;
			}
			methodName = new String(c);
			
			// 定义 write 方法
			fieldMethod.append("public void set").append(methodName).append("(").append(field.getType()).append(" ").append(field.getName()).append("){");
			fieldMethod.append("this.").append(field.getName()).append(" = ").append(field.getName()).append(";}");
			
			// 定义 read 方法
			fieldMethod.append("public ").append(field.getType()).append(" ");
			if (field.getName().startsWith("is") || field.getType().equals(ClassBean.ClassField.Type.BOOLEAN)) {
				fieldMethod.append("is");
			} else {
				fieldMethod.append("get");
			}
			fieldMethod.append(methodName).append(" (){");
			fieldMethod.append("return this.").append(field.getName()).append(";}");
		}
		
		return fieldMethod.toString();
	}
	
	/**
	  * 构建Java类源码字符串
	  * @Title building
	  * @Description TODO
	  * @param beanInfo 构建JavaBean类使用到了类描述信息
	  * @return
	  */
	public static String building(final ClassBean beanInfo){
		// Java 类源码字符串
		StringBuilder classSource = new StringBuilder();
		
		String paths[] = beanInfo.getClassName().split("\\.");
		if (paths.length != 1) {
			classSource.append("package ");
			for (int i = 0; i < paths.length - 1; i++) {
				classSource.append(paths[i]).append(".");
			}
			classSource.setCharAt(classSource.length() - 1, ';');
		}
		classSource.append("public class ").append(paths[paths.length - 1]).append("{");
		classSource.append(beanSourcebuilding(beanInfo));
		classSource.append("}");
		
		return classSource.toString();
	}
	
}
