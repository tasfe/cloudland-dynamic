/**
  *
  * @Title AccessFactory.java
  * @Package org.cloudland.dynamic.dao
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-8-1
  * @version 1.0
  */
package org.cloudland.dynamic.dao;

import org.cloudland.dynamic.core.dao.Access;
import org.cloudland.dynamic.dao.connection.ConnectionManager;
import org.cloudland.dynamic.dao.mysql.MySQLAccess;

/**
 * 
 * @ClassName AccessFactory
 * @Description TODO
 * @author Lei
 * @date 2012-8-1 下午11:21:03
 *
 */
public class AccessFactory {
	
	/**
	  * 构造方法
	  */
	private AccessFactory(){}
	
	public static Access openAccess() {
		
		return new MySQLAccess(ConnectionManager.getConnection());
	}

}
