package lesson07.hometask.hometask;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
    @FindBy(className = "login")
    WebElement loginLink;

    @FindBy(id ="email")
    WebElement emailField;

    @FindBy(id ="passwd")
    WebElement passwordField;

    @FindBy(id ="SubmitLogin")
    WebElement loginBtn;

    @FindBy(name = "submit_search")
    WebElement searchBtn;

    @FindBy(id = "search_query_top")
    WebElement searchField;

    @FindBy(xpath ="//a[@data-toggle='tab'][contains(text(),'Popular')]")
    WebElement popularLbl;

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);}



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

    public SearchPage search(String searchCriteria){
        searchField.sendKeys(searchCriteria);
        searchBtn.click();
        return new SearchPage(driver);
    }

}
