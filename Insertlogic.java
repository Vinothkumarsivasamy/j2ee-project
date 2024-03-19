package com.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.Insertmodel;

public class Insertlogic {
	public int insert(Insertmodel im){
		int count=0;
		String url="jdbc:mysql://localhost:3306/login";
		String name="root";
		String pw="vinoth";
		Connection con=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,name,pw);
			ps=con.prepareStatement("insert into student (sname,email,mobile,course,state)values(?,?,?,?,?)");
			ps.setString(1,im.getName());
			ps.setString(2, im.getEmail());
			ps.setLong(3,im.getMobile());
			ps.setString(4, im.getCourse());
			ps.setString(5,im.getState());
			count =ps.executeUpdate();
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
