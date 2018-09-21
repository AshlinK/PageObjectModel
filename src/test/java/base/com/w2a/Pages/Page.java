package base.com.w2a.Pages;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import rough.TestProperties;
import utilities.ExcelReader;
import utilities.ExtentManager;
import utilities.Property;
import utilities.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Page {
    protected static WebDriver driver;
    public static TopMenu topMenu;
    protected static Properties properties = new Properties();
    protected static Properties OR = new Properties();
    protected static FileInputStream fis;
    protected static Logger log = Logger.getLogger("devpinoyLogger");
    protected static ExcelReader excel = new ExcelReader("src/main/resources/excel/testdata.xlsx");
    protected static WebDriverWait wait;
    protected ExtentReports reports = ExtentManager.getInstance();
    protected static ExtentTest test;
    protected static WebElement dropDown;


    public Page() {
        if(driver==null) {


            Map<String,Object> prefs=new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications",2);
            prefs.put("credentials_enable_service",false);
            prefs.put("profile.password_manager_enabled",false);
            ChromeOptions options=new ChromeOptions();
            options.setExperimentalOption("prefs",prefs);
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-infobars");

            if (TestProperties.get(Property.BROWSER).equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.executables.chrome.driver", "src/main/resources/executables/executables.chrome/mac/chromedriver");
                driver = new ChromeDriver(options);
                log.debug("Initialized executables.chrome driver");
            } else if (TestProperties.get(Property.BROWSER).equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.executables.chrome.driver", "src/main/resources/executables/executables.chrome/mac/firefoxdriver");
                driver = new FirefoxDriver();
            } else if (TestProperties.get(Property.BROWSER).equalsIgnoreCase("ie")) {
                System.setProperty("webdriver.ie.driver", "src/main/resources/executables/executables.chrome/mac/iedriver");
                driver = new FirefoxDriver();
            }
            driver.get(TestProperties.get(Property.TEST_SITE_URL));
            log.debug("Navigated to "+TestProperties.get(Property.TEST_SITE_URL));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Long.parseLong(TestProperties.get(Property.IMPLICIT_WAIT)), TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 10);
            topMenu=new TopMenu(driver);

        }
    }


    public void click(String locator) {
        driver.findElement(By.xpath(locator)).click();
        //test.log(LogStatus.INFO, "Clicking on :" + locator);
    }



    public void type(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
        //   test.log(LogStatus.INFO, "Typing in :" + locator + " entered value as " + value);
    }

    public static void verifyEquals(String expected, String actual) throws IOException {
        try {
            Assert.assertEquals(actual, expected);

        } catch (Throwable t) {
            Utilities.captureScreenshot();
            Reporter.log("<br>" + " Verification failure:" + t.getMessage() + "</br>");
            Reporter.log("<a target=\"_blank\" href=\"" + Utilities.screenshotName + "\"><img src=" + Utilities.screenshotName + "height=200 width=200></img></a>");
            Reporter.log("<br>");
            Reporter.log("<br>");
            //Extent Report
            test.log(LogStatus.FAIL, "Verification failed with exception" + t.getMessage());
            test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));
        }
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void select(String locator, String visibleText) {
        dropDown = driver.findElement(By.xpath(locator));
        Select select = new Select(dropDown);
        select.selectByVisibleText(visibleText);
        test.log(LogStatus.INFO, "Selecting from drop down " + locator + " , selected value is " + visibleText);
    }

    public static void quit() {
        driver.quit();
    }
}
