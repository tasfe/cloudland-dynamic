/**
  *
  * @Title SysTableAccess.java
  * @Package org.cloudland.dynamic.erp.dao.sys
  * @Description <p>TODO</p>
  * @author Administrator
  * @date 2012-10-10
  * @version 1.0
  */
package org.cloudland.dynamic.erp.dao.sys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.cloudland.dynamic.erp.core.access.Access;
import org.cloudland.dynamic.erp.dao.conn.ConnectionFactory;
import org.cloudland.dynamic.erp.dao.sys.entity.SysColumn;
import org.cloudland.dynamic.erp.dao.sys.entity.SysTable;

/**
 * 系统表访问类
 * @ClassName SysTableAccess
 * @Description TODO
 * @author Lei
 * @date 2012-10-10 下午05:23:35
 *
 */
public class SysTableAccess implements Access<SysTable> {
	
	/**
	  * @Fields conn 数据库连接
	  */
	private Connection conn;
	
	/**
	  * 构造函数
	  */
	public SysTableAccess() {
		// 新建该类时，就会从连接工厂中获取一个数据库连接
		conn = ConnectionFactory.getConnection();
	}

	public int add(SysTable table) {
		
		String[] sql = {
				"INSERT INTO C_Sys_Table(id, name, table_physical_name, status, type) VALUES(?, ?, ?, ?, ?)",
				"INSERT INTO C_Sys_Column(id, table_id, name, colunm_physical_name, value_type, length, status) VALUES(?, ?, ?, ?, ?, ?, ?)"
		};
		
		try {
			conn.setAutoCommit(false);
			
			PreparedStatement ps = conn.prepareStatement(sql[0]);
			ps.setString(1, table.getId());
			ps.setString(2, table.getName());
			ps.setString(3, table.getPhysicalName());
			ps.setString(4, String.valueOf(table.getStatus()));
			ps.setString(5, String.valueOf(table.getType()));
			ps.executeUpdate();
			
			ps = conn.prepareStatement(sql[1]);
			for (SysColumn column : table.getColumns()) {
				ps.setString(1, column.getId());
				ps.setString(2, table.getId());
				ps.setString(3, column.getName());
				ps.setString(4, column.getPhysicalName());
				ps.setString(5, String.valueOf(column.getValueType()));
				ps.setString(6, column.getLength());
				ps.setString(7, String.valueOf(column.getStatus()));
				ps.executeUpdate();
			}

			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 0;
	}
	
	public int update(SysTable table) {
		
		return 0;
	}
	
	public int remove(SysTable table) {
		
		return 0;
	}
	
	public SysTable get(String id) {

		String[] sql = {
				"SELECT * FROM c_sys_column WHERE table_id = ?",
				"SELECT * FROM c_sys_table WHERE id = ?"
		};
		
		SysTable table = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql[0]);
			ps.setString(1, id);
			ResultSet result = ps.executeQuery();
			
			ArrayList<SysColumn> columns = new ArrayList<SysColumn>(10);
			SysColumn column = null;
			while (result.next()) {
				column = new SysColumn();
				column.setId(result.getString("id"));
				column.setTableId(result.getString("table_id"));
				column.setName(result.getString("name"));
				column.setPhysicalName(result.getString("colunm_physical_name"));
				column.setLength(result.getString("length"));
				column.setValueType(result.getString("value_type"));
				column.setStatus(result.getString("status"));
				
				columns.add(column);
			}
			
			ps = conn.prepareStatement(sql[1]);
			ps.setString(1, id);
			result = ps.executeQuery();
			
			table = new SysTable();
			table.setColumns(columns);
			if (result.next()) {
				table.setId(result.getString("id"));
				table.setName(result.getString("name"));
				table.setPhysicalName(result.getString("table_physical_name"));
				table.setType(result.getString("type"));
				table.setStatus(result.getString("status"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return table;
	}
}
