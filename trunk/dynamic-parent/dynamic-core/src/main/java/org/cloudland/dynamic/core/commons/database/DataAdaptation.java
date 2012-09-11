/**
  *
  * @Title DataAdaptation.java
  * @Package org.cloudland.dynamic.core.commons.database
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-8-31
  * @version 1.0
  */
package org.cloudland.dynamic.core.commons.database;

/**
 * 数据适配工具类
 * @ClassName DataAdaptation
 * @Description 将Java需要存入数据库的值和将数据库需要转换为Java对象类型的值，相互转换适配。
 * @author Lei
 * @date 2012-8-31 下午11:17:04
 *
 */
public class DataAdaptation {

	
	/**
	  * 将指定的值转换为Java类型值
	  * @Title toJava
	  * @Description TODO
	  * @param value 原始值
	  * @param targetClass 目标类型
	  * @return Java对象类型
	  */
	public static Object toJava(final Object value, final Class<?> targetClass) {
		
		Object result = value;
		if (targetClass.equals(boolean.class) || targetClass.equals(Boolean.class)) {
			result = value.equals("1") ? true : false;
		} else if (targetClass.equals(int.class) || targetClass.equals(Integer.class)) {
			result = Integer.valueOf(value.toString());
		}
		return result;
	}
	
	/**
	  * 将Java值适配为数据库存储值
	  * @Title toDataBase
	  * @Description TODO
	  * @param value Java值
	  * @return
	  */
	public static Object toDataBase(final Object value) {
		
		Object result = value;
		if (value instanceof Boolean) {
			result = (Boolean)value ? "1" : "0";
		} 
		return result;
	}
	
}
