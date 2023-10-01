package com.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This method is used to connect Database
 * @author Admin
 *
 */
public class DatabaseUtility {
	Connection conn = null;
	public void connectionToDB() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection(IPathConstants.dbUrl,IPathConstants.dbUsername,IPathConstants.dbPassword);
	}
	/**
	 * This method  is used to execute query and get the data
	 * @param query
	 * @param columnNo
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndFetchData(String query,int columnNo, String expData) throws Throwable {
		ResultSet result = conn.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next()) {
			String actual = result.getString(columnNo);
			if (actual.equalsIgnoreCase(expData)) {
				flag=true;
				break;
			}
		}
		if(flag==true) {
			System.out.println("Data is verifie");
			return expData;
		}
		else {
			System.out.println("Data is not present");
			return " ";
		}
	}
	/**
	 * This method is used close Database connection
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		conn.close();
	}

}
