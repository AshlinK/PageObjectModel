package testcases;

import base.com.w2a.Pages.Page;
import base.com.w2a.Pages.ZohoAppPage;
import base.com.w2a.Pages.crm.accounts.AccountsPage;
import base.com.w2a.Pages.crm.accounts.CRMHomePage;
import base.com.w2a.Pages.crm.accounts.CreateAccountPage;
import org.testng.annotations.Test;
import utilities.Utilities;

import java.util.Hashtable;

public class CreateAccountTest {

    @Test(dataProviderClass = Utilities.class,dataProvider = "dp")
    public void createAccountTest(Hashtable<String,String> data){
        ZohoAppPage zohoAppPage=new ZohoAppPage();
        CRMHomePage crmHomePage=zohoAppPage.goToCRM();
        AccountsPage accountsPage=Page.topMenu.goToAccounts();
        CreateAccountPage createAccountPage=accountsPage.goToCreateAccount();
        createAccountPage.createAccount(data.get("accountName"));
    }
}
