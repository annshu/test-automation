package lesson06.hometask;
/*
3. AccountPage с методом signOut(), который возвращает новый экземпляр страницы LoginPage.

 */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {
    @FindBy(className = "logout")
    private WebElement logoutBtn;

    public void signOut(){
        logoutBtn.click();
    }
}
