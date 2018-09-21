package base.com.w2a.Pages;

import org.openqa.selenium.By;
import utilities.Locators;


public class HomePage extends Page {


    public LoginPage goToLogin(){
        driver.findElement(By.className(Locators.LOGIN_CLASSNAME)).click();
        return new LoginPage();
    }

    public void goToSignUp(){
        driver.findElement(By.className("zh-signup")).click();
    }

    public void goToSupport(){
        driver.findElement(By.className("zh-support")).click();
    }

    public void goToCustomers(){
        driver.findElement(By.className("zh-customers")).click();
    }

    public void goToLearnMore(){
        driver.findElement(By.className("learn-more")).click();
    }

    public void validateFooterLinks(){

    }
}
