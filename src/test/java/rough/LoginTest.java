package rough;

import base.com.w2a.Pages.HomePage;
import base.com.w2a.Pages.LoginPage;
import base.com.w2a.Pages.ZohoAppPage;

public class LoginTest {
    public static void main(String[] args) {
        HomePage homepage=new HomePage();
        LoginPage loginPage=homepage.goToLogin();
        ZohoAppPage zohoAppPage=loginPage.doLogin("trainer@way2automation.com","Selenium@123");
//      CRMHomePage crmHomePage=zohoAppPage.goToCRM();
//      AccountsPage accountsPage=Page.topMenu.goToAccounts();
//      CreateAccountPage createAccountPage=accountsPage.goToCreateAccount();
//      createAccountPage.createAccount("Ashlin");

    }
}
