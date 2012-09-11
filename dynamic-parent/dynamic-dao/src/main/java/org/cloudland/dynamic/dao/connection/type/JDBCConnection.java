/**
  *
  * @Title JDBCConnection.java
  * @Package org.cloudland.dynamic.dao.connection.type
  * @Description <p>TODO</p>
  * @author Administrator
  * @date 2012-8-31
  * @version 1.0
  */
package org.cloudland.dynamic.dao.connection.type;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.cloudland.dynamic.dao.connection.Connection;

/**
 * JDBC数据库连接对象
 * @ClassName JDBCConnection
 * @Description TODO
 * @author Administrator
 * @date 2012-8-31 下午02:46:40
 *
 */
public class JDBCConnection extends Connection {
	
	/* 
	 * Title createConnection
	 * Description
	 * @return
	 * @see org.cloudland.dynamic.dao.connection.Connection#createConnection()
	 */
	@Override
	protected java.sql.Connection createConnection() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/dynamic";
		String user = "root";
		String passwd = "";
		
		java.sql.Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);
			if (!conn.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

}
