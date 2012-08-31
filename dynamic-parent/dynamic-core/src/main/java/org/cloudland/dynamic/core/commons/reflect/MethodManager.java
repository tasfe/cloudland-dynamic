/**
  *
  * @Title ClassUtils.java
  * @Package org.cloudland.dynamic.core.commons.reflect
  * @Description <p>TODO</p>
  * @author Administrator
  * @date 2012-8-31
  * @version 1.0
  */
package org.cloudland.dynamic.core.commons.reflect;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 实例对象方法使用管理类
 * @ClassName MethodManager
 * @Description TODO
 * @author Lei
 * @date 2012-8-31 下午03:59:56
 *
 */
public class MethodManager {
	
	/**
	  * @Fields origin 实例对象
	  */
	private Object origin;
	
	/**
	  * 方法实体对象
	  * @ClassName MethodEntry
	  * @Description TODO
	  * @author Lei
	  * @date 2012-8-31 下午05:19:07
	  *
	  */
	public static class MethodEntry {
		
		private Object tarObj;
		
		private PropertyDescriptor desc;
		
		private MethodEntry(Object object, PropertyDescriptor desc) {
			this.tarObj = object;
			this.desc = desc;
		}
		
		/**
		  * 字段名
		  * @Title name
		  * @Description TODO
		  * @return
		  */
		public String name() {
			return desc.getName();
		}
		
		/**
		  * 设置字段值
		  * @Title set
		  * @Description TODO
		  * @param obj
		  */
		public void set(Object... obj) {
			
			try {
				desc.getWriteMethod().invoke(tarObj, obj);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		/**
		  * 获取字段值
		  * @Title get
		  * @Description TODO
		  * @return
		  */
		public Object get() {
			
			Object result = null;
			try {
				result = desc.getReadMethod().invoke(tarObj, new Object[]{});
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
		}
	}
	
	/**
	  * 构造方法
	  * @param obj 实体对象
	  */
	public MethodManager(Object obj) {
		this.origin = obj;
	}

	/**
	  * 获取指定字段名的操作方法实体对象
	  * @Title getMethodEntry
	  * @Description TODO
	  * @param fileName 类属性名
	  * @return 方法实体对象
	  */
	public MethodEntry getMethodEntry(String fileName) {
		
		PropertyDescriptor desc = null;
		try {
			desc = new PropertyDescriptor(fileName, origin.getClass());
		} catch (IntrospectionException e) {
			// TODO 此字段方法不存在
			e.printStackTrace();
		}
		return new MethodEntry(origin, desc);
	}
	
	/**
	  * 获取该对象的全部字段读写方法
	  * @Title getAllMethodEntry
	  * @Description TODO
	  * @return 方法实体集合
	  */
	public List<MethodEntry> getAllMethodEntry() {
		
		ArrayList<MethodEntry> result = new ArrayList<MethodEntry>();
		
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(origin.getClass());
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (PropertyDescriptor desc : beanInfo.getPropertyDescriptors()) {
			if ("class".equals(desc.getName())) {
				continue;
			}
			result.add(new MethodEntry(origin, desc));
		}
		
		return result;
	}
}

