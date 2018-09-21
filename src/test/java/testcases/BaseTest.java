package testcases;

import base.com.w2a.Pages.Page;
import org.testng.annotations.AfterSuite;

public class BaseTest {

    @AfterSuite
    public void tearDown(){
        Page.quit();
    }
}
