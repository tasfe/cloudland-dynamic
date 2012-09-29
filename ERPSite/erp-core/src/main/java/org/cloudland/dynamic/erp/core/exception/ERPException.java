/**
  *
  * @Title ERPException.java
  * @Package org.cloudland.dynamic.erp.core.exception
  * @Description <p>TODO</p>
  * @author Administrator
  * @date 2012-9-29
  * @version 1.0
  */
package org.cloudland.dynamic.erp.core.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

/**
 * 企业级异常基类
 * @ClassName ERPException
 * @Description TODO
 * @author Lei
 * @date 2012-9-29 下午05:18:09
 *
 */
public abstract class ERPException extends Exception {
	
	private HashMap<String, Properties> resource = new HashMap<String, Properties>();
	
	/**
	  * @Fields code 错误代码
	  */
	private String code;
	
	/**
	  * @Fields messages 错误信息 
	  */
	private String messages;
	
	{
		File file = getResourceFile();
		if (null == file || file.isDirectory()) {
			// TODO 文件不存在或不是文件
		}
		
		InputStream inStream = null;
		try {
			inStream = new FileInputStream(file);
			Properties p = new Properties();
			p.load(inStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != inStream) {
				try {
					inStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/**
	  * 获取此异常采用的异常源文件
	  * @Title getResourceFile
	  * @Description 返回的文件格式必须为key=value(键值对)格式
	  * @return 文件路径
	  */
	protected abstract File getResourceFile();
	
	public ERPException(String code) {
		super();
		this.code = code;
	}

}
