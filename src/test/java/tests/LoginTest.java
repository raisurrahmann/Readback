package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {
        OnboardPage onboardPage = new OnboardPage(driver);
        onboardPage.goToLogin();
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(loginPage.isLoginPageVisible(), "Login page not visible");

        loginPage.enterEmail("");     // email
        loginPage.enterPassword(""); //password
        loginPage.tapLoginButton();

        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login did not reach dashboard");

        Homepage homepage = new Homepage(driver);
        Assert.assertTrue(homepage.isHomePageIsOpened(), "Home not visible after login");
    }

    @Test
    public void invalidLoginShowsError() {
        OnboardPage onboardPage = new OnboardPage(driver);
        onboardPage.goToLogin();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail("");
        loginPage.enterPassword("");
        loginPage.tapLoginButton();

        Assert.assertTrue(loginPage.isErrorMessageVisible(), "No error displayed for invalid login");
    }
}