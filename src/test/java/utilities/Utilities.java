package utilities;

import base.com.w2a.Pages.Page;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

public class Utilities extends Page {

    public static String screenshotPath;
    public static String screenshotName;

    public static void captureScreenshot() throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        screenshotName = date.toString().replace(":", "_").replace(" ", "_") + ".jpg";
        FileUtils.copyFile(srcFile, new File("test-output/html/" + screenshotName));
    }

    @DataProvider(name = "dp")
    public Object[][] getData(Method m) {
        String sheetName = m.getName();
        int rows = excel.getRowCount(sheetName);
        int columns = excel.getColumnCount(sheetName);

        Hashtable<String, String> table = null;

        Object[][] data = new Object[rows - 1][1];
        for (int rowNum = 2; rowNum <= rows; rowNum++) {
            table = new Hashtable<String, String>();
            for (int colNum = 0; colNum < columns; colNum++) {
                table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
                data[rowNum - 2][0] = table;
            }
        }
        return data;
    }

    public static boolean isTestRunnable(String testName, ExcelReader excelReader) {
        String sheetName = "test_suite";
        int rows = excelReader.getRowCount(sheetName);
        for (int rowNum = 2; rowNum <= rows; rowNum++) {
            String testCase = excelReader.getCellData(sheetName, "TCID", rowNum);
            if (testCase.equalsIgnoreCase(testName)) {
                String runMode = excelReader.getCellData(sheetName, "Runmode", rowNum);
                if (runMode.equalsIgnoreCase("Y")) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
