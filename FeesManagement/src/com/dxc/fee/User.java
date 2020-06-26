package com.dxc.fee;

import java.sql.*;

public class User {

	public static void main(String[] args) throws Exception {
		 
		 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/FeeDB", "root", "1525210511");
		 Statement stmt=con.createStatement();
		 ResultSet rs=stmt.executeQuery("select * from contact");
		 while(rs.next())
			 System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getString(4)
			 				   +rs.getInt(5) + ", " + rs.getString(6) + ", " + rs.getString(7) + ", " + rs.getString(8)
			 				   +rs.getString(9) + ", " + rs.getString(10) + ", " + rs.getString(11));
		 
		 
	}

}