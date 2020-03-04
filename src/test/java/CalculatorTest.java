import base.BaseXPCalculatorTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static base.DriverHolder.getWindowsDriver;

public class CalculatorTest extends BaseXPCalculatorTest {

    @BeforeMethod
    public void clear() {
        getWindowsDriver().findElementByName("Clear").click();
        Assert.assertEquals("0", getCalculatorResultText());
    }

    @Test
    public void addition() {
        getWindowsDriver().findElementByName("One").click();
        getWindowsDriver().findElementByName("Plus").click();
        getWindowsDriver().findElementByName("Seven").click();
        getWindowsDriver().findElementByName("Equals").click();
        Assert.assertEquals("8", getCalculatorResultText());
    }

    @Test
    public void combination() {
        getWindowsDriver().findElementByName("Seven").click();
        getWindowsDriver().findElementByName("Multiply by").click();
        getWindowsDriver().findElementByName("Nine").click();
        getWindowsDriver().findElementByName("Plus").click();
        getWindowsDriver().findElementByName("One").click();
        getWindowsDriver().findElementByName("Equals").click();
        getWindowsDriver().findElementByName("Divide by").click();
        getWindowsDriver().findElementByName("Eight").click();
        getWindowsDriver().findElementByName("Equals").click();
        Assert.assertEquals("8", getCalculatorResultText());
    }

    @Test
    public void division() {
        getWindowsDriver().findElementByName("Eight").click();
        getWindowsDriver().findElementByName("Eight").click();
        getWindowsDriver().findElementByName("Divide by").click();
        getWindowsDriver().findElementByName("One").click();
        getWindowsDriver().findElementByName("One").click();
        getWindowsDriver().findElementByName("Equals").click();
        Assert.assertEquals("8", getCalculatorResultText());
    }

    @Test
    public void multiplication() {
        getWindowsDriver().findElementByName("Nine").click();
        getWindowsDriver().findElementByName("Multiply by").click();
        getWindowsDriver().findElementByName("Nine").click();
        getWindowsDriver().findElementByName("Equals").click();
        Assert.assertEquals("81", getCalculatorResultText());
    }

    @Test
    public void subtraction() {
        getWindowsDriver().findElementByName("Nine").click();
        getWindowsDriver().findElementByName("Minus").click();
        getWindowsDriver().findElementByName("One").click();
        getWindowsDriver().findElementByName("Equals").click();
        Assert.assertEquals("8", getCalculatorResultText());
    }

    protected String getCalculatorResultText() {
        WebElement calculatorResult = getWindowsDriver().findElementByAccessibilityId("CalculatorResults");
        return calculatorResult.getText().replace("Display is", "").trim();
    }
}