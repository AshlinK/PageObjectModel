package base.com.w2a.Pages;


import base.com.w2a.Pages.crm.accounts.AccountsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopMenu {

    /**
     *
     * TopMenu ISA Page?
     *
     * HomePage HASA TopMenu
     *
     * AccountsPage HASA TopMenu
     *
     */

    public WebDriver driver;

    public TopMenu(WebDriver driver) {
        this.driver = driver;
    }

    public void goToHome(){
        driver.findElement(By.xpath("//div[@data-value='Home']")).click();
    }

    public void goToFeeds(){
        driver.findElement(By.xpath("//div[@data-value='Feeds']")).click();
    }

    public void goToLeads(){
        driver.findElement(By.xpath("//div[@data-value='Leads']")).click();
    }

    public AccountsPage goToAccounts(){
        driver.findElement(By.xpath("//div[@data-value='Accounts']")).click();
        return new AccountsPage();
    }

    public void goToContacts(){
        driver.findElement(By.xpath("//div[@data-value='Contacts']")).click();

    }

    public void signOut(){
        driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
    }

}
