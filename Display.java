package com.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.displaymodel;


public class Display {
	String url="jdbc:mysql://localhost:3306/login";
	String user="root";
	String pw="vinoth";
	Statement s=null;
	Connection con=null;
	public ArrayList<displaymodel>Show(){
		ArrayList<displaymodel> al=new ArrayList<displaymodel>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pw);
			s=con.createStatement();
			ResultSet rs=s.executeQuery("select * from student");
					while(rs.next()) {
						int astudentid=rs.getInt("sid");
						String aname=rs.getString("sname");
						String aemail=rs.getString("email");
						long amobile=rs.getLong("mobile");
						String acourse=rs.getString("course");
						String astate=rs.getString("state");
						displaymodel sw=new displaymodel(astudentid,aname,aemail,amobile,acourse,astate);
						al.add(sw);
					}
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				s.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return al;
	}

}
