package base.com.w2a.Pages;

import base.com.w2a.Pages.crm.accounts.CRMHomePage;
import org.openqa.selenium.By;


public class ZohoAppPage extends Page {


    public void goToCliq(){
        driver.findElement(By.xpath("//div[contains(text(),'Cliq')]")).click();
    }

    public CRMHomePage goToCRM(){
        driver.findElement(By.xpath("//div[contains(text(),'CRM')]")).click();
        return new CRMHomePage();
    }


    public void goToSalesIQ(){
        driver.findElement(By.xpath("//div[contains(text(),'SalesIQ')]")).click();
    }
}
