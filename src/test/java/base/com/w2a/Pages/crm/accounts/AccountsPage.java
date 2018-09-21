package base.com.w2a.Pages.crm.accounts;

import base.com.w2a.Pages.Page;
import org.openqa.selenium.By;

public class AccountsPage extends Page {

    public CreateAccountPage goToCreateAccount(){
        driver.findElement(By.xpath("//button[@class='lyte-button  lytePrimaryBtn']")).click();
        return new CreateAccountPage();
    }

    public void goToImportAccounts(){

    }
}
