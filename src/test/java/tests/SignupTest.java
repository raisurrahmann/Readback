package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class SignupTest extends BaseTest {

    @Test
    public void signupFlow() {
        OnboardPage onboardPage = new OnboardPage(driver);

        Assert.assertTrue(onboardPage.isLogoVisible(), "Logo is not displayed");
        Assert.assertTrue(onboardPage.isLandingPageVisible(), "Landing Page is not displayed");
        Assert.assertTrue(onboardPage.areSwipeSlidesVisible(), "Slides are not visible");
        Assert.assertTrue(onboardPage.areSwipeSlidesShowingDifferentTexts(), "Swipe texts are not changing");

        onboardPage.goToSignup();
        SignupPage signupPage = new SignupPage(driver);

        String email = "raisur.dinnova+" + System.currentTimeMillis() + "@gmail.com";
        signupPage.enterEmail(email);
        signupPage.enterPassword("Qw!12345");
        signupPage.confirmPassword("Qw!12345");
        signupPage.acceptTerms();

        Assert.assertTrue(signupPage.isSignupButtonClickable(), "Signup button should be enabled");
        signupPage.tapSignupButton();

        CallSignPage callSignPage = new CallSignPage(driver);
        callSignPage.enterCallSign("raisur"+ Math.random());
        callSignPage.tapContinue();

        PhraseologyPage phraseologyPage = new PhraseologyPage(driver);
        phraseologyPage.selectPhraseologyOption();
        phraseologyPage.tapContinue();

        CoursesPage coursesPage = new CoursesPage(driver);
        coursesPage.selectCountry();
        coursesPage.selectClass();
        coursesPage.tapContinue();

        Homepage homepage = new Homepage(driver);
        Assert.assertTrue(homepage.isHomePageIsOpened(), "Home page is not opened as expected");
    }
}