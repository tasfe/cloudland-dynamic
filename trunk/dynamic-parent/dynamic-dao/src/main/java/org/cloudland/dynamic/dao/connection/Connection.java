/**
  *
  * @Title Connection.java
  * @Package org.cloudland.dynamic.dao
  * @Description <p>TODO</p>
  * @author Administrator
  * @date 2012-8-31
  * @version 1.0
  */
package org.cloudland.dynamic.dao.connection;

/**
 * 获取连接抽象类
 * @ClassName Connection
 * @Description TODO
 * @author Administrator
 * @date 2012-8-31 上午11:24:54
 *
 */
public abstract class Connection {
	
	/**
	  * @Fields LOCAL_CONNECTION 当前线程数据库连接
	  */
	private static ThreadLocal<java.sql.Connection> LOCAL_CONNECTION = new ThreadLocal<java.sql.Connection>();
	
	/**
	  * 获取数据库连接
	  * @Title get
	  * @Description TODO
	  * @return Java数据库连接对象
	  */
	public java.sql.Connection get(){
		if (null == LOCAL_CONNECTION.get())
			LOCAL_CONNECTION.set(createConnection());
		
		return LOCAL_CONNECTION.get();
	}
	
	/**
	  * 创建数据库连接抽象，有继承类具体实现创建过程
	  * @Title createConnection
	  * @Description TODO
	  * @return Java数据库连接对象
	  */
	protected abstract java.sql.Connection createConnection();
	
}
