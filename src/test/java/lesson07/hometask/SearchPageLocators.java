package lesson07.hometask;

import org.openqa.selenium.By;

public interface SearchPageLocators {
    By SEARCH_STATISTICS = By.className("page-heading  product-listing");
    By SEARCH_KEYWORD = By.xpath("//*[@class='page-heading  product-listing']/span[1]");
    By SEARCH_RESULTS_LIST = By.xpath("//div/div/h5/a[@class='product-name']");

}
