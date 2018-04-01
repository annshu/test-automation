package lesson05.hometask;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.*;
/*
* 1. Зарегистрируйтесь на http://automationpractice.com

2.1. LoginTest со следующими тестами:
1й - логин
 и
2-6 - возможность открытия страничек
"ORDER HISTORY AND DETAILS",
 "MY CREDIT SLIPS",
 "MY ADDRESSES",
 "MY PERSONAL INFORMATION"
 "MY WISHLISTS".

*/


public class LoginTest {
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

    @Test
    public void loginTest(){

        driver.findElement(className("login")).click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("It's not Login page!",
                currentUrl.contains("controller=authentication&back=my-account"));
        loginUserWithEmailAndPassword(email,password);

        currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("It's not Account page!",
                currentUrl.contains("controller=my-account"));

    }

    @Test
    public void pageOrderHistoryAndDetailsIsOpened(){
        driver.findElement(className("login")).click();
        loginUserWithEmailAndPassword(email,password);

        driver.findElement(xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")).click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("It's not Order History and Details page!",
                currentUrl.contains("controller=history"));
    }

     @Test
     public void pageMyCreditSlipsIsOpened(){
         driver.findElement(className("login")).click();
         loginUserWithEmailAndPassword(email,password);

         driver.findElement(xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[2]/a/span")).click();

         String currentUrl = driver.getCurrentUrl();
         Assert.assertTrue("It's not My Credit Slips page!",
                 currentUrl.contains("controller=order-slip"));
     }

    @Test
    public void pageMyAddressesIsOpened(){
        driver.findElement(className("login")).click();
        loginUserWithEmailAndPassword(email,password);

        driver.findElement(xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a/span")).click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("It's not My Addresses page!",
                currentUrl.contains("controller=addresses"));
    }

    @Test
    public void pageMyPersonalInformationIsOpened(){
        driver.findElement(className("login")).click();
        loginUserWithEmailAndPassword(email,password);

        driver.findElement(xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span")).click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("It's not My Addresses page!",
                currentUrl.contains("controller=identity"));
    }

    @Test
    public void pageMyWishListsIsOpened(){
        driver.findElement(className("login")).click();
        loginUserWithEmailAndPassword(email,password);

        driver.findElement(xpath("//*[@id=\"center_column\"]/div/div[2]/ul/li/a/span")).click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("It's not My Addresses page!",
                currentUrl.contains("controller=mywishlist"));
    }


    public void loginUserWithEmailAndPassword(String email, String password){
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();
    }


}
