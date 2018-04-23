package lesson07.hometask;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage implements MainPageLocators {

        private WebDriver driver;

        MainPage(WebDriver driver) {
            super(driver);
        }

        void enterQuery(String query){
            $(FIELD_QUERY_LOCATOR).click();
            $(FIELD_QUERY_LOCATOR).clear();
            $(FIELD_QUERY_LOCATOR).sendKeys(query);
        }

        void visit(){
            open("http://automationpractice.com/index.php");
        }

    }

