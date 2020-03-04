package pages;

import org.openqa.selenium.WebElement;

import static base.DriverHolder.getWindowsDriver;

public class CalculatorPage {

    private WebElement getNumberOneElement() {
        return getWindowsDriver().findElementByName("One");
    }

    private WebElement getNumberTwoElement() {
        return getWindowsDriver().findElementByName("Two");
    }

    private WebElement getNumberThreeElement() {
        return getWindowsDriver().findElementByName("Three");
    }

    private WebElement getNumberFourElement() {
        return getWindowsDriver().findElementByName("Four");
    }

    private WebElement getNumberFiveElement() {
        return getWindowsDriver().findElementByName("Five");
    }

    private WebElement getNumberSixElement() {
        return getWindowsDriver().findElementByName("Six");
    }

    private WebElement getNumberSevenElement() {
        return getWindowsDriver().findElementByName("Seven");
    }

    private WebElement getNumberEightElement() {
        return getWindowsDriver().findElementByName("Eight");
    }

    private WebElement getNumberNineElement() {
        return getWindowsDriver().findElementByName("Nine");
    }

    private WebElement getNumberZeroElement() {
        return getWindowsDriver().findElementByName("Zero");
    }
}
