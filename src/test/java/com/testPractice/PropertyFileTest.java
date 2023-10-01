package com.testPractice;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		Properties pro = new Properties();
		pro.load(fis);
		
		String Browser = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String AdminUrl = pro.getProperty("adminUrl");
		String UserName = pro.getProperty("username");
		String Password = pro.getProperty("password");
		
		System.out.println(Browser);
		System.out.println(URL);
		System.out.println(AdminUrl);
		System.out.println(UserName);
		System.out.println(Password);
	}
}
