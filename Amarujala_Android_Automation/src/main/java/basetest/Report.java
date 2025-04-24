package basetest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {
    private static ExtentReports extent;

    public static ExtentReports getReportObject() {
        
        	String path =System.getProperty("user.dir")+"//reports//index.html";
        	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
            reporter.config().setReportName("App Automation Results");
            reporter.config().setDocumentTitle("Test Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Aradhya joshi");
        
        return extent;
    }
} 
