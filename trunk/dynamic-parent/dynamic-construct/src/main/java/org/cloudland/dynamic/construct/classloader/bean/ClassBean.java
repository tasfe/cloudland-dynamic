/**
  *
  * @Title ClassEntity.java
  * @Package org.dynamic.construct.classloader.bean
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-7-28
  * @version 1.0
  */
package org.cloudland.dynamic.construct.classloader.bean;

import java.util.List;

/**
 * 动态构建类所需要的信息存储类
 * @ClassName ClassEntity
 * @Description TODO
 * @author Lei
 * @date 2012-7-28 上午12:46:19
 *
 */
public class ClassBean {
	
	/**
	  * @Fields className 类全路径名
	  */
	private String className;
	
	/**
	  * @Fields fields 类成员变量描述信息集合
	  */
	private List<ClassField> fields;
	
	/**
	  * 类成员描述信息类
	  * @ClassName ClassField
	  * @Description TODO
	  * @author Lei
	  * @date 2012-7-28 上午12:50:23
	  *
	  */
	public static class ClassField {
		
		public static enum Modifier {
			PRIVATE("private"), PROTECTED("protected"), PUBLIC("public");
			
			/**
			  * @Fields name 修饰符名称
			  */
			private String name;
			
			/**
			  * 构造方法
			  * @param name 修饰名称
			  */
			private Modifier(String name){
				this.name = name;
			}
			
			@Override
			public String toString() {
				return this.name;
			}
		}
		
		/**
		  * 变量类型
		  * @ClassName Type
		  * @Description TODO
		  * @author Lei
		  * @date 2012-7-28 上午12:53:09
		  *
		  */
		public static enum Type {
			INT("int"), SHOR("short"), FLOAT("float"), DOUBLE("double"), CHAR("char"), STRING("String"), BOOLEAN("boolean");
			
			/**
			  * @Fields name 成员类型名称
			  */
			private String name;
			
			/**
			  * 构造方法
			  * @param name 类型名称
			  */
			private Type(String name){
				this.name = name;
			}
			
			@Override
			public String toString() {
				return this.name;
			}
		};
		
		/**
		  * @Fields modifier 类成员变量修饰符 
		  */
		private Modifier modifier;
		
		/**
		  * @Fields type 类成员类型
		  */
		private Type type;
		
		/**
		  * @Fields name 字段名
		  */
		private String name;
		
		
		/**
		  * 默认构造方法
		  */
		public ClassField() {
		}
		
		/**
		  * 指定访问修饰符, 变量类型, 变量名构造字段对象
		  * @param modifier 访问修饰符
		  * @param type 变量类型
		  * @param name 变量名称
		  */
		public ClassField(Modifier modifier, Type type, String name){
			this.modifier = modifier;
			this.type = type;
			this.name = name;
		}

		public Modifier getModifier() {
			return modifier;
		}

		public void setModifier(Modifier modifier) {
			this.modifier = modifier;
		}

		public Type getType() {
			return type;
		}

		public void setType(Type type) {
			this.type = type;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<ClassField> getFields() {
		return fields;
	}

	public void setFields(List<ClassField> fields) {
		this.fields = fields;
	}

}