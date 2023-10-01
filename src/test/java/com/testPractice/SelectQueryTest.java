package com.testPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest {

	public static void main(String[] args) throws SQLException {
		Connection con =null;
		try {
		//Register The Driver
		Driver driver= new  Driver();
		//connect to database
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
		// Create statement
		Statement state = con.createStatement();
		String query ="select * from student;";
		//Execute The Qurey
		ResultSet Result = state.executeQuery(query);
		
		while(Result.next()) {
			System.out.println(Result .getString(1)+" "+Result.getString(2)+" "+Result.getString(3));
		}}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			con.close();
		}
		
	}

}
