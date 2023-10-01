package com.testPractice;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class JsonReadData {

	public static void main(String[] args) throws Throwable {
		JSONParser p = new JSONParser();
		Object obj = p.parse(new FileReader("./src/test/resources/jsonData.json.txt"));
		
		JSONObject map = (JSONObject)obj;
		System.out.println(map.get("browser"));
		System.out.println(map.get("url"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
	}
}
