package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PhraseologyPage {
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public PhraseologyPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By phraseOptionLocator = By.xpath("");
    private final By continueButtonLocator = By.xpath("");

    public void selectPhraseologyOption() {
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(phraseOptionLocator));
        option.click();
    }

    public void tapContinue() {
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueButtonLocator));
        continueBtn.click();
    }
}
