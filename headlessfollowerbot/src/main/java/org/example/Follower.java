package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Follower {
    private WebDriver driver;
    private WebDriverWait wait;

    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome Webdriver\\chromedriver.exe");

        // Set ChromeOptions for headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");  // Enables headless mode
        options.addArguments("--disable-gpu"); // Disables GPU hardware acceleration
        options.addArguments("--window-size=1920,1080"); // Sets window size for the headless browser
        options.addArguments("--disable-extensions"); // Disables extensions
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--disable-dev-shm-usage"); // Overcome resource issues

        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 2: Open the signup page
        driver.get("https://dev.mavenx.gg/");

        // Wait for and click the "Ok Got It" button
        clickWhenClickable(By.xpath("//*[contains(text(),'Ok Got It')]"));
        clickWhenClickable(By.xpath("//button[@type='button' and @class='btn-primary bg-primary hover:bg-primary border-0 hover:border-0 disabled:bg-primary-content/20 cursor-pointer disabled:cursor-not-allowed disabled:text-primary-focus/80 btn normal-case px-2 text-[13px] true  btn-sm min-w-[80px] h-[37px]  font-normal text-[13px] rounded-[12px] text-primary-focus']"));

        // Step 3: Generate YOPmail email address (random)
        String randomEmail = "randompms" + System.currentTimeMillis() + "@yopmail.com";
        String uniqueUsername = "testuser" + System.currentTimeMillis();

        // Step 4: Fill the signup form
        WebElement nameField = driver.findElement(By.xpath("//input[@name='firstName']"));
        nameField.sendKeys("Test");

        WebElement lastNameField = driver.findElement(By.xpath("//input[@name='lastName']"));
        lastNameField.sendKeys("User");

        WebElement usernameField = driver.findElement(By.xpath("//input[@name='userName']"));
        usernameField.sendKeys(uniqueUsername);

        WebElement emailField = driver.findElement(By.xpath("//input[@name='email']"));
        emailField.sendKeys(randomEmail);

        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        passwordField.sendKeys("ABc@3456");

        driver.findElement(By.xpath("//*[contains(text(),'Month')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'March')]")).click();

        driver.findElement(By.xpath("//label[contains(text(),'Day')]")).click();
        driver.findElement(By.xpath("//div[@class='cursor-pointer py-2 px-3 last:border-b-0 w-full hover:bg-accent bg-none' and text()='3']")).click();

        driver.findElement(By.xpath("//label[contains(text(),'Year')]")).click();
        driver.findElement(By.xpath("//div[@class='cursor-pointer py-2 px-3 last:border-b-0 w-full hover:bg-accent bg-none' and text()='2011']")).click();

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        clickWhenClickable(By.xpath("//span[@class='font-[inherit] text-inherit ' and text()='Skip']"));
        clickWhenClickable(By.xpath("//button[@type='button' and @class='btn-primary bg-primary hover:bg-primary border-0 hover:border-0 disabled:bg-primary-content/20 cursor-pointer disabled:cursor-not-allowed disabled:text-primary-focus/80 btn normal-case px-2 text-[13px] true  btn-sm min-w-[80px] h-[37px]  mt-6']"));
        clickWhenClickable(By.xpath("//*[@alt='avatar2']"));

        // Scroll to and click the "Continue" button
        WebElement continueButton = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
        scrollToElement(continueButton);
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();

        clickWhenClickable(By.xpath("//span[@class='channel-name text-primary-content font-cnb text-[12px]' and text()='teky2']"));
        clickWhenClickable(By.xpath("//*[@alt=' Overdrive']"));
        WebElement doneButton = driver.findElement(By.xpath("//button[@type='button' and @class='btn-primary bg-primary hover:bg-primary border-0 hover:border-0 disabled:bg-primary-content/20 cursor-pointer disabled:cursor-not-allowed disabled:text-primary-focus/80 btn normal-case px-2 text-[13px] true  btn-sm min-w-[80px] h-[37px]  ']"));
        doneButton.click();

        driver.navigate().refresh();
        driver.quit();
    }

    private void clickWhenClickable(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    private void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
