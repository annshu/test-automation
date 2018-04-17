package lesson09.a_proxy_elements_and_page_factory;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void firstResultShouldContainExpectedTest(){
        String query = "Dress";
        String query2 = "T-shirt";
        MainPage mainPage = new MainPage();
        mainPage.enterQuery(query);
        (new WebDriverWait(driver,10))
                .until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]")), query));


        mainPage.enterQuery(query2);

        (new WebDriverWait(driver,10))
                .until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]")), query2));


    }

    class MainPage{

        @FindBy(xpath = "//*[@id=\"index\"]/div[2]/ul/li[1")
        private WebElement advice;

        @FindBy(id = "search_query_top")
        private WebElement fieldQuery;

        MainPage() {
            PageFactory.initElements(driver,
                    this);
        }

        void enterQuery(String query){
            fieldQuery.click();
            fieldQuery.clear();
            fieldQuery.sendKeys(query);
        }

    }


}
