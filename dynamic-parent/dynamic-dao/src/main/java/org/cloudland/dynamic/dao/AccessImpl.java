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

import java.sql.ResultSet;

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
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		return 0;
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
