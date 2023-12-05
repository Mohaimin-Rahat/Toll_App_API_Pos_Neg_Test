package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = createInstance();
        }
        return extent;
    }

    private static ExtentReports createInstance() {

        ExtentSparkReporter spark = new ExtentSparkReporter("Reports/Report-"+ GetCurrentDate.getCurrentDateWithTimeStamp() +".html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        return extent;
    }
}