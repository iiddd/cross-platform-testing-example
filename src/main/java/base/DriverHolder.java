package base;

import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * This class is used to init and store Webdriver
 */

public class DriverHolder {

    private static final String BROWSER_PROPERTY = "browser";
    private static final String FF_DRIVER_PROPERTY = "gecko";
    private static final String CHROME_DRIVER_PROPERTY = "chrome";
    private static final String HEADLESS_PROPERTY = "headless";
    private static WebDriver webDriver;
    private static WindowsDriver windowsDriver;

    public static WebDriver initWebDriver() {
        if (getProfileBrowserProperty().equals(CHROME_DRIVER_PROPERTY)) {
            return getChromeDriver();
        }
        if (getProfileBrowserProperty().equals(FF_DRIVER_PROPERTY)) {
            return getFFDriver();
        } else return getChromeDriver();
    }

    public static void initWindowsDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        try {
            windowsDriver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        windowsDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static WindowsDriver getWindowsDriver() {
        return windowsDriver;
    }

    private static WebDriver getFFDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("intl.accept_languages", "en-GB");
        firefoxOptions.setProfile(firefoxProfile);
        firefoxOptions.setHeadless(isHeadless());
        webDriver = new FirefoxDriver(firefoxOptions);
        return webDriver;
    }

    private static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en-GB");
        chromeOptions.setHeadless(isHeadless());
        webDriver = new ChromeDriver(chromeOptions);
        return webDriver;
    }

    private static String getProfileBrowserProperty() {
        return System.getProperty(BROWSER_PROPERTY);
    }

    private static boolean isHeadless() {
        return Boolean.parseBoolean(System.getProperty(HEADLESS_PROPERTY));
    }
}