package com.dt.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ReportingListener implements IReporter {
    private static final String REPORTS_OUTPUT_DIR = "reports";
    private ExtentReports extent;

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        // Configure the ExtentSparkReporter
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORTS_OUTPUT_DIR + File.separator + "htmlReport" + File.separator + "automation-report"+ new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date())+".html");

        try {
            sparkReporter.loadXMLConfig("src/main/resources/extent-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Initialize ExtentReports and attach the SparkReporter
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);


        // Process each suite
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();

            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();

                buildTestNodes(context.getPassedTests(), Status.PASS);
                buildTestNodes(context.getFailedTests(), Status.FAIL);
                buildTestNodes(context.getSkippedTests(), Status.SKIP);
            }
        }

        // Flush the report
        extent.flush();
    }

    private void buildTestNodes(IResultMap tests, Status status) {
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                ExtentTest test = extent.createTest(result.getMethod().getMethodName());

                test.assignCategory(result.getMethod().getGroups());
                test.getModel().setStartTime(getTime(result.getStartMillis()));
                test.getModel().setEndTime(getTime(result.getEndMillis()));

                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable());
                    String screenshotPath = (String) result.getAttribute("screenshotPath");
                    if (screenshotPath != null) {
                        test.addScreenCaptureFromPath(screenshotPath);
                    }
                } else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }
            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

}
