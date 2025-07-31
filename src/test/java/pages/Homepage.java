package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homepage {
    private final AndroidDriver driver;
    private final WebDriverWait wait;
    String expectedName= "";
    public Homepage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private final By nameCard = By.xpath("");
    public boolean isHomePageIsOpened(){
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(nameCard));
        String actualName = title.getText();
        return actualName.contains(expectedName);
    }
}
