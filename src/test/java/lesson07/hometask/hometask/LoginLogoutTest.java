package lesson07.hometask.hometask;
/*
4. Сделать тестовый класс с тремя тестами:
 1 - на логин через метод logIn,
 2 - на логин с использованием цепочки методов,
 3 - на логаут
 (в тестах проверять, что нужная страница открылась, assertThat в помощь).
  При запуске тестов делайте игнор для 1 или 2 теста.

 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.core.StringContains.containsString;
import static org.openqa.selenium.By.className;

import lesson07.hometask.hometask.custom_waits.*;
import lesson07.hometask.hometask.custom_waits.PageIsLoaded;


public class LoginLogoutTest {
    static WebDriver driver;
    WebDriverWait wait;
    String email = "ganna.shulga@gmail.com";
    String password = "test123";

    String loginPageUrl =
            "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    String loginPageTitle = "Login - My Store";

    static LoginPage loginPage;
    static AccountPage accountPage;
    static SearchPage searchPage;


    @Before
    public void setUp(){
        String os = System.getProperty("os.name").toLowerCase();


        if (os.contains("mac")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
        }

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);


        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        searchPage = new SearchPage(driver);

    }

    @After
    public  void tearDown(){
        driver.quit();
    }



    @Test
    public void loginPageIsLoaded(){
        driver.findElement(className("login")).click();
        wait.until(new PageIsLoaded(loginPageTitle, loginPageUrl));

    }

    @Test
    public void popularLabelIsNotDisplayed(){
        driver.findElement(className("login")).click();
        wait.until(new PageIsLoaded(loginPageTitle, loginPageUrl));
        System.out.println(driver.getCurrentUrl());
        wait.until(new StalenessOfElement(loginPage.popularLbl));

    }

    @Test
    public void searcCriteriaIsPresentInResult(){
        String productsList = "//div[@class='product-container']//a[@class='product-name']";
        driver.findElement(className("login")).click();
        wait.until(new PageIsLoaded(loginPageTitle, loginPageUrl));
        loginPage.search("Dress");
        wait.until(new ListNthElementHasText(productsList, 3,"Dress"));
    }
}
