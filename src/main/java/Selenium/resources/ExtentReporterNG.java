package Selenium.resources;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public  class ExtentReporterNG {

	public static ExtentReports getReporterObject() {
//		String path = System.getProperty("User.dir")+ "\\reports\\index.html";
		
		File reportDir = new File(System.getProperty("user.dir") + "\\reports");
		

		if (!reportDir.exists()) {
		    reportDir.mkdir();
		}
		String path = reportDir.getAbsolutePath() + "\\index.html";
		System.out.println("Report Path: " + path);

		
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "Roushan Kumar");
		return extent;
	}
}
