package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class OnboardPage {
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public OnboardPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By appLogoLocator = By.xpath("");
    private final By getStartedButtonLocator = AppiumBy.accessibilityId("");
    private final By loginButtonLocator = AppiumBy.accessibilityId("");
    private final By signupGoogleButtonLocator = AppiumBy.accessibilityId("");
    private final By signupAppleButtonLocator = AppiumBy.accessibilityId("");
    private final By languageButtonLocator = AppiumBy.accessibilityId("");
    private final By selectedLanguageButtonLocator = AppiumBy.accessibilityId("");
    private final By selectedLanguageElementLocator = AppiumBy.accessibilityId("");
    private final By slideTextLocator = By.xpath("");
    private final By slideImageLocator = By.xpath("");




    public boolean isLogoVisible() {
        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(appLogoLocator));
        System.out.println("Logo is displayed");
        return logo.isDisplayed();
    }


    public boolean isLandingPageVisible() {
        WebElement getStartedButton = wait.until(ExpectedConditions.visibilityOfElementLocated(getStartedButtonLocator));
        System.out.println("Landing page is displayed");
        return getStartedButton.isDisplayed();
    }


    public boolean isLanguageSelected(String expectedText) {
        WebElement languageOptions = wait.until(ExpectedConditions.visibilityOfElementLocated(languageButtonLocator));
        languageOptions.click();
        WebElement selectedLanguage = wait.until(ExpectedConditions.visibilityOfElementLocated(selectedLanguageButtonLocator));
        selectedLanguage.click();
        WebElement selectedLanguageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(selectedLanguageElementLocator));
        String actualText = selectedLanguageTitle.getText();
        System.out.println("Selected language: " + actualText);
        return actualText.contains(expectedText);
    }


    public boolean areSwipeSlidesVisible() {
        WebElement slide = wait.until(ExpectedConditions.visibilityOfElementLocated(slideImageLocator));
        System.out.println("Slide is visible");
        return slide.isDisplayed();
    }


    public void swipeLeft() {
        int startX = 700;
        int endX = 100;
        int y = 1000;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
        System.out.println("Swiped left");
    }

    public void swipeRight() {
        int startX = 100;
        int endX = 700;
        int y = 1000;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
        System.out.println("Swiped right");
    }

    public boolean areSwipeSlidesShowingDifferentTexts() {
        WebElement firstSlideText = wait.until(ExpectedConditions.visibilityOfElementLocated(slideTextLocator));
        String text1 = firstSlideText.getText();
        System.out.println("Slide 1 Text: " + text1);


        swipeLeft();
        WebElement secondSlideText = wait.until(ExpectedConditions.visibilityOfElementLocated(slideTextLocator));
        String text2 = secondSlideText.getText();
        System.out.println("Slide 2 Text: " + text2);

        swipeRight();
        WebElement thirdSlideText = wait.until(ExpectedConditions.visibilityOfElementLocated(slideTextLocator));
        String text3 = thirdSlideText.getText();
        System.out.println("Slide 3 Text: " + text3);

        return !text1.equals(text2) && !text2.equals(text3) && !text1.equals(text3);
    }

    public void goToSignup() {
        WebElement signupButton = wait.until(ExpectedConditions.visibilityOfElementLocated(getStartedButtonLocator));
        signupButton.click();
        System.out.println("Tapped Get Started");
    }


    public void continueWithGoogle() {
        WebElement googleButton = wait.until(ExpectedConditions.visibilityOfElementLocated(signupGoogleButtonLocator));
        googleButton.click();
        System.out.println("Tapped Continue with Google");
    }


    public void continueWithApple() {
        WebElement appleButton = wait.until(ExpectedConditions.visibilityOfElementLocated(signupAppleButtonLocator));
        appleButton.click();
        System.out.println("Tapped Continue with Apple");
    }

    public void goToLogin() {
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonLocator));
        loginButton.click();
        System.out.println("Tapped Login");
    }

}
