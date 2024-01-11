package demoGuru99;

/*
@Author: Swapnil Padekar

Test Steps -
1. Go to URL: http://www.demo.guru99.com/V4/
2. Enter valid UserId: mngr546349
3. Enter valid Password: "uruhubu"
4. Click Login Button.
5. Get the home page-title after login
6. Get the home page URL after login
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginTestSite {

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Automation\\WorkSpaces\\BrowserDrivers\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //Navigate to the URL
        String baseURL = "https://www.demo.guru99.com/V4/";
        String userid = "mngr546349";
        String password = "uruhubu";

        driver.get(baseURL);

        WebElement tfuserid = driver.findElement(By.xpath("//input[@name='uid']"));
        WebElement tfpassword = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement btnLogin = driver.findElement(By.xpath("//input[@name='btnLogin']"));
        WebElement btnReset = driver.findElement(By.xpath("//input[@name='btnReset']"));

        tfuserid.sendKeys(userid);
        tfpassword.sendKeys(password);
        btnLogin.click();

        // Check the title of the page
        System.out.println("Title of the home-page after login: " + driver.getTitle());

        // Check if we redirected on the current URL
        System.out.println("URL of the home-page after login:" + driver.getCurrentUrl());

        Thread.sleep(2000);

        WebElement lnkLogout = driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
        lnkLogout.click();
        // Thread.sleep(2000);

        // Close all running instance of the browser (via automation script)
        driver.quit();
    }
}