package lesson07.hometask.hometask.custom_waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class PageIsLoaded implements ExpectedCondition<Boolean> {

    String expectedPageTitle;
    String expectedPageUrl;

    public PageIsLoaded(String expectedPageTitle, String expectedPageUrl) {
        this.expectedPageTitle = expectedPageTitle;
        this.expectedPageUrl = expectedPageUrl;
    }

    @Override
    public Boolean apply(WebDriver driver) {
        Boolean isTitleCorrect = driver.getTitle().contains(expectedPageTitle);
        Boolean isUrlCorrect = driver.getCurrentUrl().contains(expectedPageUrl);
        return isTitleCorrect && isUrlCorrect;
    }

}
