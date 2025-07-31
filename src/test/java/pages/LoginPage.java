package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    // Locators – fill these in later
    private final By emailFieldLocator = By.xpath("");
    private final By passwordFieldLocator = By.xpath("");
    private final By loginButtonLocator = By.xpath("");
    private final By googleButtonLocator = AppiumBy.accessibilityId("");
    private final By appleButtonLocator = AppiumBy.accessibilityId("");
    private final By rememberMeCheckboxLocator = AppiumBy.accessibilityId("");
    private final By forgotPasswordButtonLocator = AppiumBy.accessibilityId("");
    private final By signupButtonLocator = AppiumBy.accessibilityId("");
    private final By languageButtonLocator = AppiumBy.accessibilityId("");
    private final By languageOptionLocator = AppiumBy.accessibilityId("");
    private final By errorMessageLocator = AppiumBy.accessibilityId("");
    private final By dashboardIndicatorLocator = AppiumBy.accessibilityId("");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isLoginPageVisible() {
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonLocator));
        return loginButton.isDisplayed();
    }

    public void enterEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void tapLoginButton() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
        loginButton.click();
    }

    public boolean isLoginSuccessful() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardIndicatorLocator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorMessageVisible() {
        try {
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
            return errorMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void tapRememberMe() {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(rememberMeCheckboxLocator));
        checkbox.click();
    }

    public void tapForgotPassword() {
        WebElement forgotBtn = wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordButtonLocator));
        forgotBtn.click();
    }

    public void tapContinueWithGoogle() {
        WebElement googleBtn = wait.until(ExpectedConditions.elementToBeClickable(googleButtonLocator));
        googleBtn.click();
    }

    public void tapContinueWithApple() {
        WebElement appleBtn = wait.until(ExpectedConditions.elementToBeClickable(appleButtonLocator));
        appleBtn.click();
    }

    public void tapSignupButton() {
        WebElement signupBtn = wait.until(ExpectedConditions.elementToBeClickable(signupButtonLocator));
        signupBtn.click();
    }

    public void selectLanguage() {
        WebElement langBtn = wait.until(ExpectedConditions.elementToBeClickable(languageButtonLocator));
        langBtn.click();
        WebElement langOption = wait.until(ExpectedConditions.elementToBeClickable(languageOptionLocator));
        langOption.click();
    }
}
