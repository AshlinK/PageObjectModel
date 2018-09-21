package utilities;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extentReports;

    public static ExtentReports getInstance() {
        if (extentReports == null) {
            extentReports = new ExtentReports("target/surefire-reports/html/extent.html", true, DisplayOrder.OLDEST_FIRST);
            extentReports.loadConfig(new File("src/main/resources/extentconfig/ReportsConfig.xml"));
        }
        return extentReports;
    }
}
