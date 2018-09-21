package base.com.w2a.Pages;

import org.openqa.selenium.By;
import utilities.Locators;


public class LoginPage extends Page {


    public ZohoAppPage doLogin(String username, String password){
        driver.findElement(By.id(Locators.USERNAME_ID)).sendKeys(username);
        driver.findElement(By.id(Locators.PASSWORD_ID)).sendKeys(password);
        driver.findElement(By.id(Locators.SIGNIN_BUTTON_ID)).click();

        return new ZohoAppPage();
    }

}
