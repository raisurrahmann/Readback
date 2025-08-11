package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class ForgetPasswordTest extends BaseTest {

    @Test
    public void resetPasswordHappyPath() {
        OnboardPage onboardPage = new OnboardPage(driver);
        onboardPage.goToLogin();
        LoginPage loginPage = new LoginPage(driver);

        ForgetPasswordPage fp = new ForgetPasswordPage(driver);
        loginPage.tapForgotPassword();

        fp.enterEmail(""); //correct email
        fp.tapSubmit();

        fp.enterOTP(""); // correct otp
        fp.tapVerify();

        fp.enterNewPassword("Qw@12345");
        fp.retypePassword("Qw@123245");
        fp.togglePasswordVisibility();
        fp.tapContinue();

        // Back to Login
        Assert.assertTrue(loginPage.isLoginPageVisible(), "Should be back on Login page after reset");
    }

    @Test
    public void invalidEmailShowsError() {
        OnboardPage onboardPage = new OnboardPage(driver);
        onboardPage.goToLogin();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.tapForgotPassword();
        ForgetPasswordPage fp = new ForgetPasswordPage(driver);

        fp.enterEmail("");// invalid email
        fp.tapSubmit();

        Assert.assertTrue(fp.isInvalidEmailErrorVisible(), "Invalid email error not shown");
    }

    @Test
    public void invalidOtpShowsError() {
        OnboardPage onboardPage = new OnboardPage(driver);
        onboardPage.goToLogin();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.tapForgotPassword();
        ForgetPasswordPage fp = new ForgetPasswordPage(driver);

        fp.enterEmail(""); // valid email
        fp.tapSubmit();

        fp.enterOTP(""); // wrong otp
        fp.tapVerify();

        Assert.assertTrue(fp.isInvalidOtpErrorVisible(), "Invalid OTP error not shown");
    }
}