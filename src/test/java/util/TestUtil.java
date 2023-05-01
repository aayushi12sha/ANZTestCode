package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Duration;

public class TestUtil
{

    public static String getValue(String input) throws ParseException
    {
        return input.replace("$", "").replace(",", "");
    }

    public static WebDriver setChromeDriver()
    {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        return driver;
    }

}
