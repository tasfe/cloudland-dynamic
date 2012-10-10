/**
  *
  * @Title DataMapping.java
  * @Package org.cloudland.dynamic.erp.dao.sys.entity
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-10-10
  * @version 1.0
  */
package org.cloudland.dynamic.erp.dao.sys.entity;

/**
 * 数据映射关系类
 * @ClassName DataMapping
 * @Description TODO
 * @author Lei
 * @date 2012-10-10 下午10:15:23
 *
 */
public class DataMapping {

	/**
	  * @Fields id 编号
	  */
	private String id;
	
	/**
	  * @Fields sourceType 数据源类型
	  */
	private String sourceType;
	
	/**
	  * @Fields dictionaryId 字典编号
	  */
	private String dictionaryId;
	
	/**
	  * @Fields customSQL 自定义SQL
	  */
	private String customSQL;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getDictionaryId() {
		return dictionaryId;
	}

	public void setDictionaryId(String dictionaryId) {
		this.dictionaryId = dictionaryId;
	}

	public String getCustomSQL() {
		return customSQL;
	}

	public void setCustomSQL(String customSQL) {
		this.customSQL = customSQL;
	}
	
}
