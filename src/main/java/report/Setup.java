package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;

public class Setup implements ITestListener {

    public static ExtentReports extentReports;


    public void onStart(ITestContext context) {
        String fileName = ExtentReportManag.getReportNameWithTimeStamp();
        String fullReportPath = System.getProperty("user.dir") + "\\reports\\" + fileName;
        extentReports = ExtentReportManag.createInstance(fullReportPath, "API AUTOMATION REPORT", "Test ExecutionReport");
    }

    public void onFinish(ITestContext context) {
        if (extentReports != null)
            extentReports.flush();
    }
}
