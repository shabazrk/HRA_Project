package com.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists method to fetch common data from property files
 * @author Admin
 *
 */
public class FileUtility {

	public String getPropertyAdminValue(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.propertyFilePath);
		Properties pro = new Properties();
		pro.load(fis);
		return pro.getProperty(key);
	}
	
	public String getPropertyUserValue(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.propertyFilePath);
		Properties pro = new Properties();
		pro.load(fis);
		return pro.getProperty(key);
	}
}
