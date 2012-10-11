/**
  *
  * @Title ViewDataAccess.java
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
import org.cloudland.dynamic.erp.dao.sys.entity.ViewData;

/**
 * 
 * @ClassName ViewDataAccess
 * @Description TODO
 * @author Lei
 * @date 2012-10-11 上午10:12:47
 *
 */
public class ViewDataAccess implements Access<ViewData> {
	
	/**
	  * @Fields conn 数据库连接
	  */
	private Connection conn;
	
	public ViewDataAccess() {
		// 新建该类时，就会从连接工厂中获取一个数据库连接
		conn = ConnectionFactory.getConnection();
	}

	public int add(ViewData data) {
		int recode = 0;
		
		String sql = "INSERT INTO c_sys_view_model_data(id, view_id, sys_column_id, style_id, verify_id, data_mapping_id, order_number) VALUES(?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, data.getId());
			ps.setString(2, data.getViewId());
			ps.setString(3, data.getSysColumnId());
			ps.setString(4, data.getStyleId());
			ps.setString(5, data.getVerifyId());
			ps.setString(6, data.getDataMappingId());
			ps.setString(7, data.getOrder());
			recode = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return recode;
	}

	public int update(ViewData data) {
		return 0;
	}

	public int remove(ViewData obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ViewData get(String id) {
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
	public List<ViewData> getSpecifyData(String viewId) {
		
		List<ViewData> array = null;
		
		String sql = "SELECT * FROM c_sys_view_model_data WHERE view_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, viewId);
			ResultSet result = ps.executeQuery();
			
			array = new ArrayList<ViewData>(16);
			ViewData data = null;
			while (result.next()) {
				data = new ViewData();
				data.setId(result.getString("id"));
				data.setViewId(result.getString("view_id"));
				data.setSysColumnId(result.getString("sys_column_id"));
				data.setStyleId(result.getString("style_id"));
				data.setVerifyId(result.getString("verify_id"));
				data.setDataMappingId(result.getString("data_mapping_id"));
				data.setOrder(result.getString("order_number"));
				
				array.add(data);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return array;
	}

}
