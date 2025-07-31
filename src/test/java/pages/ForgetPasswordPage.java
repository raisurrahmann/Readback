package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ForgetPasswordPage {
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public ForgetPasswordPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private final By emailFieldLocator = By.xpath("");
    private final By submitButtonLocator = By.xpath("");
    private final By invalidEmailErrorLocator = By.xpath("");
    private final By otpFieldLocator = By.xpath("");
    private final By verifyButtonLocator = By.xpath("");
    private final By resendButtonLocator = By.xpath("");
    private final By invalidOtpErrorLocator = By.xpath("");
    private final By newPasswordFieldLocator = By.xpath("");
    private final By confirmPasswordFieldLocator = By.xpath("");
    private final By continueButtonLocator = By.xpath("");
    private final By eyeToggleLocator = By.xpath("");


    public void enterEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        emailField.sendKeys(email);
    }

    public void tapSubmit() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        submitButton.click();
    }

    public boolean isInvalidEmailErrorVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(invalidEmailErrorLocator)).isDisplayed();
    }

    public void enterOTP(String otp) {
        WebElement otpField = wait.until(ExpectedConditions.visibilityOfElementLocated(otpFieldLocator));
        otpField.sendKeys(otp);
    }

    public void tapVerify() {
        WebElement verifyButton = wait.until(ExpectedConditions.elementToBeClickable(verifyButtonLocator));
        verifyButton.click();
    }

    public void tapResendOTP() {
        WebElement resendButton = wait.until(ExpectedConditions.elementToBeClickable(resendButtonLocator));
        resendButton.click();
    }

    public boolean isInvalidOtpErrorVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(invalidOtpErrorLocator)).isDisplayed();
    }

    public void enterNewPassword(String password) {
        WebElement newPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(newPasswordFieldLocator));
        newPasswordField.sendKeys(password);
    }

    public void retypePassword(String password) {
        WebElement confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordFieldLocator));
        confirmPasswordField.sendKeys(password);
    }

    public void togglePasswordVisibility() {
        WebElement eyeIcon = wait.until(ExpectedConditions.elementToBeClickable(eyeToggleLocator));
        eyeIcon.click();
    }

    public void tapContinue() {
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(continueButtonLocator));
        continueButton.click();
    }
}
