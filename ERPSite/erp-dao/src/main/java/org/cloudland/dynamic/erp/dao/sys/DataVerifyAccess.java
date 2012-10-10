/**
  *
  * @Title DataVerifyAccess.java
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
import org.cloudland.dynamic.erp.dao.sys.entity.DataVerify;
import org.cloudland.dynamic.erp.dao.sys.entity.DisplayStyle;

/**
 * 
 * @ClassName DataVerifyAccess
 * @Description TODO
 * @author Lei
 * @date 2012-10-10 下午10:02:58
 *
 */
public class DataVerifyAccess implements Access<DataVerify> {
	
	/**
	  * @Fields conn 数据库连接
	  */
	private Connection conn;

	/**
	 * 构造函数
	 */
	public DataVerifyAccess() {
		// 新建该类时，就会从连接工厂中获取一个数据库连接
		conn = ConnectionFactory.getConnection();
	}

	public int add(DataVerify verify) {
		int recode = 0;
		
		String sql = "INSERT INTO c_sys_data_verify(id, rule, message) VALUES(?, ?, ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, UUID32.get());
			ps.setString(2, verify.getRule());
			ps.setString(3, verify.getMessage());
			recode = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return recode;
	}

	public int update(DataVerify obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int remove(DataVerify obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public DataVerify get(String id) {

		DataVerify verify = null;
		
		String sql = "SELECT * FROM c_sys_data_verify WHERE id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet result = ps.executeQuery();
			
			if (result.next()) {
				verify = new DataVerify();
				verify.setId(result.getString("id"));
				verify.setRule(result.getString("rule"));
				verify.setMessage(result.getString("message"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return verify;
	}
	
}
