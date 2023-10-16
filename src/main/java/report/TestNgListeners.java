package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListeners implements ITestListener {


    ExtentReports reports;
    ExtentTest test;

    /* public void configExtentReport() {
         sparkReports = new ExtentSparkReporter("./reports/extent-report.html");
         sparkReports.config().setReportName("Sample Extent Report");
         reports = new ExtentReports();
         reports.attachReporter(sparkReports);

         reports.setSystemInfo("Machine:", "TESTMC1");
         reports.setSystemInfo("OS", "WIN 11");
         reports.setSystemInfo("Blog Name", "REST ASSURED FRAMEWORK");
         reports.setSystemInfo("Author", "Chetan");

         sparkReports.config().setTheme(Theme.DARK);
     }*/
    @Override
    public void onTestSuccess(ITestResult result) {
        test = reports.createTest(result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel("PASS TEST CASE IS : " + result.getName(), ExtentColor.GREEN));
        // ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = reports.createTest(result.getName());
        test.log(Status.FAIL, MarkupHelper.createLabel("FAILED TEST CASE IS : " + result.getName(), ExtentColor.RED));
        //ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test = reports.createTest(result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel("SKIPPED TEST CASE IS : " + result.getName(), ExtentColor.YELLOW));
        //ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onStart(ITestContext context) {
        String fileName = ExtentReportManager.getReportNameWithTimeStamp();
        String fullReportPath = System.getProperty("user.dir") + "\\reports\\" + fileName;
        reports = ExtentReportManager.createExtentReport(fullReportPath);
        // configExtentReport();

    }

    @Override
    public void onFinish(ITestContext context) {
        if (reports != null)
            reports.flush();
    }
    //  ITestListener.super.onFinish(context);
}


