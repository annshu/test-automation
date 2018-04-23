package lesson07.hometask;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;


public class CustomWaitsSuite {
    static WebDriver driver;
    String email = "ganna.shulga@gmail.com";
    String password = "test123";

    @Before
    public void setUp() {
        String os = System.getProperty("os.name").toLowerCase();

        driver = new ChromeDriver();

        if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void someTest(){
        System.out.println("some test");

    }
}
