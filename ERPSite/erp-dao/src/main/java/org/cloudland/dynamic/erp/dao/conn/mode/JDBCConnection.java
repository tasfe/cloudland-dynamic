/**
  *
  * @Title JDBCConnection.java
  * @Package org.cloudland.dynamic.erp.dao.conn.mode
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-10-10
  * @version 1.0
  */
package org.cloudland.dynamic.erp.dao.conn.mode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @ClassName JDBCConnection
 * @Description TODO
 * @author Lei
 * @date 2012-10-10 下午7:11:48
 *
 */
public class JDBCConnection {
	
	public static Connection get() {
		
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
