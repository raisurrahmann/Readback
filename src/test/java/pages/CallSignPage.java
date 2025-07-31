package pages;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CallSignPage {
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    private final By callSignInputLocator = By.xpath("");
    private final By continueButtonLocator = By.xpath("");

    public CallSignPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterCallSign(String callSign) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(callSignInputLocator));
        input.sendKeys(callSign);
    }

    public void tapContinue() {
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueButtonLocator));
        continueBtn.click();
    }
}