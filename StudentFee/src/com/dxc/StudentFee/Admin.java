package com.dxc.StudentFee;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

import java.sql.*;

public class Admin {
	Connection conn;
	public void showMessage(String message) {
		System.out.println(message);
		}

	
		public void insert(BufferedReader buf)
		{
			
			String query="insert into feedue.admin values(?,?)";
			try
			{
				
				 conn=EntireFeeDetail.getInstance();
				showMessage("step1");
				PreparedStatement preparedStatement=conn.prepareStatement(query);
				System.out.println("step2");
				
				showMessage("Enter username");
				String username=buf.readLine();
				preparedStatement.setString(1,username);
				showMessage("Enter password");
				String password=buf.readLine();
				
				 preparedStatement.setString(2,password );
				 preparedStatement.executeUpdate();
				 showMessage("step3");
				
				 showMessage("step5");
				 
			}
			catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			
			
			
		}
				public void select(BufferedReader buf) 
				{
					String query="select username from feedue.admin where password=?";
					try
					{
						conn=EntireFeeDetail.getInstance();
						showMessage("step1");
						PreparedStatement preparedStatement=conn.prepareStatement(query);
						System.out.println("step2");
						showMessage("Enter password");
						String password=buf.readLine();
						preparedStatement.setString(1, password);
						ResultSet resultSet=preparedStatement.executeQuery();
						while(resultSet.next())
						{
							String username=resultSet.getString("username");
							showMessage("login successfully"+username);
						}
						
					}
					catch(Exception e)
					 {
						 e.printStackTrace();
					 }
						
					}
				public void addaccountant(BufferedReader buf)
				{
					String query="insert into feedue.accdetails values(?,?,?,?)";
					try
					{
						
						conn=EntireFeeDetail.getInstance();
						showMessage("step1");
						PreparedStatement preparedStatement=conn.prepareStatement(query);
						showMessage("step2");
						
						
						showMessage("Enter account id");
						int accid=Integer.parseInt(buf.readLine());
						preparedStatement.setInt(1, accid);
						
						
						showMessage("Enter account password");
						int accpwd=Integer.parseInt(buf.readLine());
						preparedStatement.setInt(2,accpwd);
						
						
						showMessage("Enter account email");
						String accemail=buf.readLine();
						preparedStatement.setString(3, accemail);
						
						
						showMessage("Enter account phno");
		               String accphno=(buf.readLine());
						preparedStatement.setString(4, accphno);
						
						 
						 preparedStatement.executeUpdate();
						 showMessage("step3");
						
						 System.out.println("step5");
					}
					catch(Exception e)
					 {
						 e.printStackTrace();
					 }
					
				}
				public void viewaccountant(BufferedReader buf) 
				{
					String query="select accid from feedue.accdetails where accphno=?";
					try
					{
						
						showMessage("step1");
						PreparedStatement preparedStatement=conn.prepareStatement(query);
						showMessage("step2");
						showMessage("Enter account phnum");
						String accphno=(buf.readLine());
						preparedStatement.setString(1, accphno);
						ResultSet resultSet=preparedStatement.executeQuery();
						while(resultSet.next())
						{
							int accid=resultSet.getInt("accid");
							System.out.println("login successfully"+accid);
						}
						conn.close();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
						
					}
				public void logout()
				{
					showMessage("logout successfully");
			}
					
}