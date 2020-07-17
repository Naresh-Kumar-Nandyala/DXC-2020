package com.dxc.StudentFee;
import java.io.*;
 
import java.sql.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class EntireFeeDetail {
	InputStreamReader isr=null;
	BufferedReader buf=null;
	Admin mAdObject=null;
	Accountant mActObject=null;
	 static Connection mConnectionObject;
	 
	public static Connection getInstance() throws Exception
	 {
		 
		if(mConnectionObject == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			mConnectionObject = DriverManager.getConnection("jdbc:mysql://Localhost:3306?user=Hostroot&password=Kalyani@1234");
			
			return mConnectionObject;
		}
	 else
			return mConnectionObject;
	 
	 }

	public void showMessage(String message) {
		System.out.println(message);
		}
		
	 
	

	public static void main(String[] args){
		EntireFeeDetail mFeeObject=new EntireFeeDetail();
		try
		{
		
              
		
		mFeeObject.showMessage("welcome to fees resultant system");
		mFeeObject.isr=new InputStreamReader(System.in);
		 mFeeObject.buf=new BufferedReader(mFeeObject.isr);
		
		 mFeeObject.showMessage("select your chioce\n1. Admin\n2. Accountant");

		
		String chioce=mFeeObject.buf.readLine();
		if(chioce.equalsIgnoreCase("1"))
				{
		 mFeeObject.mAdObject=new Admin();
		mFeeObject.mAdObject.insert(mFeeObject.buf);
		mFeeObject.mAdObject.select(mFeeObject.buf);
		mFeeObject.mAdObject.addaccountant(mFeeObject.buf);
		mFeeObject.mAdObject.viewaccountant(mFeeObject.buf);
				}
		else if(chioce.equalsIgnoreCase("2"))
		{
			mFeeObject.mActObject=new Accountant();
			mFeeObject.mActObject.select(mFeeObject.buf);
			mFeeObject.mActObject.addstudent(mFeeObject.buf);
			mFeeObject.mActObject.viewstudent(mFeeObject.buf);
			mFeeObject.mActObject.editstudent(mFeeObject.buf);
			mFeeObject.mActObject.viewdue(mFeeObject.buf);
			mFeeObject.mActObject.logout();
		}
		
			
		}
		catch(Exception e)
		{
		
		e.printStackTrace();
		}
		
		finally {
			try {

				mFeeObject.buf.close();

			}
			catch(Exception e) {
			System.out.println("Exception is "+e);
			}
		}
		
		

	}
}