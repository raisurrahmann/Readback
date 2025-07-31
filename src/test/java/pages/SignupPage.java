package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public SignupPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // will fill these in later
    private final By emailFieldLocator = By.xpath("");
    private final By passwordFieldLocator = By.xpath("");
    private final By confirmPasswordFieldLocator = By.xpath("");
    private final By tncCheckboxLocator = By.xpath("");
    private final By signupButtonLocator = By.xpath("");
    private final By continueWithGoogleButtonLocator = AppiumBy.accessibilityId("");
    private final By continueWithAppleButtonLocator = AppiumBy.accessibilityId("");
    private final By loginButtonLocator = By.xpath("");
    private final By tncLinkLocator = By.xpath("");
    private final By privacyPolicyLinkLocator = By.xpath("");

    public boolean isSignupPageVisible() {
        WebElement signup = wait.until(ExpectedConditions.visibilityOfElementLocated(signupButtonLocator));
        return signup.isDisplayed();
    }

    public void enterEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        passwordField.sendKeys(password);
    }

    public void confirmPassword(String password) {
        WebElement confirmPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordFieldLocator));
        confirmPassword.sendKeys(password);
    }

    public void acceptTerms() {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(tncCheckboxLocator));
        checkbox.click();
    }

    public boolean isSignupButtonClickable() {
        WebElement signupButton = wait.until(ExpectedConditions.elementToBeClickable(signupButtonLocator));
        return signupButton.isEnabled();
    }

    public void tapSignupButton() {
        WebElement signupButton = wait.until(ExpectedConditions.elementToBeClickable(signupButtonLocator));
        signupButton.click();
    }

    public void tapGoogleLogin() {
        WebElement google = wait.until(ExpectedConditions.elementToBeClickable(continueWithGoogleButtonLocator));
        google.click();
    }

    public void tapAppleLogin() {
        WebElement apple = wait.until(ExpectedConditions.elementToBeClickable(continueWithAppleButtonLocator));
        apple.click();
    }

    public void tapLogin() {
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
        login.click();
    }

    public void tapTnC() {
        WebElement tnc = wait.until(ExpectedConditions.elementToBeClickable(tncLinkLocator));
        tnc.click();
    }

    public void tapPrivacyPolicy() {
        WebElement privacy = wait.until(ExpectedConditions.elementToBeClickable(privacyPolicyLinkLocator));
        privacy.click();
    }
}
