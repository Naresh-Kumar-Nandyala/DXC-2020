package com.dxc.fee;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.*;

public class Admin {

	public void login(BufferedReader buff) throws SQLException 
	{
		String query1="Select AdminID from fees.AdminLogin where AdminID=?";
		String query2="Select password from fees.AdminLogin where password=?";
		try 
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees.AdminLogin","root","Prasanna@1409");
			PreparedStatement ps1=con.prepareStatement(query1);
		   System.out.println("enter AdminId");
			String adminID=buff.readLine();
			ps1.setString(1, adminID);
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next())
			{
				PreparedStatement ps2=con.prepareStatement(query2);
				System.out.println("enter password");
				String pswrd=buff.readLine();
				ps2.setString(1, pswrd);
				ResultSet rs2=ps2.executeQuery();
				if(rs2.next())
				{
					System.out.println("Succesfully loggedin");
				}
				else
				{
					System.out.println("invalid password");
				}
			}
				else
				{
					System.out.println("invalid id");
				}
				
			
		}
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}

	public void addaccountant(BufferedReader buff) throws  Exception {

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/FeeDB","root", "1525210511");
		String query="insert into StudentDetails(AccountantID,AccountantName,AccountantContact,AccountantGmail)"+"values(?,?,?,?)";	
		
		PreparedStatement stmtInsert = con.prepareStatement(query);
		
		System.out.println("Enter the AccountantID");
		stmtInsert.setString(1, buff.readLine());
		
		System.out.println("Enter the AccountantName");
		stmtInsert.setString(2, buff.readLine());
		
		System.out.println("Enter the AccountantContact");
		stmtInsert.setString(3, buff.readLine());
		
		System.out.println("Enter the Student Gmail");
		stmtInsert.setString(4, buff.readLine());

		System.out.println(stmtInsert.executeUpdate() + " No of Records Inserted");

		
	}

	public void viewaccountant(BufferedReader buff) throws Exception {

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/FeeDB", "root", "1525210511");
		
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("Select * from AccountDetails");
		while(rs.next())
			System.out.println(rs.getString(1)+ " " +rs.getString(2)+ " " +rs.getString(3)+ " "+rs.getString(4));
		con.close();
	}

	public void logout(BufferedReader buff) throws Exception 
	{

		String continueChoice;
		boolean data=true;
		System.out.println("Do you Want to Logout\nLogout \nCancel");
		continueChoice =buff.readLine();
		if(continueChoice.equalsIgnoreCase("Logout"))
			data=false;
			
		
	}
	

}