/**
 *
 * @Title ConnectionFactory.java
 * @Package org.cloudland.dynamic.erp.dao.conn
 * @Description <p>TODO</p>
 * @author Lei
 * @date 2012-10-10
 * @version 1.0
 */
package org.cloudland.dynamic.erp.dao.conn;

import java.sql.Connection;
import org.cloudland.dynamic.erp.dao.conn.mode.JDBCConnection;

/**
 * 
 * @ClassName ConnectionFactory
 * @Description TODO
 * @author Lei
 * @date 2012-10-10 下午7:02:57
 * 
 */
public class ConnectionFactory {

	/**
	 * @Fields LOCAL_CONNECTION 当前线程数据库连接
	 */
	private static ThreadLocal<Connection> LOCAL_CONNECTION = new ThreadLocal<Connection>();

	/**
	 * 获取数据库连接对象
	 * 
	 * @Title getConnection
	 * @Description TODO
	 * @return 数据库连接对象
	 */
	public static Connection getConnection() {
		if (null == LOCAL_CONNECTION.get()) {
			/**
			 * 后期还需扩展继承其他框架获取连接 Hibernate\iBATIS\MyBATIS...
			 */
			// JDBC 直接连接
			LOCAL_CONNECTION.set(JDBCConnection.get());
		}
		return LOCAL_CONNECTION.get();
	}

}
