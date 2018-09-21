package base.com.w2a.Pages.crm.accounts;

import base.com.w2a.Pages.Page;
import org.openqa.selenium.By;

public class CreateAccountPage extends Page {
    public void createAccount(String accountName){
        driver.findElement(By.id("Crm_Accounts_ACCOUNTNAME")).sendKeys(accountName);

    }
}
