/**
  *
  * @Title DataConstructManager.java
  * @Package org.cloudland.dynamic.construct.model
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-8-2
  * @version 1.0
  */
package org.cloudland.dynamic.construct.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;

import org.cloudland.dynamic.construct.model.bean.DataModel;
import org.cloudland.dynamic.construct.model.bean.DataParameter;

/**
 * 数据结构管理接口实现类
 * @ClassName DataConstructManager
 * @Description TODO
 * @author Lei
 * @date 2012-8-2 下午05:04:03
 */
public class DataConstructManager {
	
	/**
	  * @Fields MANAGER 结构对象
	  */
	private static DataConstructManager MANAGER = new DataConstructManager();

	/**
	  * @Fields MODELS 数据模型对象集合
	  */
	private static HashMap<String, InsideDataModel> MODELS = new HashMap<String, InsideDataModel>(10);
	
	/**
	  * @Fields PARAMETERS 模型中，包含的参数对象集合
	  */
	private static HashMap<String, DataParameter> PARAMETERS = new HashMap<String, DataParameter>(100);
	
	/**
	  * 构造函数
	  */
	private DataConstructManager(){}
	
	/**
	  * 拷贝数据模型
	  * @Title copyDataModel
	  * @Description 将 original对象数据拷贝到target对象中
	  * @param target 目标对象
	  * @param original 原对象
	  */
	private void copyDataModel(InsideDataModel target, DataModel original) {
		target.id = original.getId();
		target.name = original.getName();
		target.className = original.getClassName();
		target.packageName = original.getPackageName();
	}
	
	/**
	  * 获取数据结构管理类对象
	  * @Title getInstance
	  * @Description TODO
	  * @return
	  */
	public static DataConstructManager getInstance() {
		return MANAGER;
	}
	
	/**
	  * 根据结构编号，获取该编号的结构对象
	  * @Title getDataConstruct
	  * @Description TODO
	  * @param id
	  * @return
	  */
	public Structure<DataParameter> getDataConstruct(final String id){
		InsideDataModel inside = MODELS.get(id);
		if (null == inside) {
			return null;
		}
		
		DataStructure struct = new DataStructure();
		struct.structureName = inside.name;
		struct.parameters = new Hashtable<String, DataParameter>(inside.paramsId.length);
		for (String paraId : inside.paramsId) {
			struct.parameters.put(paraId, PARAMETERS.get(paraId));
		}
		
		return struct;
	}
	
	 /* 
	  * Title add
	  * Description
	  * @param model 数据结构模型对象
	  * @see org.cloudland.dynamic.construct.ConstructManager#add(java.lang.Object)
	  */
	public void add(final DataModel model){
		InsideDataModel inside = new InsideDataModel();
		// 将外部模型数据存入内部对象中
		copyDataModel(inside, model);
		
		// 新增模型中，参数对象不为空的前提，将其添加到参数对象集合中
		if (null  != model.getDataParameters() && !model.getDataParameters().isEmpty()) {
			inside.paramsId = new String[model.getDataParameters().size()];
			
			for (int i = 0; i < inside.paramsId.length; i++) {
				PARAMETERS.put(model.getDataParameters().get(i).getId(), model.getDataParameters().get(i)); // 添加新增参数对象
				inside.paramsId[i] = model.getDataParameters().get(i).getId();// 保存参数与模型的归属关系
			}
		}

		MODELS.put(inside.id, inside);// 添加模型对象
	}
	
	 /* 
	  * Title update
	  * Description
	  * @param model
	  * @see org.cloudland.dynamic.construct.ConstructManager#update(java.lang.Object)
	  */
	public void update(final DataModel model) {
		InsideDataModel inside = MODELS.get(model.getId());
		// 将外部模型数据存入内部对象中
		copyDataModel(inside, model);
		
		// 新增模型中，参数对象不为空的前提，将其添加到参数对象集合中
		if (null  != model.getDataParameters() && !model.getDataParameters().isEmpty()) {
			inside.paramsId = new String[model.getDataParameters().size()];
			
			for (int i = 0; i < inside.paramsId.length; i++) {
				PARAMETERS.put(model.getDataParameters().get(i).getId(), model.getDataParameters().get(i)); // 添加新增参数对象
				inside.paramsId[i] = model.getDataParameters().get(i).getId();// 保存参数与模型的归属关系
			}
		}
	}

	 /* 
	  * Title remove
	  * Description
	  * @param model
	  * @see org.cloudland.dynamic.construct.ConstructManager#remove(java.lang.Object)
	  */
	public void remove(final DataModel model) {
		InsideDataModel inside = MODELS.get(model.getId());
		for (String paraId : inside.paramsId) {
			PARAMETERS.remove(paraId);// 迭代移除参数对象
		}
		
		MODELS.remove(model.getId());// 移除模型对象
	}

	 /* 
	  * Title addParameter
	  * Description
	  * @param modelId
	  * @param para
	  * @see org.cloudland.dynamic.construct.ConstructManager#addParameter(java.lang.String, java.lang.Object)
	  */
	public void addParameter(final String modelId, final DataParameter para) {
		InsideDataModel inside = MODELS.get(modelId);
		
		if (null == inside.paramsId || 0 == inside.paramsId.length) {
			inside.paramsId = new String[]{para.getId()};
			PARAMETERS.put(para.getId(), para);// 向参数对象集合中，新增对象
			return;
		}
		
		String[] oldParaIds = inside.paramsId;// 暂存旧编号
		inside.paramsId = new String[inside.paramsId.length + 1];
		for (int i = 0; i < inside.paramsId.length; i++) {
			inside.paramsId[i] = oldParaIds[i];
		}
		inside.paramsId[inside.paramsId.length - 1] = para.getId();// 向模型对象中，添加参数对象编号
		
		PARAMETERS.put(para.getId(), para);// 向参数对象集合中，新增对象
	}
	

	 /* 
	  * Title updateParameter
	  * Description
	  * @param para
	  * @see org.cloudland.dynamic.construct.ConstructManager#updateParameter(java.lang.Object)
	  */
	public void updateParameter(final DataParameter para) {
		PARAMETERS.put(para.getId(), para);// 向参数对象集合中，新增对象
	}
	

	 /* 
	  * Title removeParameter
	  * Description
	  * @param para
	  * @see org.cloudland.dynamic.construct.ConstructManager#removeParameter(java.lang.Object)
	  */
	public void removeParameter(final DataParameter para) {
		PARAMETERS.remove(para.getId());
		
		// 查找此编号隶属于的模型对象
		String modelId = null;
		for (Entry<String, InsideDataModel> model : MODELS.entrySet()) {
			for (String paraId : model.getValue().paramsId) {
				if (paraId.equals(para.getId())) {
					modelId = model.getKey();
					break;
				}
			}
		}
		
		// 删除此模型中，所属的指定参数编号
		InsideDataModel inside = MODELS.get(modelId);
		String[] oldParaIds = inside.paramsId;
		inside.paramsId = new String[oldParaIds.length - 1];
		int i = 0;
		for (String oldParaId : oldParaIds) {
			if (oldParaId.equals(para.getId())){// 找到删除的编号
				continue;
			}
			inside.paramsId[i] = oldParaId;
			i++;
		}
		
	}
	
	/**
	  * 内部数据模型类
	  * @ClassName InsideDataModel
	  * @Description TODO
	  * @author Lei
	  * @date 2012-8-13 下午9:54:07
	  *
	  */
	private class InsideDataModel {
		
		/**
		  * @Fields id 结构编号
		  */
		String id;
		
		/**
		  * @Fields name 结构名称
		  */
		String name;
		
		/**
		  * @Fields className 类名称
		  */
		String className;
		
		/**
		  * @Fields packageName 包名称
		  */
		String packageName;
		
		/**
		  * @Fields paramsId 结构包含的参数对象编号
		  */
		String[] paramsId;
	}
	
	/**
	  * 结构信息类
	  * @ClassName DataStructure
	  * @Description TODO
	  * @author Lei
	  * @date 2012-8-13 下午10:09:14
	  *
	  */
	private class DataStructure implements Structure<DataParameter> {
		/**
		  * @Fields structureName 结构名称
		  */
		private String structureName;
		
		/**
		  * @Fields parameters 结构中，包含的所有参数对象
		  */
		private Hashtable<String, DataParameter> parameters;
		
		public String getName() {
			return this.structureName;
		}

		public DataParameter getParameter(String id) {
			return parameters.get(id);
		}

		public Collection<DataParameter> getParameters() {
			return parameters.values();
		}
	}
	
}
