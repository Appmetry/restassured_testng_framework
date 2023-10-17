package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListener implements ITestListener {


    ExtentReports reports;
    //  ExtentTest test;

    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = reports.createTest("Test Name " + result.getTestClass().getName() + " -- " + result.getMethod().getMethodName());
        extentTest.set(test);
    }


  /*  @Override
    public void onTestSuccess(ITestResult result) {
        test = reports.createTest(result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel("PASS TEST CASE IS : " + result.getName(), ExtentColor.GREEN));
        // ITestListener.super.onTestSuccess(result);
    }*/

    @Override
    public void onTestFailure(ITestResult result) {
       ExtentReportManager.logFailureDetails(result.getThrowable().getMessage());
      /*  test.log(Status.FAIL, MarkupHelper.createLabel("FAILED TEST CASE IS : " + result.getName(), ExtentColor.RED));
        test.log(Status.FAIL, "Failure Reason: " + result.getThrowable().getMessage());
        //ITestListener.super.onTestFailure(result);*/
    }

   /* @Override
    public void onTestSkipped(ITestResult result) {
        test = reports.createTest(result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel("SKIPPED TEST CASE IS : " + result.getName(), ExtentColor.YELLOW));
        //ITestListener.super.onTestSkipped(result);
    }*/

    @Override
    public void onStart(ITestContext context) {
        String fileName = ExtentReportManager.getReportNameWithTimeStamp();
        String fullReportPath = System.getProperty("user.dir") + "\\reports\\" + fileName;
        reports = ExtentReportManager.createExtentReport(fullReportPath, "BOOK STORE API REPORT", "REST ASSURED FRAMEWORK", "CHETAN ");
        // configExtentReport();

    }

    @Override
    public void onFinish(ITestContext context) {
        if (reports != null)
            reports.flush();
    }
    //  ITestListener.super.onFinish(context);
}


