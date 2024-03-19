package com.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.loginmodel;
public class Login {
		int count =0;
		String url="jdbc:mysql://localhost:3306/login";
		String user="root";
		String psw="vinoth";
		Connection con=null;
		Statement s=null;
		public int select(loginmodel lm) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url,user,psw);
				s=con.createStatement();
				ResultSet rs=s.executeQuery("select*from log");
				while(rs.next()) {
					String emaildb=rs.getString("email");
					String passworddb=rs.getString("password");
					if(emaildb.equals(lm.getEmail()) && passworddb.equals(lm.getPassword()) ) {
						count++;
					}
				}
				
			}catch(SQLException|ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				try {
					s.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return count;
			
		}
		

}
