package testcases;

import base.com.w2a.Pages.HomePage;
import base.com.w2a.Pages.LoginPage;
import base.com.w2a.Pages.ZohoAppPage;
import org.testng.annotations.Test;
import utilities.Utilities;

import java.util.Hashtable;

public class LoginTest extends BaseTest {

    @Test(dataProviderClass = Utilities.class,dataProvider = "dp")
    public void loginTest(Hashtable<String,String> data){
        HomePage homepage=new HomePage();
        LoginPage loginPage=homepage.goToLogin();
        ZohoAppPage zohoAppPage=loginPage.doLogin(data.get("username"),data.get("password"));
    }
}
