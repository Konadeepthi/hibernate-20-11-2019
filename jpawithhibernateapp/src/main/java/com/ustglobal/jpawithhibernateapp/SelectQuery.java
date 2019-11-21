package com.ustglobal.jpawithhibernateapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SelectQuery {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String sql="select * from employee_info";
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			String url="jdbc:/mysql://localhost:3306/ust_ty_db?user=root&password=root";
			con=DriverManager.getConnection(url);
			stmt=con.createStatement();
			boolean res=stmt.execute(sql);
			System.out.println(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) {
				con.close();
				}if(stmt!=null) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
