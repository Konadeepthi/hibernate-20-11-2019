package com.ustglobal.jpawithhibernateapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class InsertQuery {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String sql="insert into employee_info values(1,'vijay',68000,'M')";
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			con=DriverManager.getConnection(url);
			stmt=con.createStatement();
			int count=stmt.executeUpdate(sql);
			System.out.println("number of rows affected"+count);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) {
					con.close();
				}if(stmt!=null) {
					stmt.close();
				} 
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

