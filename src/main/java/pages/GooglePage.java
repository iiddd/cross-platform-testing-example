package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static base.DriverHolder.getWebDriver;

public class GooglePage extends BasePage {

    private static final By SEARCH_FIELD_LOCATOR = By.xpath(".//input[@title='Search']");
    private static final By SEARCH_BUTTON_LOCATOR = By.xpath(".//input[@value='Google Search']");
    private static final String URL = "https://www.google.com/";

    @Step("Navigate to Google page")
    public GooglePage navigateToGooglePage() {
        getWebDriver().get(URL);
        return this;
    }

    @Step("Input text \"{value}\" to Search field")
    public GooglePage inputTextToSearchField(String value) {
        getSearchField().sendKeys(value);
        return this;
    }

    @Step("Click Search button")
    public GooglePage clickSearchButton() {
        waitForPageToLoad();
        getSearchButton().click();
        return this;
    }

    private WebElement getSearchField() {
        return getWebDriver().findElement(SEARCH_FIELD_LOCATOR);
    }

    private WebElement getSearchButton() {
        return getWebDriver().findElement(SEARCH_BUTTON_LOCATOR);
    }
}
