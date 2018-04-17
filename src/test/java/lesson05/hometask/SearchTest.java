package lesson05.hometask;

/*
* 1. Зарегистрируйтесь на http://automationpractice.com
2. Создать два тестовых класса:
2.2. SearchTest с одним тестом:
 открыть сайт,
 ввести в поиск "Printed Summer Dress" ,
  нажать поиск, проверить,
   что три результата и первый совпадает с запросом.
*/

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.StringContains.containsString;

public class SearchTest {
    static WebDriver driver;
    String email = "ganna.shulga@gmail.com";
    String password = "test123";

    @Before
    public void setUp(){
       // String os = System.getProperty("os.name").toLowerCase();

        driver = new ChromeDriver();
/*
        if (os.contains("mac")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
        }
        else{
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir"+"\\chromedriver.exe"));

        }
        */
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
    public void searchResultsAreCorrect(){
        String searchCriteria = "Printed Summer Dress";

        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).sendKeys(searchCriteria);
        driver.findElement(By.id("search_query_top")).submit();

        String resultsCount = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[2]")).getText();
        Assert.assertThat(resultsCount, containsString("3"));

        List<WebElement> results = driver.findElements(By.className("product-container"));
        Assert.assertEquals("The count of results is not 3!", results.size(),3 );

        Assert.assertThat(results.get(0).getText(),containsString(searchCriteria));

    }
}
