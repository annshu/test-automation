package lesson07.hometask.hometask;
/*
3. AccountPage с методом signOut(), который возвращает новый экземпляр страницы LoginPage.

 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {
    @FindBy(className = "logout")
    private WebElement logoutBtn;

    public WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }


    public LoginPage signOut(){
        logoutBtn.click();
        return new LoginPage(driver);
    }
}
