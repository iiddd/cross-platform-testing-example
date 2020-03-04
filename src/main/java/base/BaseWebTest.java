package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static base.DriverHolder.getWebDriver;
import static base.DriverHolder.initWebDriver;

public class BaseWebTest {

    @BeforeClass
    public void beforeAnyWebTest() {
        initWebDriver();
    }

    @AfterClass
    public void afterAnyWebTest() {
        if (getWebDriver() != null)
            getWebDriver().quit();
    }
}
