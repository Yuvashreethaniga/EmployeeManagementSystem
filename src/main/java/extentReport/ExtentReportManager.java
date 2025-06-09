package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String reportName = "ExtentReport_" + timestamp + ".html";
            String reportPath = System.getProperty("user.dir") + "/ExtentReports/" + reportName;
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Tester", "Yuvashree Thaniga");
        }
        return extent;
    }

}
