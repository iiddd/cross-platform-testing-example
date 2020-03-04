package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static base.DriverHolder.getWindowsDriver;
import static base.DriverHolder.initWindowsDriver;

public class BaseXPCalculatorTest {

    @BeforeClass
    public static void setup() {
        initWindowsDriver();
    }

    @AfterClass
    public static void tearDown() {
        if (getWindowsDriver() != null) {
            getWindowsDriver().quit();
        }
    }
}