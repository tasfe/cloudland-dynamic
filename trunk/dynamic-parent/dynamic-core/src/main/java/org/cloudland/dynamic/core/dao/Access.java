/**
  *
  * @Title Access.java
  * @Package org.cloudland.dynamic.core.dao
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-8-1
  * @version 1.0
  */
package org.cloudland.dynamic.core.dao;

import java.sql.ResultSet;

/**
 * 
 * @ClassName Access
 * @Description TODO
 * @author Lei
 * @date 2012-8-1 下午10:48:19
 *
 */
public interface Access {
	
	/**
	  * 插入新对象数据
	  * @Title insert
	  * @Description TODO
	  * @param object
	  * @return
	  */
	<L> int insert(L object);
	
	/**
	  * 更新对象数据
	  * @Title update
	  * @Description TODO
	  * @param object
	  * @return
	  */
	<L> int update(L object);
	
	/**
	  * 删除指定对象
	  * @Title delete
	  * @Description TODO
	  * @param object
	  * @return
	  */
	<L> int delete(L object);

	/**
	  * 删除指定编号的对应类对象数据
	  * @Title deleteObject
	  * @Description TODO
	  * @param id
	  * @param clazz
	  * @return
	  */
	<L> int deleteObject(String id, Class<L> clazz);
	
	/**
	  * 查询指定编号和类类型的数据, 并返回该类数据的实例化对象
	  * @Title selectObject
	  * @Description TODO
	  * @param id
	  * @param clazz
	  * @return
	  */
	<L> L selectObject(String id, Class<L> clazz);
	
	
	/**
	  * 执行更新T-SQL
	  * @Title executeUpdate
	  * @Description TODO
	  * @param TSQL
	  * @return
	  */
	int executeUpdate(String TSQL);
	
	/**
	  * 执行查询T-SQL
	  * @Title executeQuery
	  * @Description TODO
	  * @param TSQL
	  * @return
	  */
	ResultSet executeQuery(String TSQL);
	
}
