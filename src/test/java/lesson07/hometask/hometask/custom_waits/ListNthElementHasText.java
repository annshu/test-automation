package lesson07.hometask.hometask.custom_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementValue;

public class ListNthElementHasText implements ExpectedCondition<Boolean> {
    String elementsListLocator;
    int elementInListIndex;
    String elementText;

    public ListNthElementHasText(String elementsListLocator, int elementInListIndex, String elementText) {
        this.elementsListLocator = elementsListLocator;
        this.elementInListIndex = elementInListIndex;
        this.elementText = elementText;
    }

    @Override
    public Boolean apply(WebDriver driver) {
        try {
            List<WebElement> elements = driver.findElements(By.xpath(elementsListLocator));
            return elements.get(elementInListIndex).getText().contains(elementText);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("No such element!" + e);
            return false;
        }

    }
}
