/**
  *
  * @Title ViewModelAccess.java
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

import org.cloudland.dynamic.erp.core.access.Access;
import org.cloudland.dynamic.erp.dao.conn.ConnectionFactory;
import org.cloudland.dynamic.erp.dao.sys.entity.ViewModel;

/**
 * 视图模型信息描述类
 * @ClassName ViewModelAccess
 * @Description TODO
 * @author Lei
 * @date 2012-10-11 上午09:26:52
 *
 */
public class ViewModelAccess implements Access<ViewModel> {
	
	/**
	  * @Fields conn 数据库连接
	  */
	private Connection conn;
	
	/**
	  * 构造函数
	  */
	public ViewModelAccess() {
		// 新建该类时，就会从连接工厂中获取一个数据库连接
		conn = ConnectionFactory.getConnection();
	}

	public int add(ViewModel view) {

		int recode = 0;
		
		String sql = "INSERT INTO c_sys_view_model(id, view_name, view_type, view_mode_url, data_source_type, data_source, view_max_number) VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, view.getId());
			ps.setString(2, view.getViewName());
			ps.setString(3, view.getViewType());
			ps.setString(4, view.getViewModeURL());
			ps.setString(5, view.getDataSourceType());
			ps.setString(6, view.getDataSource());
			ps.setString(7, view.getViewMaxNumber());
			recode = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return recode;
	}

	public int update(ViewModel obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int remove(ViewModel obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ViewModel get(String id) {
		ViewModel view = null;
		
		String sql = "SELECT * FROM c_sys_view_model WHERE id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet result = ps.executeQuery();
			
			if (result.next()) {
				view = new ViewModel();
				view.setId(result.getString("id"));
				view.setViewName(result.getString("view_name"));
				view.setViewType(result.getString("view_type"));
				view.setViewModeURL(result.getString("view_mode_url"));
				view.setDataSourceType(result.getString("data_source_type"));
				view.setDataSource(result.getString("data_source"));
				view.setViewMaxNumber(result.getString("view_max_number"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return view;
	}

}
