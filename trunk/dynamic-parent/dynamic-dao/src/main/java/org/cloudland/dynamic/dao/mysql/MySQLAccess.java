/**
  *
  * @Title MySQLAccess.java
  * @Package org.cloudland.dynamic.dao.mysql
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-8-1
  * @version 1.0
  */
package org.cloudland.dynamic.dao.mysql;

import java.sql.ResultSet;

import org.cloudland.dynamic.core.dao.Access;

/**
 * 
 * @ClassName MySQLAccess
 * @Description TODO
 * @author Lei
 * @date 2012-8-1 下午11:31:17
 *
 */
public class MySQLAccess implements Access {

	/* 
	 * Title insert
	 * Description
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
