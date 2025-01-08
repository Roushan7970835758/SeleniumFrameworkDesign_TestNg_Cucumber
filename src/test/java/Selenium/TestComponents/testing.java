package Selenium.TestComponents;

import java.util.HashMap;
import java.util.List;

public class testing {
	public static void main(String[] args) {
	    BaseTest baseTest = new BaseTest(); // Assuming BaseTest contains the method
	    String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\Selenium\\Data\\PerchaseData.json";// Update the path to your JSON file

	    try {
	        List<HashMap<String, String>> data = baseTest.getJsonDataToMap(filePath);
	        System.out.println("Parsed Data: " + data);

	        // Example: Accessing specific values
	        for (HashMap<String, String> entry : data) {
	            System.out.println("Name: " + entry.get("name"));
	            System.out.println("Password: " + entry.get("password"));
	            System.out.println("Item: " + entry.get("item"));
	        }
	    } catch (Exception e) {
	        System.err.println("Error: " + e.getMessage());
	    }
	}

}
