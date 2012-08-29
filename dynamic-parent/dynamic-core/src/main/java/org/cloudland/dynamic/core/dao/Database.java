/**
  *
  * @Title Database.java
  * @Package org.cloudland.dynamic.core.dao
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-8-29
  * @version 1.0
  */
package org.cloudland.dynamic.core.dao;

import org.cloudland.dynamic.core.dao.bean.Column;
import org.cloudland.dynamic.core.dao.bean.Table;

/**
 * 数据库表结构操作接口
 * @ClassName Database
 * @Description TODO
 * @author Lei
 * @date 2012-8-29 下午8:41:43
 *
 */
public interface Database {

	/**
	  * 在数据库中创建表
	  * @Title create
	  * @Description TODO
	  * @param table
	  * @throws Exception 数据库执行过程异常
	  */
	void create(final Table table) throws Exception;
	
	/**
	  * 在数据库中创建列
	  * @Title delete
	  * @Description TODO
	  * @param table
	  * @throws Exception 数据库执行过程异常
	  */
	void delete(final Table table) throws Exception;
	
	/**
	  * 在指定的表中,创建新的列
	  * @Title create
	  * @Description TODO
	  * @param tableName
	  * @param column
	  * @throws Exception
	  */
	void create(final String tableName, final Column column) throws Exception;
	
	/**
	  * 在指定的表中,更新列结构
	  * @Title update
	  * @Description TODO
	  * @param tableName
	  * @param column
	  * @throws Exception
	  */
	void update(final String tableName, final Column column) throws Exception;
	
	/**
	  * 在指定的表中,删除指定的列
	  * @Title delete
	  * @Description TODO
	  * @param tableName
	  * @param column
	  * @throws Exception
	  */
	void delete(final String tableName, final Column column) throws Exception;
}
