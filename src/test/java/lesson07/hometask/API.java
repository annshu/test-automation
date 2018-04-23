package lesson07.hometask;


import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public abstract class API {

        abstract WebDriver getWebDriver();

        protected void open(String url){
            getWebDriver().get(url);
        }

        protected WebElement $(By locator){
            return assertThat(visibilityOfElementLocated(locator));
        }

        protected WebElement $(String xpath){
            return $(By.xpath(xpath));
        }

        protected List<WebElement> $$(By locator){
            return assertThat(visibilityOfAllElementsLocatedBy(locator));
        }

        protected void assertThat(ExpectedCondition<Boolean> condition){
            (new WebDriverWait(getWebDriver(), 10)).until(condition);
        }

        protected void assertThat(ExpectedCondition<Boolean> condition, int timeout){
            (new WebDriverWait(getWebDriver(), timeout)).until(condition);
        }

        protected  <V> V assertThat(Function<? super WebDriver, V> condition){
            return (new WebDriverWait(getWebDriver(), 10)).until(condition);
        }

        protected <V> V assertThat(Function<? super WebDriver, V> condition, int timeout){
            return (new WebDriverWait(getWebDriver(), timeout)).until(condition);
        }

        protected void listNthElementHasText(By locator, int index, String text){
            try {
                System.out.println(locator);
                List<WebElement> elements = getWebDriver().findElements(locator);
                WebElement element = elements.get(index);
                assertThat(textToBePresentInElementValue(element, text));
            }
            catch (IndexOutOfBoundsException e){
                System.out.println("No such element!" + e);
            }
        }

        protected void pageIsLoaded(String pageTitleText, String pageUrlText){
            (new WebDriverWait(getWebDriver(), 10))
                    .until(WebDriver::getTitle).contains(pageTitleText);
            (new WebDriverWait(getWebDriver(), 10))
                    .until(WebDriver::getCurrentUrl).contains(pageUrlText);

        }

        protected void stalenessOfElement(WebElement element){
            assertThat(invisibilityOf(element));
        }


        /*listNthElementHasText,
        которое по локатору, проверяет, что элемент с указанным номером содержит указанный текст
                (не забудьте обработать IndexOutOfBoundsException!!!);
        pageIsLoaded, которое, ждет, чтоб титул страницы и ее url содержали указанные тексты;
        stalenessOfElement, которое проверяет, что элемент исчез со страницы. */
    }

