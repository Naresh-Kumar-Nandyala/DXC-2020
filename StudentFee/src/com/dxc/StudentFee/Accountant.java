package com.dxc.StudentFee;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

public class Accountant {
	
	
	 Connection conn;
	public void showMessage(String message) {
		System.out.println(message);
		}
	
		public void select(BufferedReader buf)
		{
			String query="select accemail from feedue.accdetails where accid=?";
			try
			{
				conn=EntireFeeDetail.getInstance();
				
				showMessage("step1");
				PreparedStatement preparedStatement=conn.prepareStatement(query);
				showMessage("step2");
				showMessage("Enter your account id");
				int accid=Integer.parseInt(buf.readLine());
				preparedStatement.setInt(1,accid);
				ResultSet resultSet=preparedStatement.executeQuery();
				showMessage("step3");
				while(resultSet.next())
				{
					String accemail=resultSet.getString("accemail");
					showMessage("login successfully" +accemail);
					
					
				}
				showMessage("step4");
				
				showMessage("step5");
				
			}
		
			catch(Exception e)
			{
				 e.printStackTrace();
			}
			
			
			
			
		}
		public void addstudent(BufferedReader buf) 
		{
			String query=("insert into feedue.student values(?,?,?,?,?,?,?,?,?,?)");
			
				
				try
				{
					conn=EntireFeeDetail.getInstance();
					showMessage("step1");
				PreparedStatement ps=conn.prepareStatement(query);
				
				showMessage("enter the StudentName ");
				String student_name=buf.readLine();
				ps.setString(1, student_name); 
				
				showMessage("enter the Email ");
				String student_email=buf.readLine();
				ps.setString(2, student_email);
				
				showMessage("enter the Course");
				String student_course =buf.readLine();
				ps.setString(3, student_course);
				
				showMessage("enter the Fee ");
				String student_fee =buf.readLine();
				ps.setString(4, student_fee);
				
				showMessage("enter the due");
				String student_due=buf.readLine();
				ps.setString(5, student_due);
				
				showMessage("enter the adress ");
				String student_address=buf.readLine();
				
				ps.setString(6, student_address);
				
				showMessage("enter the city ");
				String student_city=buf.readLine();
				ps.setString(7, student_city);
				
				showMessage("enter the state ");
				String student_state=buf.readLine();
		        ps.setString(8, student_state);
				
		        showMessage("enter the country");
				String student_country=buf.readLine();
				ps.setString(9,student_country);
				
				showMessage("enter the phno ");
				String student_phno=buf.readLine();
				ps.setString(10,student_phno);
				
				
				ps.executeUpdate();
				
				showMessage("step5");
				} 
				
				
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		public void viewstudent(BufferedReader buf)
		{
			String query="select student_name from feedue.student where student_phno=?";
			try
			{
				conn=EntireFeeDetail.getInstance();
				showMessage("step1");
				PreparedStatement preparedStatement=conn.prepareStatement(query);
				showMessage("step2");
				showMessage("Enter student phno");
				String student_phno=buf.readLine();
				preparedStatement.setString(1, student_phno);
				ResultSet resultSet=preparedStatement.executeQuery();
				while(resultSet.next())
				{
					String studentname=resultSet.getString("student_name");
					
					showMessage("student data viewed successfully"+studentname);
				}
				
			}
			catch(Exception e)
			 {
				 e.printStackTrace();
			 }
				
		}
		
public void editstudent(BufferedReader buf)
{
	
	String query="update feedue.student  set student_name=? where student_city=?";
	try
	{
		conn=EntireFeeDetail.getInstance();
		showMessage("step1");
		PreparedStatement preparedStatement=conn.prepareStatement(query);
		showMessage("step2");
		preparedStatement.setString(1,"shiva");
		preparedStatement.setString(2,"hyd");
		showMessage(preparedStatement.executeUpdate() + " No of Records Updated");
		showMessage("step3");
		
		
	}
		catch(Exception e)
	{
		e.printStackTrace();
	}
}
public void viewdue(BufferedReader buf)
{
	String query="select student_due from feedue.student where student_phno=?";
	try
	{
		conn=EntireFeeDetail.getInstance();
		showMessage("step1");
		PreparedStatement preparedStatement=conn.prepareStatement(query);
		showMessage("step2");
		showMessage("Enter student phno");
		String student_phno=buf.readLine();
		preparedStatement.setString(1, student_phno);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next())
		{
			String studentdue=resultSet.getString("student_due");
			showMessage("student data viewed successfully"+studentdue);
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