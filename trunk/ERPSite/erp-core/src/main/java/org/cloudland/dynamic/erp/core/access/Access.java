package org.cloudland.dynamic.erp.core.access;

/**
  * 数据库对象访问接口
  * @ClassName Access
  * @Description TODO
  * @author Lei
  * @date 2012-10-10 下午04:26:15
  *
  */
public interface Access<L> {

	/**
	  * 新增数据
	  * @Title add
	  * @Description 将传入的对象数据新增至数据库中
	  * @param obj
	  * @return
	  */
	int add(L obj);
	
	/**
	  * 更新数据
	  * @Title update
	  * @Description 更新此对象在数据库中的数据
	  * @param obj
	  * @return
	  */
	int update(L obj);
	
	/**
	  * 删除数据
	  * @Title remove
	  * @Description 删除此对象数据库数据
	  * @param obj
	  * @return
	  */
	int remove(L obj);
	
	/**
	  * 获取数据
	  * @Title get
	  * @Description 获取指定编号的对象
	  * @param id
	  * @return
	  */
	L get(String id);
	
}
