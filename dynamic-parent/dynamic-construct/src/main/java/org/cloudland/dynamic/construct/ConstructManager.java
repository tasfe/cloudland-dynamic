/**
  *
  * @Title ConstructManager.java
  * @Package org.cloudland.dynamic.construct
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-8-2
  * @version 1.0
  */
package org.cloudland.dynamic.construct;

import org.cloudland.dynamic.construct.model.Structure;

/**
 * 结构信息管理接口
 * @ClassName ConstructManager
 * @Description TODO
 * @author Lei
 * @date 2012-8-2 下午04:51:27
 *
 */
public interface ConstructManager<M, P> {
	
	
	/**
	  * 根据结构编号，获取该编号的结构对象
	  * @Title getDataConstruct
	  * @Description TODO
	  * @param id
	  * @return
	  */
	 Structure<P> getDataConstruct(final String id);
	
	/**
	  * 添加新的结构模型
	  * @Title addModel
	  * @Description TODO
	  * @param model
	  */
	void add(final M model);
	
	/**
	  * 更新结构模型
	  * @Title update
	  * @Description TODO
	  * @param model
	  */
	void update(final M model);
	
	/**
	  * 删除结构模型
	  * @Title remove
	  * @Description TODO
	  * @param model
	  */
	void remove(final M model);
	
	/**
	  * 新增参数到指定的结构模型中
	  * @Title addParameter
	  * @Description TODO
	  * @param modelId
	  * @param para
	  */
	void addParameter(final String modelId, final P para);
	
	/**
	  * 更新已有的参数对象
	  * @Title updateParameter
	  * @Description TODO
	  * @param para
	  */
	void updateParameter(final P para);
	
	/**
	  * 删除指定的参数对象
	  * @Title removeParameter
	  * @Description TODO
	  * @param para
	  */
	void removeParameter(final P para);
	
}
