package com.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.Insertmodel;

public class deletelogic {
	public void delete(int id){
		int count=0;
		String url="jdbc:mysql://localhost:3306/login";
		String name="root";
		String pw="vinoth";
		Connection con=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,name,pw);
			ps=con.prepareStatement("delete from student where sid=?");
			ps.setInt(1,id);
			ps.executeUpdate();
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
}
}