package com.testPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NoSelectQueryTest {

	public static void main(String[] args) throws Throwable {
		Connection con = null;
		int result=0;
		try {
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
		Statement state = con.createStatement();
		String query = "insert into student values('100','Sachin',1),(102,'Ashish',1);";
        result = state.executeUpdate(query);
	}
catch (Exception e) {
	// TODO: handle exception
}
		finally {
			if (result>0) {
				System.out.println("data is prese"
						+ "nt");
			}else {
				System.out.println("data is not updated");
			}
		}
}
}
