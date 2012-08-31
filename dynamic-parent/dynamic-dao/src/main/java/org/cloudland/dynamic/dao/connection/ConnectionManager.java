/**
  *
  * @Title ConnectionManager.java
  * @Package org.cloudland.dynamic.dao
  * @Description <p>TODO</p>
  * @author Administrator
  * @date 2012-8-31
  * @version 1.0
  */
package org.cloudland.dynamic.dao.connection;

import org.cloudland.dynamic.dao.connection.type.JDBCConnection;

/**
 * 连接对象管理类
 * @ClassName ConnectionManager
 * @Description TODO
 * @author Administrator
 * @date 2012-8-31 下午02:27:35
 *
 */
public class ConnectionManager {

	/**
	  * @Fields CONN 当前应用获取数据库连接的对象
	  */
	private static Connection CONN;
	
	/**
	  * 获取数据库连接对象
	  * @Title getConnection
	  * @Description TODO
	  * @return 数据库连接对象
	  */
	public static Connection getConnection(){
		if (null == CONN) {
			/**
			 * 后期还需扩展继承其他框架获取连接
			 * Hibernate\iBATIS\MyBATIS...
			 */
			// JDBC 直接连接
			CONN = new JDBCConnection();
		}
		return CONN;
	}
	
}
