package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.util.concurrent.TimeUnit;

public class Driver{

    private static WebDriver webDriver;

    public static WebDriver getWebDriver() {

        return webDriver;
    }

    public static WebDriver iniWebDriver() {

        String browser = System.getProperty("browser");

        switch (browser) {

            case "CHROME":
                WebDriverManager.chromedriver().setup();
                ChromeDriverService chromeDriverService = new ChromeDriverService.Builder().withLogOutput(System.out).build();
                webDriver = new ChromeDriver(chromeDriverService);
                break;

            case "EDGE":
                WebDriverManager.edgedriver().setup();
                EdgeDriverService edgeDriverService = new EdgeDriverService.Builder().withLogOutput(System.out).build();
                webDriver = new EdgeDriver(edgeDriverService);
                break;

            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                FirefoxDriverService firefoxDriverService = new GeckoDriverService.Builder().withLogOutput(System.out).build();
                webDriver = new FirefoxDriver(firefoxDriverService);
                break;


            default:
                System.out.println("Unknown Browser!");
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;

        }

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get(Constants.url);

        return webDriver;


    }

    public WebElement getWebElement(By value)
    {
        return webDriver.findElement(value);
    }

    public void ThreadWait(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}