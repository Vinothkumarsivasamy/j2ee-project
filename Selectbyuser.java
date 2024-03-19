package com.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.displaymodel;

public class Selectbyuser {
	public displaymodel Byuser(int id){
		int count=0;
		String url="jdbc:mysql://localhost:3306/login";
		String name="root";
		String pw="vinoth";
		Connection con=null;
		PreparedStatement ps=null;
		displaymodel dm=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,name,pw);
			ps=con.prepareStatement("select * from student where sid=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			int sid=rs.getInt("sid");
			String sname=rs.getString("sname");
			String email=rs.getString("email");
			long mobile=rs.getLong("mobile");
			String course=rs.getString("course");
			String state=rs.getString("state");
			 dm=new displaymodel(sid,sname,email,mobile,course,state);
			
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
		return dm;
}
}
