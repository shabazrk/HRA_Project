package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class JDBC_ExecuteQueryTest {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		try {
//		Driver driver = new Driver();
//		DriverManager.registerDriver(driver);
		
		//connect to DB
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
		
		//create statement
		Statement statement = conn.createStatement();
		String query = "Select * from student";
		
		//execute the query
		ResultSet result = statement.executeQuery(query);
		
		while (result.next()) {
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		}	
	}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			conn.close();
		}
}
}