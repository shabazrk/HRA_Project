package com.GenericUtility;

public class Split {
	public static void main(String[] args) {
		
String data="//input[@name='fullname']\")).sendKeys(\"Jack Sparrow\");\r\n"
		+ "		driver.findElement(By.xpath(\"//input[@name='mobile']\")).sendKeys(\"9988776544\");\r\n"
		+ "		driver.findElement(By.xpath(\"//input[@id='email']\")).sendKeys(\"jack@gmail.com\");\r\n"
		+ "		driver.findElement(By.xpath(\"//input[@id='country']\")).sendKeys(\"India\");\r\n"
		+ "		driver.findElement(By.xpath(\"//input[@id='state']\")).sendKeys(\"Karnataka\");\r\n"
		+ "		driver.findElement(By.xpath(\"//input[@id='plot_number']\")).sendKeys(\"112\");\r\n"
		+ "		driver.findElement(By.xpath(\"//input[@name='image']\")).sendKeys(\"C:\\\\Users\\\\Admin\\\\Downloads\\\\home.jpeg\");\r\n"
		+ "		driver.findElement(By.xpath(\"//input[@id='rooms']\")).sendKeys(\"2BHK\");\r\n"
		+ "		driver.findElement(By.xpath(\"//input[@id='deposit']\")).sendKeys(\"20000\");\r\n"
		+ "		driver.findElement(By.xpath(\"//input[@id='rent']\")).sendKeys(\"10000\");\r\n"
		+ "		driver.findElement(By.xpath(\"input[@id='city']\")).sendKeys(\"Bengaluru\");\r\n"
		+ "		driver.findElement(By.xpath(\"//input[@id='address']\")).sendKeys(\"Btm layout\");";
String d[]=data.split("//");
for (int i = 0; i < d.length; i++) {
	System.out.println(d[i]);
}
}
}
