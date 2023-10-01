package com.testPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteCommonData {

	public static void main(String[] args) throws IOException {
		Properties pro = new Properties();
		pro.setProperty("browser", "chrome");
		pro.setProperty("url", "http://www.rmgserver.com/");
		pro.setProperty("username", "admin");
		pro.setProperty("password", "admin");

		FileOutputStream fout = new FileOutputStream("./src/test/resources/commonData1.properties.txt");
		pro.store(fout, "write data");
		fout.close();

		// reading data
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData1.properties.txt");
		pro.load(fis);
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");

		System.out.println(BROWSER);

	}
}
