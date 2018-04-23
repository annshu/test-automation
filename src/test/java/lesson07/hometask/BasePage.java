package lesson07.hometask;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

    public class BasePage extends API {

        protected WebDriver driver;

        @Override
        WebDriver getWebDriver() {
            return driver;
        }

        public BasePage(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }
    }

