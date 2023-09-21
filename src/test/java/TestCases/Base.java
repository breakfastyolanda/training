package TestCases;

import Utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base {

    @Parameters({"browserName"})
    @BeforeMethod(alwaysRun = true)
    public void startTest(String browserName)
    {
        System.setProperty("browser",browserName);
        Driver.iniWebDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void endTest()
    {
        Driver.getWebDriver().close();
    }
}
