package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class SignupTest {
    private OnboardPage onboardPage;
    private SignupPage signupPage;
    private CallSignPage callSignPage;
    private PhraseologyPage phraseologyPage;
    private CoursesPage coursesPage;
    private Homepage homepage;

    @Test
    public void signupFlow (){

        Assert.assertTrue(onboardPage.isLogoVisible(),"logo is not displayed");
        Assert.assertTrue(onboardPage.isLandingPageVisible(),"Landing Page is not displayed");
        Assert.assertTrue(onboardPage.areSwipeSlidesShowingDifferentTexts(),"Swipe is not working");



    }



}
