package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportManager {

    public static ExtentReports createExtentReport(String filePath) {
        ExtentSparkReporter sparkReports = new ExtentSparkReporter(filePath);
        sparkReports.config().setReportName("Sample Extent Report");

        ExtentReports reports = new ExtentReports();
        reports.attachReporter(sparkReports);

        reports.setSystemInfo("Machine:", "TESTMC1");
        reports.setSystemInfo("OS", "WIN 11");
        reports.setSystemInfo("Blog Name", "REST ASSURED FRAMEWORK");
        reports.setSystemInfo("Author", "Chetan");

        sparkReports.config().setTheme(Theme.DARK);

        return reports;
    }


    public static String getReportNameWithTimeStamp() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedTime = dateTimeFormatter.format(localDateTime);
        String reportName = "TestReport" + formattedTime + ".html";
        return reportName;
    }
}
