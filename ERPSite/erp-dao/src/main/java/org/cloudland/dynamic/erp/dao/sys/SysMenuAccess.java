/**
  *
  * @Title SysMenuAccess.java
  * @Package org.cloudland.dynamic.erp.dao.sys
  * @Description <p>TODO</p>
  * @author Administrator
  * @date 2012-10-11
  * @version 1.0
  */
package org.cloudland.dynamic.erp.dao.sys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.cloudland.dynamic.erp.core.access.Access;
import org.cloudland.dynamic.erp.dao.conn.ConnectionFactory;
import org.cloudland.dynamic.erp.dao.sys.entity.SysMenu;

/**
 * 
 * @ClassName SysMenuAccess
 * @Description TODO
 * @author Administrator
 * @date 2012-10-11 上午11:54:32
 *
 */
public class SysMenuAccess implements Access<SysMenu> {
	
	/**
	  * @Fields conn 数据库连接
	  */
	private Connection conn;
	
	public SysMenuAccess() {
		// 新建该类时，就会从连接工厂中获取一个数据库连接
		conn = ConnectionFactory.getConnection();
	}

	public int add(SysMenu menu) {
		int recode = 0;
		
		String sql = "INSERT INTO c_sys_menu(id, name, address_id, parent_id) VALUES(?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, menu.getId());
			ps.setString(2, menu.getName());
			ps.setString(3, menu.getAdderssId());
			ps.setString(4, menu.getParentId());
			recode = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return recode;
	}

	public int update(SysMenu obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int remove(SysMenu obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public SysMenu get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
