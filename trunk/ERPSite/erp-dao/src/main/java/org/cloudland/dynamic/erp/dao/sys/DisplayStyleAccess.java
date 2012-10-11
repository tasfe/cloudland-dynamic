/**
 *
 * @Title DisplayStyleAccess.java
 * @Package org.cloudland.dynamic.erp.dao.sys
 * @Description <p>TODO</p>
 * @author Lei
 * @date 2012-10-10
 * @version 1.0
 */
package org.cloudland.dynamic.erp.dao.sys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.cloudland.dynamic.erp.core.access.Access;
import org.cloudland.dynamic.erp.core.commons.number.UUID32;
import org.cloudland.dynamic.erp.dao.conn.ConnectionFactory;
import org.cloudland.dynamic.erp.dao.sys.entity.DisplayStyle;

/**
 * 
 * @ClassName DisplayStyleAccess
 * @Description TODO
 * @author Lei
 * @date 2012-10-10 下午9:29:53
 * 
 */
public class DisplayStyleAccess implements Access<DisplayStyle> {

	/**
	  * @Fields conn 数据库连接
	  */
	private Connection conn;
	
	public DisplayStyleAccess() {
		// 新建该类时，就会从连接工厂中获取一个数据库连接
		conn = ConnectionFactory.getConnection();
	}

	public int add(DisplayStyle style) {
		
		int recode = 0;

		String sql = "INSERT INTO c_sys_display_style(id, name, display_style, width, height) VALUES(?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, style.getId());
			ps.setString(2, style.getName());
			ps.setString(3, style.getDisplayStyle());
			ps.setString(4, style.getWidth());
			ps.setString(5, style.getHeight());
			recode = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return recode;
	}

	public int update(DisplayStyle obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int remove(DisplayStyle obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public DisplayStyle get(String id) {

		DisplayStyle style = null;
		
		String sql = "SELECT * FROM c_sys_display_style WHERE id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet result = ps.executeQuery();
			
			if (result.next()) {
				style = new DisplayStyle();
				style.setId(result.getString("id"));
				style.setName(result.getString("name"));
				style.setDisplayStyle(result.getString("display_style"));
				style.setWidth(result.getString("width"));
				style.setHeight(result.getString("height"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return style;
	}

}
