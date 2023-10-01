package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest {

	public static void main(String[] args) throws Throwable {
		Connection conn = null;
		int result=0;
		try {
			Driver driver = new Driver();
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
			
				Statement statement = conn.createStatement();
			String update = "insert student values(201,'Andy',27)";
			
			//execute query	
			result = statement.executeUpdate(update);
			String query = "Select * from student";
			ResultSet resultQuery = statement.executeQuery(query);
			while(resultQuery.next())
				System.out.println(resultQuery.getString(1)+" "+resultQuery.getString(2)+" "+resultQuery.getString(3));
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			if (result==1) {
				System.out.println("school is updated succesfully");
			}
			else
				System.out.println("school not updated ");
			//close the connection
			conn.close();
			System.out.println("connection is closed");
		}
	}
}
