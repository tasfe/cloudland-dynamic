/**
  *
  * @Title Table.java
  * @Package org.cloudland.dynamic.core.dao.bean
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-8-29
  * @version 1.0
  */
package org.cloudland.dynamic.core.dao.bean;

import java.util.List;

/**
 * 数据库表描述对象
 * @ClassName Table
 * @Description TODO
 * @author Lei
 * @date 2012-8-29 下午8:46:30
 *
 */
public class Table {

	/**
	  * @Fields name 表名称
	  */
	private String name;
	
	/**
	  * @Fields columns 列对象
	  */
	private List<Column> columns;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
	
}
