package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

    private static final int TIMEOUT_1_SEC = 1000;
    private static final int TIMEOUT_10_SEC = 10000;

    public void waitForPageToLoad() {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) DriverHolder.getWebDriver())
                .executeScript("return document.readyState").toString().equals("complete");
        try {
            Thread.sleep(TIMEOUT_1_SEC);
            WebDriverWait wait = new WebDriverWait(DriverHolder.getWebDriver(), TIMEOUT_10_SEC);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
}
