package lesson07.hometask.hometask.custom_waits;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class StalenessOfElement implements ExpectedCondition<Boolean> {
    WebElement element;

    public StalenessOfElement(WebElement element){
        this.element = element;
    }

    @Override
    public Boolean apply(WebDriver driver) {
        try {
            element.isDisplayed();
            return false;
        }
        catch (NoSuchElementException e){
            System.out.println("Element is not present!");
            return true;
        }
    }

    /*
    protected void stalenessOfElement(WebElement element){
            assertThat(invisibilityOf(element));
        }
     */
}
