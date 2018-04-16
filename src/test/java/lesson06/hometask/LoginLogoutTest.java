package lesson06.hometask;
/*
4. Сделать тестовый класс с тремя тестами:
 1 - на логин через метод logIn,
 2 - на логин с использованием цепочки методов,
 3 - на логаут
 (в тестах проверять, что нужная страница открылась, assertThat в помощь).
  При запуске тестов делайте игнор для 1 или 2 теста.

 */

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.StringContains.containsString;
import static org.openqa.selenium.By.className;

public class LoginLogoutTest {
    static WebDriver driver;
    String email = "ganna.shulga@gmail.com";
    String password = "test123";

    @Before
    public void setUp(){
        String os = System.getProperty("os.name").toLowerCase();

        driver = new ChromeDriver();

        if (os.contains("mac")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
        }
        else{
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir"+"\\chromedriver.exe"));

        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();


    }

    @After
    public  void tearDown(){
        driver.quit();
    }


    //@Ignore
    @Test
    public void loginTest(){
        driver.findElement(className("login")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertThat(currentUrl, containsString("controller=authentication&back=my-account"));

        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.logIn(email,password);

        currentUrl = driver.getCurrentUrl();
        Assert.assertThat(currentUrl, containsString("controller=my-account"));
    }

    //@Ignore
    @Test
    public void loginChainTest(){
        driver.findElement(className("login")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertThat(currentUrl, containsString("controller=authentication&back=my-account"));

        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);

        loginPage
                .enterUsername(email)
                .enterPassword(password)
                .clickSignInBtn();

        currentUrl = driver.getCurrentUrl();
        Assert.assertThat(currentUrl, containsString("controller=my-account"));

    }

    @Test
    public void logoutTest(){
        driver.findElement(className("login")).click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertThat(currentUrl, containsString("controller=authentication&back=my-account"));

        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.logIn(email,password);

        AccountPage accountPage = PageFactory.initElements(driver,AccountPage.class);
        accountPage.signOut();

        currentUrl = driver.getCurrentUrl();
        Assert.assertThat(currentUrl, containsString("http://automationpractice.com/index.php"));

    }
}
