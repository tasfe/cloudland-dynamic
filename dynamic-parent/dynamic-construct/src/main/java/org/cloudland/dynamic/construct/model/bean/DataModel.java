/**
  *
  * @Title DataModel.java
  * @Package org.cloudland.dynamic.construct.model
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-8-2
  * @version 1.0
  */
package org.cloudland.dynamic.construct.model.bean;

import java.util.List;

/**
 * 数据模型描述类
 * @ClassName DataModel
 * @Description 用以描述一个类的所有信息，如：包名，类名。以及它和数据库表的映射关系。
 * @author Lei
 * @date 2012-8-2 下午04:33:05
 *
 */
public class DataModel {

	/**
	  * @Fields id 模型编号
	  */
	private String id;
	
	/**
	  * @Fields packageName 包名称
	  */
	private String packageName;
	
	/**
	  * @Fields className 类名称
	  */
	private String className;
	
	/**
	  * @Fields name 模型名称
	  */
	private String name;
	
	/**
	  * @Fields dataParameterId 数据模型管辖的数据参数编号
	  */
	private List<DataParameter> dataParameters;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DataParameter> getDataParameters() {
		return dataParameters;
	}

	public void setDataParameters(List<DataParameter> dataParameters) {
		this.dataParameters = dataParameters;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
}
