package Objects;

import Utilities.Constants;
import Utilities.Driver;
import org.openqa.selenium.By;

public class PageLogin {

    Driver elements = new Driver();

    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By loginButton = By.id("login");
    private final By welcome = By.xpath("//h2[@class='ng-binding']");
    private final By errorMsg = By.xpath("//p[@class='red invalidUserPwd']//strong");

    public void login(String user , String pass)
    {
        elements.getWebElement(username).sendKeys(user);
        System.out.println("Entered username successfully:" + user);

        elements.getWebElement(password).sendKeys(pass);
        System.out.println("Entered password successfully:" + pass);
        elements.ThreadWait();

        elements.getWebElement(loginButton).click();
        System.out.println("Button clicked successfully.");

    }

    public String getWelcome()
    {
       return elements.getWebElement(welcome).getText();
    }

    public String getErrorMsg(){
        return elements.getWebElement(errorMsg).getText();
    }

}


