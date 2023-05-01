package AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class AbstractComponents {

        WebDriver driver;
        WebDriverWait wait;

        public AbstractComponents(WebDriver driver) {
            this.driver= driver;

        }

        public void setExplicitWait(int seconds){
            wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        }
        public void visibilityOfElementLocated(By findBy) {
            setExplicitWait(100);
            wait.until(ExpectedConditions.elementToBeClickable(findBy)).click();
        }

    }


