/**
  *
  * @Title AccessImpl.java
  * @Package org.cloudland.dynamic.dao
  * @Description <p>TODO</p>
  * @author Administrator
  * @date 2012-8-31
  * @version 1.0
  */
package org.cloudland.dynamic.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.cloudland.dynamic.core.commons.database.DataAdaptation;
import org.cloudland.dynamic.core.commons.reflect.MethodManager;
import org.cloudland.dynamic.core.commons.reflect.MethodManager.MethodEntry;
import org.cloudland.dynamic.core.dao.Access;
import org.cloudland.dynamic.dao.connection.Connection;

/**
 * 
 * @ClassName AccessImpl
 * @Description TODO
 * @author Administrator
 * @date 2012-8-31 下午03:55:36
 *
 */
public class AccessImpl implements Access {
	
	/**
	  * @Fields conn 框架内部连接对象
	  */
	private Connection conn;
	
	/**
	  * 构造函数
	  * @param conn
	  */
	public AccessImpl(Connection conn) {
		this.conn = conn;
	}
	
	/**
	  * 返回框架连接对象
	  * @Title getConnection
	  * @Description TODO
	  * @return
	  */
	protected Connection getConnection() {
		return this.conn;
	}

	/* 
	 * Title insert
	 * Description
	 * @param <L>
	 * @param object
	 * @return
	 * @see org.cloudland.dynamic.core.dao.Access#insert(java.lang.Object)
	 */
	public <L> int insert(L object) {
		
		int result = 0;

		String SQL = new String("INSERT INTO %table%(%columnName%) VALUES(%values%)");
		
		StringBuffer columnNames = new StringBuffer();
		StringBuffer values = new StringBuffer();
		
		MethodManager manager = new MethodManager(object);
		/*for (MethodEntry entry : manager.getAllMethodEntry()) {
			columnNames.append(entry.name() + ",");
			values.append(DataAdaptation.toDataBase(entry.get()) + ",");
		}*/
		for (MethodEntry entry : manager.getAllMethodEntry()) {
			columnNames.append(entry.name() + ",");
			values.append("?,");
		}
		columnNames.deleteCharAt(columnNames.length() - 1);
		values.deleteCharAt(values.length() - 1);
		
		SQL = SQL.replaceAll("%table%", "c_sys_column");
		SQL = SQL.replaceAll("%columnName%", columnNames.toString());
		SQL = SQL.replaceAll("%values%", values.toString());
		
		System.out.println(SQL);
		
		java.sql.Connection c = conn.get();
		try {
			PreparedStatement ps = c.prepareStatement(SQL);
			for (int i = 0; i < manager.getAllMethodEntry().size(); i++) {
				MethodEntry entry = manager.getAllMethodEntry().get(i);
				ps.setObject(i + 1, DataAdaptation.toDataBase(entry.get()));
			}
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	/* 
	 * Title update
	 * Description
	 * @param <L>
	 * @param object
	 * @return
	 * @see org.cloudland.dynamic.core.dao.Access#update(java.lang.Object)
	 */
	public <L> int update(L object) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* 
	 * Title delete
	 * Description
	 * @param <L>
	 * @param object
	 * @return
	 * @see org.cloudland.dynamic.core.dao.Access#delete(java.lang.Object)
	 */
	public <L> int delete(L object) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* 
	 * Title deleteObject
	 * Description
	 * @param <L>
	 * @param id
	 * @param clazz
	 * @return
	 * @see org.cloudland.dynamic.core.dao.Access#deleteObject(java.lang.String, java.lang.Class)
	 */
	public <L> int deleteObject(String id, Class<L> clazz) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* 
	 * Title selectObject
	 * Description
	 * @param <L>
	 * @param id
	 * @param clazz
	 * @return
	 * @see org.cloudland.dynamic.core.dao.Access#selectObject(java.lang.String, java.lang.Class)
	 */
	public <L> L selectObject(String id, Class<L> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	/* 
	 * Title executeUpdate
	 * Description
	 * @param TSQL
	 * @return
	 * @see org.cloudland.dynamic.core.dao.Access#executeUpdate(java.lang.String)
	 */
	public int executeUpdate(String TSQL) {

		int result = 0;
		
		java.sql.Connection c = conn.get();
		try {
			PreparedStatement ps = c.prepareStatement(TSQL);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	/* 
	 * Title executeQuery
	 * Description
	 * @param TSQL
	 * @return
	 * @see org.cloudland.dynamic.core.dao.Access#executeQuery(java.lang.String)
	 */
	public ResultSet executeQuery(String TSQL) {
		// TODO Auto-generated method stub
		return null;
	}

}
