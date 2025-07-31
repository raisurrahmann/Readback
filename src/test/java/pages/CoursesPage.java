package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class CoursesPage {
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public CoursesPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By countryDropdownLocator = By.xpath("");
    private final By countryOptionLocator = By.xpath("");
    private final By classDropdownLocator = By.xpath("");
    private final By classOptionLocator = By.xpath("");
    private final By continueButtonLocator = By.xpath("");
    private final By skipButtonLocator = By.xpath("");

    public void selectCountry() {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(countryDropdownLocator));
        dropdown.click();
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(countryOptionLocator));
        option.click();
    }

    public void selectClass() {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(classDropdownLocator));
        dropdown.click();
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(classOptionLocator));
        option.click();
    }

    public void tapContinue() {
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueButtonLocator));
        continueBtn.click();
    }

    public void tapSkip() {
        WebElement skipBtn = wait.until(ExpectedConditions.elementToBeClickable(skipButtonLocator));
        skipBtn.click();
    }
}
