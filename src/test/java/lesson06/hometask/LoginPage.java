package lesson06.hometask;
/*
1. Создать два класса LoginPage и AccountPage, используя для элементов аннотации PageFactory.
2. LoginPage с методом logIn(String username, String password),
 который состоит из enterUsername(String username),
  enterPassword(String password) и clickSignInBtn().
   Метод logIn должен возвращать новый экземпляр страницы AccountPage.
    Предусмотреть возможность логина, через цепочный вызов методов enterUsername,
     enterPassword и clickSignInBtn.
*/


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(className = "login")
    private WebElement loginLink;

    @FindBy(id ="email")
    private WebElement emailField;

    @FindBy(id ="passwd")
    private WebElement passwordField;

    @FindBy(id ="SubmitLogin")
    private WebElement loginBtn;


    public void logIn(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickSignInBtn();
    }

    public void enterUsername(String username){
        emailField.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickSignInBtn(){
        loginBtn.click();
    }

}
