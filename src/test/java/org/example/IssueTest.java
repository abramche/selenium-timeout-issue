package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IssueTest {

    private static final By GITHUB_OAUTH_BUTTON = By.xpath("//a[contains(@href, \"github.com\")]");

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.setPageLoadTimeout(Duration.ofSeconds(5));
        options.setScriptTimeout(Duration.ofSeconds(5));
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://viridian.hazelcast.com/sign-in?next=/");
//        Thread.sleep(2000);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(GITHUB_OAUTH_BUTTON));
        driver.findElement(GITHUB_OAUTH_BUTTON).click();
        driver.quit();
    }
}
