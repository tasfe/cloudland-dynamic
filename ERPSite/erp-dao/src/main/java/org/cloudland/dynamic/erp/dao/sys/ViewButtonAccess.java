/**
  *
  * @Title ViewButtonAccess.java
  * @Package org.cloudland.dynamic.erp.dao.sys
  * @Description <p>TODO</p>
  * @author Administrator
  * @date 2012-10-11
  * @version 1.0
  */
package org.cloudland.dynamic.erp.dao.sys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.cloudland.dynamic.erp.core.access.Access;
import org.cloudland.dynamic.erp.dao.conn.ConnectionFactory;
import org.cloudland.dynamic.erp.dao.sys.entity.ViewButton;

/**
 * 视图按钮信息访问类
 * @ClassName ViewButtonAccess
 * @Description TODO
 * @author Lei
 * @date 2012-10-11 上午11:26:18
 *
 */
public class ViewButtonAccess implements Access<ViewButton> {
	
	/**
	  * @Fields conn 数据库连接
	  */
	private Connection conn;
	
	public ViewButtonAccess() {
		// 新建该类时，就会从连接工厂中获取一个数据库连接
		conn = ConnectionFactory.getConnection();
	}

	public int add(ViewButton button) {
		int recode = 0;
		
		String sql = "INSERT INTO c_sys_view_model_button(id, view_id, name, event, order_number) VALUES(?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, button.getId());
			ps.setString(2, button.getViewId());
			ps.setString(3, button.getName());
			ps.setString(4, button.getEvent());
			ps.setString(5, button.getOrder());
			recode = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return recode;
	}

	public int update(ViewButton obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int remove(ViewButton obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ViewButton get(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* 
	  * 获取视图编号下所有的数据信息
	  * Title get
	  * Description
	  * @param viewId 视图编号
	  * @return
	  * @see org.cloudland.dynamic.erp.core.access.Access#get(java.lang.String)
	  */
	public List<ViewButton> getSpecifyData(String viewId) {
		List<ViewButton> array = null;
		
		String sql = "SELECT * FROM c_sys_view_model_button WHERE view_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, viewId);
			ResultSet result = ps.executeQuery();
			
			array = new ArrayList<ViewButton>(16);
			ViewButton button = null;
			while (result.next()) {
				button = new ViewButton();
				button.setId(result.getString("id"));
				button.setViewId(result.getString("view_id"));
				button.setName(result.getString("name"));
				button.setEvent(result.getString("event"));
				button.setOrder(result.getString("order_number"));
				
				array.add(button);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return array;
	}
	
}
