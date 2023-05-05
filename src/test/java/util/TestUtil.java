package util;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Duration;

public class TestUtil
{
    WebDriver driver;
    public static String getValue(String input) throws ParseException
    {
        return input.replace("$", "").replace(",", "");
    }

    public static WebDriver setChromeDriver()
    {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        option.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }



}
