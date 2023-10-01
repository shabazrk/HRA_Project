package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TyssEmployees {

	public static void main(String[] args) throws Throwable {
	
		Connection conn=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
			Scanner sc = new Scanner(System.in);
			
			System.out.println("enter a name");
			String name = sc.nextLine();
			Statement stmt =conn.createStatement(); 
			String query = "Select * from employeeInfo";
			ResultSet result = stmt.executeQuery(query);
			if(result.next()) {
				String n = result.getString(2);
				if (n.equalsIgnoreCase(name)) {
					System.out.println("name is already present");
				}
				
			}
			else {
				String insertData = "insert EmployeeInfo values(102,"+name+")";
				Statement stmt1 = conn.createStatement();
				int resultUpdate = stmt1.executeUpdate(insertData);
					if(resultUpdate==1) {
						System.out.println(name+" added to Tyss");
					}
			}
				 
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
		conn.close();	
		}
	}
}
