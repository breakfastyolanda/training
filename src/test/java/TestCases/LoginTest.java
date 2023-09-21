package TestCases;

import Objects.PageLogin;
import Utilities.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Base{

    PageLogin login = new PageLogin();
    @Test()
    public void invalidLogin()
    {
        login.login(Constants.username+"t",Constants.password);
        //String welcome = login.getWelcome();
        //Assert.assertEquals(welcome,"WELCOME, CHWAYITA","Not logged in!");
        Assert.assertEquals(login.getErrorMsg(),"Your Password / Username is Incorrect!", "Logged in !");
    }
    @Test()
    public void validLogin()
    {
        login.login(Constants.username,Constants.password);
        Assert.assertEquals(login.getWelcome(),"WELCOME, CHWAYITA", "Not Logged in !");
    }

}
