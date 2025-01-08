package Selenium.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Selenium.pageObject.landingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public   WebDriver driver;
	public landingPage l1;
	
//	public WebDriver initializeDriver() throws IOException {
//		
//		//properties class
//		Properties props = new Properties();
//		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Selenium\\resources\\GlobalData.properties");
//		props.load(fis);
//		String browserName =System.getProperty("browser")!=null?System.getProperty("browser"): props.getProperty("browser");
//		System.out.println("Browser name: "+browserName);
//		
//		
//		if(browserName.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			System.out.println("setting driver to chromeDriver....");
//			driver = new ChromeDriver();
//			
//			
//		}else if(browserName.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			 this.driver = new FirefoxDriver();
//		}else if(browserName.equalsIgnoreCase("edge")) {
//			WebDriverManager.edgedriver().setup();
//			this.driver = new EdgeDriver();
//		}
//		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		
//		return driver;
//		
//	}
	
	public WebDriver initializeDriver() throws IOException {
	    Properties props = new Properties();
	    FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Selenium\\resources\\GlobalData.properties");
	    props.load(fis);
	    String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : props.getProperty("browser");
	    System.out.println("Browser name: " + browserName);

	    switch (browserName.toLowerCase()) {
	        case "chrome":
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	            break;
	        case "firefox":
	            WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	            break;
	        case "edge":
	            WebDriverManager.edgedriver().setup();
	            driver = new EdgeDriver();
	            break;
	        default:
	            throw new IllegalArgumentException("Unsupported browser: " + browserName);
	    }

	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    return driver;
	}

	
//	@BeforeMethod(alwaysRun=true)
//	public landingPage lonchApplication() throws IOException {
//		driver = initializeDriver();
//		
//		Properties props = new Properties();
////		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Selenium\\resources\\GlobalData.properties");
////		props.load(fis);
////		String url = props.getProperty("url");
////		System.out.println("The url of  application is : "+url);
//		l1=new landingPage(driver);
//		l1.goTo();
//		
//		return l1;
//	}
	@BeforeMethod(alwaysRun = true)
	public landingPage launchApplication() throws IOException {
	    driver = initializeDriver();
	    l1 = new landingPage(driver);
	    l1.goTo();
	    return l1;
	}

	
//	@AfterMethod(alwaysRun=true)
//	public void tearDown() {
//		driver.close();
//	}
	
//	public List<HashMap<String, String>> getJsonToMap(String filePath) throws IOException {
//		String jsonContent = FileUtils.readFileToString(new File(filePath),
//				StandardCharsets.UTF_8);
//	//string to Hashmap jakson databind
//		ObjectMapper mapper = new ObjectMapper();
//		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
//		return data;
//		
//	}
	
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
	    if (driver != null) {
	        driver.quit();
	    }
	}

//	public List<HashMap<String, String>> getJsonToMap(String filePath) {
//		
//	    try {
//	        String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
//	        ObjectMapper mapper = new ObjectMapper();
//	        System.out.println("mapper value got is: "+mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {}));
//	        
//	        return mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});
//	        
//	    } catch (IOException e) {
//	        System.err.println("Error reading/parsing JSON file: " + e.getMessage());
//	        e.printStackTrace();
//	        throw new RuntimeException("Failed to parse JSON file: " + filePath, e);
//	    }
//	}
//	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
//		System.out.println("under get jsonDataToMap ");
//		String jsonContent = FileUtils.readFileToString(new File(filePath),
//				StandardCharsets.UTF_8);
//	//string to Hashmap jakson databind
//		System.out.println("this is json content: "+jsonContent);
//		
//		ObjectMapper mapper = new ObjectMapper();
//		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
//		});
//		System.out.println("this is the Data: "+data);
//		return data;
//		
//	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) {
	    try {
	        
	        
	        // Ensure the file exists
	        File file = new File(filePath);
	        if (!file.exists()) {
	            throw new IOException("File not found at path: " + file.getAbsolutePath());
	        }
	        
	        // Read JSON content
	        String jsonContent = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
	        
	        // Convert JSON string to List<HashMap<String, String>>
	        ObjectMapper mapper = new ObjectMapper();
	        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});
	        
	        
	        return data;
	    } catch (IOException e) {
	        System.err.println("Error reading/parsing JSON file: " + e.getMessage());
	        e.printStackTrace();
	        throw new RuntimeException("Failed to parse JSON file", e);
	    }
	}

	


	
//	public  String getScreenshot(String testCaseName ,WebDriver driver) throws IOException {
//		TakesScreenshot ts =  (TakesScreenshot)driver;
//		File source =  ts.getScreenshotAs(OutputType.FILE);
//		File path =  new File(System.getProperty("User.dir") + "//reports//" + testCaseName+ LocalDateTime.now().toString().replace(":", "-")+".png");
//		FileUtils.copyFile(source, path );
//		
//		return System.getProperty("User.dir") + "//reports//" + testCaseName+".png";
//		
//	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
	    if (driver == null) {
	        throw new RuntimeException("WebDriver instance is null. Cannot take screenshot.");
	    }
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
//	    String fileName = System.getProperty("user.dir") + "//reports//" + testCaseName + "_" + LocalDateTime.now().toString().replace(":", "-") + ".png";
	    String fileName = System.getProperty("user.dir") + "//reports1//" + testCaseName + "_" + LocalDateTime.now().toString().replace(":", "-") + ".png";

	    FileUtils.copyFile(source, new File(fileName));
	    return fileName;
	}


	

}
