package listeners;

import base.com.w2a.Pages.Page;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.*;
import utilities.Utilities;

import java.io.IOException;

public class CustomListener extends Page implements ITestListener {
    public void onTestStart(ITestResult iTestResult) {
        test = reports.startTest(iTestResult.getName().toUpperCase());
        if (!Utilities.isTestRunnable(iTestResult.getName(), excel)) {
            throw new SkipException("Skipping the test " + iTestResult.getName().toUpperCase() + " as the run mode is NO");
        }
    }

    public void onTestSuccess(ITestResult iTestResult) {
        test = reports.startTest(iTestResult.getName());
        test.log(LogStatus.PASS, iTestResult.getName().toUpperCase() + " PASS");
        reports.endTest(test);
        reports.flush();
    }

    public void onTestFailure(ITestResult iTestResult) {
        test = reports.startTest(iTestResult.getName());
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        try {
            Utilities.captureScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.log(LogStatus.FAIL, iTestResult.getName().toUpperCase() + " Failed with exception" + iTestResult.getThrowable());
        test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName) + " Failed with exception" + iTestResult.getThrowable());

        Reporter.log("Capturing screenshot");
        Reporter.log("<a target=\"_blank\" href=\"" + Utilities.screenshotName + "\">Screenshot</a>");
        Reporter.log("<br>");

        reports.endTest(test);
        reports.flush();
    }

    public void onTestSkipped(ITestResult iTestResult) {
        test.log(LogStatus.SKIP, iTestResult.getName().toUpperCase() + " skipped this test");
        reports.endTest(test);
        reports.flush();
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
