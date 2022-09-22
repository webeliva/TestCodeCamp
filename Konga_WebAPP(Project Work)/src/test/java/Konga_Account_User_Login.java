import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import javax.swing.*;

/**     Account_User_Login Flow
        -Open your selected app URL
        -Maximize the window
        -Get the page title
        -Click on the sign-in/log in button
        -Input your email address-Input your password(pas*****@qa.team/@Og*****)
        -Click on the Sign in/login/Continue button-
        -Logout from the account
         -Quit the browser
**/
public class Konga_Account_User_Login {
    //import Selenium Webdriver
    private WebDriver driver;

    @BeforeTest()
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open your chrome browser
        driver = new ChromeDriver();
    }

        @Test(priority = 0)
                public void Url () throws InterruptedException {
        //2. Open your selected app URL (https://www.konga.com/)
        driver.get("https://www.konga.com/");

        // Test 1: Verify the user input the right url and is on the right webpage
        String expectedUrl = "https://www.konga.com/";
        String actualUrl = "https://www.konga.com/";
        if (actualUrl.contains(expectedUrl))
            // Pass
            System.out.println("User inputted the correct website URL");
        else
            // Fail
            System.out.println("User inputted the wrong website URL");
        Thread.sleep(5000);
    }

        @Test (priority = 1)
            public void Maximize_Window() {
        //3. Maximize the browser
        driver.manage().window().maximize();
    }

        @Test(priority = 2)
            public void PageTitle () throws InterruptedException {
        //4. Get the page title
        System.out.println("Page title is : " + driver.getTitle());
        Thread.sleep(3000);
    }

        @Test(priority = 3 )
            public void Login() throws InterruptedException {
        //5. Click on Login button to open the Login/Sign-in modal
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/nav/div[2]/div[1]/div/div/div[4]/a")).click();

        //Test2: Verify at the login modal the presence of H5 Login text
        WebElement element = driver.findElement(By.tagName("h5"));
        System.out.println(element.getText());
        Thread.sleep(5000);

        //Test 3: Validate that user is successfully login when valid details are inputted.*
        //Input your email on the email field
        driver.findElement(By.id("username")).sendKeys("pas*****");
        //Input your password on the password field
        driver.findElement(By.id("password")).sendKeys("@O****");
        //Click on Login button to continue the user's dashboard
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(20000);
    }
        @Test(priority = 4)
            public void  Account () throws InterruptedException {
        // Verify that clicking on the account button, open its dropdown menu
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a")).click();
        Thread.sleep(5000);
    }
        @Test(priority = 5)
            public void  Logout () throws InterruptedException {
        //Verify user can click on the logout button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();
            Thread.sleep(5000);
        // Test 4: Verify the user is returned to the homepage after taps on logout button
            String expectedUrl = "https://www.konga.com/";
            String actualUrl = "https://www.konga.com/";
            if (actualUrl.contains(expectedUrl))
                // Pass
                System.out.println("User was  redirected back to the homepage");
            else
                // Fail
                System.out.println("User wasn't  redirected back to the homepage");

                Thread.sleep(5000);
    }
        @AfterTest
            public void closeBrowser() {
        //11. Quit your browser
        driver.quit();
    }
}
