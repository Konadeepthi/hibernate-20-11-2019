package com.ustglobal.jpawithhibernateapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;

public class DynamicSelectQuery {
	public static void main(String[] args) {
	Connection con=null;
	java.sql.PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql="select * from employee_info where id=?";
	String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
	try {
		Driver driver=new Driver();
		DriverManager.deregisterDriver(driver);
		con=DriverManager.getConnection(url);
		pstmt=con.prepareStatement(sql);
		String empid=args[0];
		int id=Integer.parseInt(empid);
		pstmt.setInt(1, id);
		if(rs.next()) {
			int emp_id=rs.getInt("id");
			int sal=rs.getInt("sal");
			String name=rs.getString("name");
			String gender=rs.getString("gender");
			System.out.println("Id is "+id);
			System.out.println("Name is "+name);
			System.out.println("salary is "+sal);
			System.out.println("Gender is "+gender);
			System.out.println("******************");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
