/**
  * @Title JITCompiler.java
  * @Package org.dynamic.construct.classloader
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-7-24
  * @version 1.0
  */
package org.cloudland.dynamic.construct.classloader;

import javax.tools.JavaFileObject;

/**
 * @ClassName JITCompiler
 * @Description just-in-time 即时编译
 * @author Lei
 * @date 2012-7-24 下午09:06:41
 *
 */
public interface JITCompiler {
	
	/**
	  * 添加字符串形式的类源码信息
	  * @Title add
	  * @Description TODO
	  * @param name 类全路径名
	  * @param code 字符串形式的类源码
	  * @return 返回 turn表示添加成功
	  */
	boolean add(String name, String code);
	
	/**
	  * 编译字符串描述的Java类并动态加载到JVM中
	  * @Title compiler
	  * @Description TODO
	  * @param className 类名称
	  * @param javaContent 类源码
	  * @return 返回 true 表示成功, 相反表示失败
	  */
	Boolean compiler();
	
	/**
	  * Java源码字符串存储接口
	  * @ClassName JavaSourceForString
	  * @Description TODO
	  * @author Lei
	  * @date 2012-7-25 下午10:34:10
	  *
	  */
	interface JavaSourceForString extends JavaFileObject {
		
		/**
		 * return 返回类全路径名称
		 */
		String getName();
		
		/**
		 * return 返回类源码内容
		 */
		String getCode();
		
	}
	
}
