package com.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.model.updatemodel;

public class Updatedoa {
	public int update(updatemodel um) {
		int count=0;
		String url="jdbc:mysql://localhost:3306/login";
		String name="root";
		String pw="vinoth";
		Connection con=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,name,pw);
			ps=con.prepareStatement("update student set sname=?,email=?,mobile=?,course=?,state=? where sid=?");
			ps.setString(1,um.getName());
			ps.setString (2,um.getEmail());
			ps.setLong(3,um.getMobile());
			ps.setString(4,um.getCourse());
			ps.setString(5, um.getState());
			ps.setInt(6, um.getId());
			count=ps.executeUpdate();
		}catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return count;

	}

}
