package com.dxc.fee;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class Userclass<T>
{
	T obj;
	void create(T obj)
	{
		this.obj=obj;
	}
	T getInstance()
	{
		return obj;
	}
}

public class Fee 
{
		InputStreamReader isr = null;
		BufferedReader buff = null;
		Admin mAdmin = null;
		Accountant mAccountant = null;

		boolean data = true;
		String userChoice;
		
		public static void main(String[] args) throws Exception 
		{
			
			Fee mFee = new Fee();
	
			mFee.isr = new InputStreamReader(System.in);
			mFee.buff = new BufferedReader(mFee.isr);
	
			do {
					User mUser = new User();
					System.out.println("Welcome to Fees Management System\n");
					System.out.println("Select the User Type\n1. Admin\n2. Accountant");
					String mUserChoice = mFee.buff.readLine();
	
					String mOperationChoice, continueChoice;
					boolean type = true;
					
					switch (Integer.parseInt(mUserChoice)) 
					{
					case 1:
						Userclass<Admin> obj = new Userclass<Admin>();
						obj.create(new Admin());
						mFee.mAdmin = obj.getInstance();
						break;
					case 2:
						Userclass<Accountant> obj1 = new Userclass<Accountant>();
						obj1.create(new Accountant());
						mFee.mAccountant = obj1.getInstance();
						
					}
				
			}
			while(mFee.data);
		}
}