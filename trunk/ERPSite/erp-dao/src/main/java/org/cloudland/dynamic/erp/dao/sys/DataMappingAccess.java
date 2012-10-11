/**
 *
 * @Title DataMappingAccess.java
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
import org.cloudland.dynamic.erp.dao.conn.ConnectionFactory;
import org.cloudland.dynamic.erp.dao.sys.entity.DataMapping;

/**
 * 
 * @ClassName DataMappingAccess
 * @Description TODO
 * @author Lei
 * @date 2012-10-10 下午10:18:12
 * 
 */
public class DataMappingAccess implements Access<DataMapping> {

	/**
	  * @Fields conn 数据库连接
	  */
	private Connection conn;
	
	/**
	  * 构造函数
	  */
	public DataMappingAccess() {
		// 新建该类时，就会从连接工厂中获取一个数据库连接
		conn = ConnectionFactory.getConnection();
	}

	public int add(DataMapping mapping) {
		
		int recode = 0;
		
		String sql = "INSERT INTO c_sys_data_mapping(id, source_type, dictionary_id, custom_sql) VALUES(?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, mapping.getId());
			ps.setString(2, mapping.getSourceType());
			ps.setString(3, mapping.getDictionaryId());
			ps.setString(4, mapping.getCustomSQL());
			recode = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return recode;
	}

	public int update(DataMapping obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int remove(DataMapping obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public DataMapping get(String id) {
		DataMapping mapping = null;
		
		String sql = "SELECT * FROM c_sys_data_mapping WHERE id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet result = ps.executeQuery();
			
			if (result.next()) {
				mapping = new DataMapping();
				mapping.setId(result.getString("id"));
				mapping.setSourceType(result.getString("source_type"));
				mapping.setDictionaryId(result.getString("dictionary_id"));
				mapping.setCustomSQL(result.getString("custom_sql"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mapping;
	}

}
