/**
  * @Title JITCompiler.java
  * @Package org.dynamic.construct.classloader
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-7-24
  * @version 1.0
  */
package org.cloudland.dynamic.construct.classloader.impl;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

import org.cloudland.dynamic.construct.classloader.CompilerListener;
import org.cloudland.dynamic.construct.classloader.JITCompiler;


/**
 * @ClassName JITCompiler
 * @Description just-in-time 即时编译
 * @author Lei
 * @date 2012-7-24 下午09:06:41
 *
 */
public class JDK6Compiler implements JITCompiler{

	/**
	  * @Fields compiler Java 编译器接口
	  */
	private JavaCompiler compiler;
	
	/**
	  * @Fields fileManager 文件管理器接口
	  */
	private StandardJavaFileManager fileManager;
	
	/**
	  * @Fields entry 类属性变量集合
	  */
	private ArrayList<StringClassEntry> entry;
	
	/**
	  * 类源码字符串处理类
	  * @ClassName StringClassSource
	  * @Description TODO
	  * @author Lei
	  * @date 2012-7-25 下午10:07:08
	  *
	  */
	static class StringClassEntry extends SimpleJavaFileObject implements JITCompiler.JavaSourceForString {
		
		/**
		  * @Fields className 类全路径名
		  */
		private String className;
		
		/**
		  * @Fields classCode 类源码内容
		  */
		private String classCode;
		
		/**
		  * <p>Title</p>
		  * <p>Description</p>
		  * @param className 类名全路径
		  * @param classCode 类源码内容
		  * @throws URISyntaxException 不能解析为的字符串异常
		  */
		public StringClassEntry(String className, String classCode) {
			super(URI.create("string:///" + className.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
			this.className = className;
			this.classCode = classCode;
		}
		
		@Override
		public CharSequence getCharContent(boolean paramBoolean)
				throws IOException {
			return this.classCode;
		}

		public String getName() {
			return className;
		}

		public String getCode() {
			return classCode;
		}
		
	}
	
	/**
	  * 私有化构造方法,不允许以new的形式实例对象
	  * @param classpath 类环境变量根路径
	  * @throws IOException 根路径不存在
	  */
	public JDK6Compiler(String classpath) throws IOException{
		// 获取 Java 编译器接口
		this.compiler = ToolProvider.getSystemJavaCompiler();
		// 获取文件管理器实
		this.fileManager = this.compiler.getStandardFileManager(null, null, Charset.forName("UTF-8"));
		this.fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Arrays.asList(new File[]{new File(classpath)}));
		this.entry = new ArrayList<StringClassEntry>(10);
	}
	
	/**
	  * 添加字符串形式的类源码信息
	  * @Title add
	  * @Description TODO
	  * @param name 类全路径名
	  * @param code 字符串形式的类源码
	  */
	public boolean add(String name, String code){
		return entry.add(new StringClassEntry(name, code));
	}
	
	/**
	  * 编译字符串描述的Java类并动态加载到JVM中
	  * @Title compiler
	  * @Description TODO
	  * @param className 类名称
	  * @param javaContent 类源码
	  * @return 返回 true 表示成功, 相反表示失败
	  */
	public Boolean compiler(){
		
		JavaCompiler.CompilationTask javacTask = this.compiler.getTask(null, this.fileManager, new CompilerListener<JavaFileObject>(), null, null, entry);
		
		return javacTask.call();
	}
	
}
