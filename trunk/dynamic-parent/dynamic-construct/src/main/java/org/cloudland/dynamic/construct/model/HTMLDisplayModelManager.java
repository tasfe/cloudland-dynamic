/**
  *
  * @Title StyleConstructManager.java
  * @Package org.cloudland.dynamic.construct.model
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-8-2
  * @version 1.0
  */
package org.cloudland.dynamic.construct.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.cloudland.dynamic.construct.model.bean.HTMLElement;
import org.cloudland.dynamic.construct.model.bean.HTMLStyle;
import org.cloudland.dynamic.construct.model.bean.StyleModel;

/**
 * HTML显示模型管理类
 * @ClassName HTMLDisplayModelManager
 * @Description TODO 异常未完善
 * @author Lei
 * @date 2012-8-2 下午05:09:52
 *
 */
public class HTMLDisplayModelManager {
	
	/**
	  * @Fields MANAGER 本类实例
	  */
	private static HTMLDisplayModelManager MANAGER = new HTMLDisplayModelManager();
	
	/**
	  * @Fields MODEL 模型与字段关系集合
	  * key:模型编号
	  */
	private static HashMap<String, ModelFieldRelated> MODEL = new HashMap<String, ModelFieldRelated>();
	
	/**
	  * @Fields ELEMENTS 数据参数与显示关系集合
	  * key:数据参数编号
	  */
	private static HashMap<String, ElementRelated> ELEMENTS = new HashMap<String, ElementRelated>();

	/**
	  * @Fields STYLE HTML样式集合
	  * key:html样式编号
	  */
	private static HashMap<String, HTMLStyle> STYLES = new HashMap<String, HTMLStyle>();
	
	/**
	  * 构造函数
	  */
	private HTMLDisplayModelManager(){}
	
	/**
	  * 获取该类的实例对象
	  * @Title getInstance
	  * @Description TODO
	  * @return
	  */
	public static HTMLDisplayModelManager getInstance(){
		return MANAGER;
	}
	
	/**
	  *
	  * @Title getDataConstruct
	  * @Description TODO
	  * @param id
	  * @return
	  */
	public Structure<HTMLElement> getDataConstruct(final String id){
		ModelFieldRelated related = MODEL.get(id);
		if (null == related) {
			return null;
		}
		
		HashMap<String, HTMLElement> htmlStyles = new HashMap<String, HTMLElement>(related.dataParameterIds.length);
		ElementRelated eRelated = null;
		for (String dataParamId : related.dataParameterIds) {
			eRelated = ELEMENTS.get(dataParamId);
			
			// 添加数据参数列对应的HTML显示关系
			htmlStyles.put(eRelated.dataParameterId, new HTMLElement(eRelated.dataParameterId, STYLES.get(eRelated.htmlStyleId)));
		}
		
		return new HTMLStyleStructure(related.styleModeName, htmlStyles);
	}

	/**
	  * 新增HTML样式
	  * @Title addHTMLStyle
	  * @Description TODO
	  * @param style
	  */
	/*public void addHTMLStyle(final HTMLStyle style) {
		if (null !=STYLES.get(style.getId())) {
			//TODO 样式已存在
		}
		STYLES.put(style.getId(), style);
	}*/

	/**
	  * 更新已有HTML样式
	  * @Title updateHTMLStyle
	  * @Description TODO
	  * @param style
	  */
	public void updateHTMLStyle(final HTMLStyle style) {
		STYLES.put(style.getId(), style);
	}

	/**
	  * 删除已有的HTML样式
	  * @Title removeHTMLStyle
	  * @Description TODO
	  * @param stylel
	  */
	public void removeHTMLStyle(final HTMLStyle style) {
		STYLES.remove(style.getId());
	}

	/**
	  * 新增绑定数据参数的HTML样式模型
	  * @Title addModel
	  * @Description TODO
	  * @param model
	  */
	public void addModel(final StyleModel<HTMLElement> model) {
		ArrayList<String> dataParamArr = new ArrayList<String>(20);
		for (HTMLElement element : model.getHtmlElements()) {
			dataParamArr.add(element.getDataParameterId());// 获取此HTML显示模型所负责的数据参数
			STYLES.put(element.getHtmlStyle().getId(), element.getHtmlStyle());// 保存HTML样式
			
			// 构建列的关联的HTML样式和验证规则对象， 并加入数据参数关联显示样式集合
			ELEMENTS.put(element.getDataParameterId(), new ElementRelated(element.getDataParameterId(), element.getHtmlStyle().getId(), "验证ID暂无"));// TODO 验证后期增加
		}
		
		// 定义模型与数据参数关系[一对多]
		ModelFieldRelated related = new ModelFieldRelated(model.getId(), model.getName(), dataParamArr.toArray(new String[dataParamArr.size()]));
		MODEL.put(related.styleModelId, related);
	}

	/**
	  * 更新已有的数据参数HTML样式模型
	  * @Title updateModel
	  * @Description TODO
	  * @param model
	  */
	public void updateModel(final StyleModel<HTMLElement> model) {
		removeModel(model);
		addModel(model);
	}

	public void removeModel(final StyleModel<HTMLElement> model) {
		ModelFieldRelated related = MODEL.get(model.getId());
		for (String dataParaId : related.dataParameterIds) {
			ELEMENTS.remove(dataParaId); // 移除数据参数列映射关系
		}
		
		// 移除HTML绑定显示样式的参数对象模型
		MODEL.remove(related.styleModelId);
	}
	
	/**
	  * 模型字段关联类
	  * @ClassName modelFieldRelated
	  * @Description TODO
	  * @author Lei
	  * @date 2012-8-15 下午10:02:55
	  *
	  */
	private class ModelFieldRelated {
		
		/**
		  * @Fields styleModelId 样式模型编号
		  */
		String styleModelId;
		
		/**
		  * @Fields styleModeName 样式模型名称 
		  */
		String styleModeName;
		
		/**
		  * @Fields dataParameters 数据参数编号集合
		  */
		String[] dataParameterIds;
		
		ModelFieldRelated(String modelId, String modelName,String[] dataParamIds) {
			this.styleModelId = modelId;
			this.styleModeName = modelName;
			this.dataParameterIds = dataParamIds;
		}
		
	}
	
	/**
	  * 显示元素关联类
	  * @ClassName ElementRelated
	  * @Description TODO
	  * @author Lei
	  * @date 2012-8-15 下午10:03:07
	  *
	  */
	private class ElementRelated {
		
		/**
		  * @Fields dataParameterId 数据参数编号
		  */
		String dataParameterId;
		
		/**
		  * @Fields htmlStyleId html样式编号
		  */
		String htmlStyleId;
		
		/**
		  * @Fields validateId 验证类型编号
		  */
		String validateId;
		
		/**
		  * 构造方法
		  * @param dataParamId 数据参数编号
		  * @param htmlStyleId html样式编号
		  * @param validateId 验证规则编号
		  */
		ElementRelated(final String dataParamId, final String htmlStyleId, final String validateId){
			this.dataParameterId = dataParamId;
			this.htmlStyleId = htmlStyleId;
			this.validateId = validateId;
		}

	}
	
	
	/**
	  * HTML样式结构类
	  * @ClassName HTMLStyleStructure
	  * @Description TODO
	  * @author Lei
	  * @date 2012-8-21 下午9:28:49
	  *
	  */
	private class HTMLStyleStructure implements Structure<HTMLElement> {
		
		/**
		  * @Fields modelStyleName 样式模型名称 
		  */
		private String modelStyleName;
		
		private HashMap<String, HTMLElement> dataParamHtmlStyle;
		
		HTMLStyleStructure(final String modelName, HashMap<String, HTMLElement> htmlStyles){
			this.modelStyleName = modelName;
			this.dataParamHtmlStyle = htmlStyles;
		}

		public String getName() {
			return this.modelStyleName;
		}

		public HTMLElement getParameter(String id) {
			return dataParamHtmlStyle.get(id);
		}

		public Collection<HTMLElement> getParameters() {
			return dataParamHtmlStyle.values();
		}
		
	}

}
