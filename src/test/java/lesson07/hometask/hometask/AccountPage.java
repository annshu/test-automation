package lesson07.hometask.hometask;
/*
3. AccountPage с методом signOut(), который возвращает новый экземпляр страницы LoginPage.

 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    @FindBy(className = "logout")
    WebElement logoutBtn;

    public WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public LoginPage signOut(){
        logoutBtn.click();
        return new LoginPage(driver);
    }
}
