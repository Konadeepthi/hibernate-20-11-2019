package com.ustglobal.jpawithhibernateapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;

public class DynamicUpdateQuery {
	public static void main(String[] args) {
	Connection con=null;
	java.sql.PreparedStatement pstmt=null;
	try {
		//Step1:Load the Driver
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		//Step2:Get the Connection
		String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
		con =DriverManager.getConnection(url);
		//step3:issue SQL query
		String sql="update employee_info set name=?,sal=?,gender= ? where id=?";
		pstmt = con.prepareStatement(sql);
		String empid=args[0];
		int id=Integer.parseInt(empid);
		String name=args[1];
		String empsal=args[2];
		int sal=Integer.parseInt(empsal);
		String gender =args[3];
		pstmt.setInt(4,id);
		pstmt.setString(1,name);
		pstmt.setInt(2,sal);
		pstmt.setString(3,gender);
		int count=pstmt.executeUpdate();
		//step4:Read The Result
		System.out.println(count + "rows are updated");
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		//step5:Close all JDBC Objects
		try {
			if(con!=null)
			{
				con.close();
			}if(pstmt!=null) {
				pstmt.close();
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
}
