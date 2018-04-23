package lesson07.hometask.hometask;
/*
1. Создать два класса LoginPage и AccountPage, используя для элементов аннотации PageFactory.
2. LoginPage с методом logIn(String username, String password),
 который состоит из enterUsername(String username),
  enterPassword(String password) и clickSignInBtn().
   Метод logIn должен возвращать новый экземпляр страницы AccountPage.
    Предусмотреть возможность логина, через цепочный вызов методов enterUsername,
     enterPassword и clickSignInBtn.
*/


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage  {
    @FindBy(className = "login")
    private WebElement loginLink;

    @FindBy(id ="email")
    private WebElement emailField;

    @FindBy(id ="passwd")
    private WebElement passwordField;

    @FindBy(id ="SubmitLogin")
    private WebElement loginBtn;

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;}



    public AccountPage logIn(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickSignInBtn();
        return new AccountPage(driver);
    }

    public LoginPage enterUsername(String username){
        emailField.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public void clickSignInBtn(){
        loginBtn.click();
    }

}
