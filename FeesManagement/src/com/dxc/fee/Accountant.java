package com.dxc.fee;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.*;

public class Accountant {

	public void addstudent(BufferedReader buff) throws Exception {

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/FeeDB","root", "1525210511");
		String query="insert into StudentDetails(StudentID,StudentName,StudentContact,StudentGmail,STFee,SPFee,SDFee,SAddress,SCity,SState,SCountry)"
											+"values(?,?,?,?,?,?,?,?,?,?,?)";		
		PreparedStatement stmtInsert = con.prepareStatement(query);
		
		System.out.println("Enter the Student ID");
		stmtInsert.setString(1, buff.readLine());
		
		System.out.println("Enter the Student Name");
		stmtInsert.setString(2, buff.readLine());
		
		System.out.println("Enter the Student Contact");
		stmtInsert.setString(3, buff.readLine());
		
		System.out.println("Enter the Student Gmail");
		stmtInsert.setString(4, buff.readLine());
		
		System.out.println("Enter the Student Total Fee");
		stmtInsert.setString(5, buff.readLine());
		
		System.out.println("Enter the Student Paid Fee");
		stmtInsert.setString(6, buff.readLine());
		
		System.out.println("Enter the Student Due Fee");
		stmtInsert.setString(7, buff.readLine());
		
		System.out.println("Enter the SAddress");
		stmtInsert.setString(8, buff.readLine());
		
		System.out.println("Enter the SCity");
		stmtInsert.setString(9, buff.readLine());
		
		System.out.println("Enter the SCountry");
		stmtInsert.setString(10, buff.readLine());

		System.out.println(stmtInsert.executeUpdate() + " No of Records Inserted");
		
	}

	public void viewstudent(BufferedReader buff) throws Exception {

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/FeeDB","root", "1525210511");
		Statement stmt=con.createStatement();
		
		ResultSet rs=stmt.executeQuery("select * from StudentDetails");
		while(rs.next())
			System.out.println(rs.getString(1)+ " " +rs.getString(2)+ " " +rs.getString(3)+ " "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(9)
			+" "+rs.getString(10)+" "+rs.getString(11));
		con.close();
		
	}

	public void editstudent(BufferedReader buff) throws Exception {

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/FeeDB","root", "1525210511");
		Statement stmt=con.createStatement();
		PreparedStatement stmtUpdate = con.prepareStatement("Update StudentDetails  ");
		
		stmtUpdate.setString(1, buff.readLine());
		
		stmtUpdate.setString(2, buff.readLine());
		
		stmtUpdate.setString(3, buff.readLine());
		
		stmtUpdate.setString(4, buff.readLine());
		
		stmtUpdate.setString(5, buff.readLine());
		
		stmtUpdate.setString(6, buff.readLine());
		
		stmtUpdate.setString(7, buff.readLine());
		
		stmtUpdate.setString(8, buff.readLine());
		
		stmtUpdate.setString(9, buff.readLine());
		
		stmtUpdate.setString(10, buff.readLine());
		
		stmtUpdate.setString(11, buff.readLine());
	}

	public void dueefees(BufferedReader buff) throws Exception {

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/FeeDB","root", "1525210511");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select SDFee from StudentDetails");
		while(rs.next())
			System.out.println(rs.getString(6));
		con.close();
		
		
	}

	public void logout(BufferedReader buff) throws Exception {

		String continueChoice;
		boolean data=true;
		System.out.println("Do you Want to Logout\nLogout \nCancel");
		continueChoice =buff.readLine();
		if(continueChoice.equalsIgnoreCase("Logout"))
			data=false;
			
		
	}

}