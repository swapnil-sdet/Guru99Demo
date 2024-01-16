package guru99Day2;

/* @Swapnil Padekar
Time to create a more professional Script
1) All parameters will be saved in File Util.java - Helps in easy code maintenance
2) We will move the code to launch Webdriver in a separate method as SetUp. Helps in code understanding
*/


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class TestScriptDay2 {

    static WebDriver driver; // Selenium control driver
    private static String baseUrl; // baseUrl of Website Guru99

    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", Util.CHROME_PATH);

        driver = new ChromeDriver();

        // Maximize the browser
        driver.manage().window().maximize();

        // Setting Base URL of website Guru99
        baseUrl = Util.BASE_URL;

        // Specifies the amount of time the driver should wait when searching for an element if it is not immediately present.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Go to http://www.demo.guru99.com/V4/
        driver.get(baseUrl + "/V4/");

    }

    public static void main(String args[]) throws Exception {

        //Setup Chrome driver
        setUp();

        WebElement tfuserid = driver.findElement(By.xpath("//input[@name='uid']"));
        tfuserid.clear(); // Good practice to clear a field before use
        tfuserid.sendKeys(Util.USER_NAME);  // Enter username

        WebElement tfpassword = driver.findElement(By.xpath("//input[@name='password']"));
        tfpassword.clear(); // Good practice to clear a field before use
        tfpassword.sendKeys(Util.PASSWD);  // Enter Password

        // Click Login
        WebElement btnLogin = driver.findElement(By.xpath("//input[@name='btnLogin']"));
        btnLogin.click();

        String actualTitle = driver.getTitle();

        //Compare & Validate HomePageTitle - Actual vs expected
        if (actualTitle.equals(Util.EXPECTED_TITLE)) {
            System.out.println("Test case: Passed");
        }
        else {
            System.out.println("Test case : Failed");
        }

        driver.quit(); // Close all the instances of the browser
    }
}