import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *             1. Verify the user input the right url and his on the right webpage
 *             2. Verify that when user clicks on the signup button, the user is directed to the signup page
 *             3. Verify that user cannot signup with username less than 3 characters
 *             4. Verify user cannot signup with invalid email address
 *             5. Verify user cannot login with password less than or equal to one character*
 *             6. Verify user cannot signup with either/all of the fields blank*
 *             7. Verify that user is successfully signed up when valid details are inputted.*
 *             8. Verify that User1 item is present on the item list page.*
 *             9. Verify that the item searched for on the User1 page is present.*
 *             10. Verify that when the user logout, he/she is directed back to the home page
 **/
public class SeleniumWebSignupTest {
    //import Selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open your chrome browser
        driver = new ChromeDriver();
        //2. Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
        // Test 1: Verify the user input the right url and his on the right webpage
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //Pass
            System.out.println("User entered the correct given web address");
        else
            //Fail
        System.out.println("User entered the incorrect given web address");

        Thread.sleep(5000);
        //3. Maximize the browser
        driver.manage().window().maximize();
    }

    @Test (priority = 0)
    public void PositiveSignup() throws InterruptedException {
        //4. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        //Test2: Verify that when user clicks on the signup button, the user is directed to the signup page
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Signup Url is correct");
        else
            //Fail
            System.out.println("Signup Url is incorrect");
        Thread.sleep(5000);
    //Test 7: Verify that user is successfully signed up when valid details are inputted.*
    //5.Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("txzzz17");
    //6.Input your email on the email field
        driver.findElement(By.id("user_email")).sendKeys("zegod10@qa.team");
    //7. Input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("ki2nt@op454321");
    //8. Click on Submit button to Register
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
}

    @Test (priority = 1)
        public void ClickonUser1 () throws InterruptedException {
        // 9.Click on User1 item on the listpage
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
            Thread.sleep(5000);
    }
    @Test (priority = 2)
    public void VerifyItemlist () throws InterruptedException {
        // 10.Search for an item (LearnXpath) and confirm it is present
        // Test: 9 Verify that the item searched for on the User1 page is present
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[1]/a")).click();
        String expectedpageUrl = "https://selenium-blog.herokuapp.com/users/62";
        String actualpageUrl = driver.getCurrentUrl();
        if (actualpageUrl.contains(expectedpageUrl))
            //Pass
            System.out.println("Search Item Url is correct");
        else
            //Fail
            System.out.println("Search Item  Url is incorrect");
        Thread.sleep(5000);
    }
        @Test(priority = 3)
                public void Logout() throws InterruptedException {
        //11. Click on Logout button
        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[3]/a")).click();
        //Verify that when the user logout, he/she is directed back to the home page
            String expectedtitle = "Alphablog";
            String actualtitle = driver.getTitle();
            if (actualtitle.contains(expectedtitle))
                //Pass
                System.out.println("Homepage Title is correct");
            else
                //Fail
                System.out.println("Homepage Title is incorrect");
            Thread.sleep(5000);
    }

    @Test (priority = 4)
    public void Signup_button_0() throws InterruptedException {
        //4. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }
    @Test(priority = 5)
    public void Signup_Username_Check  () throws InterruptedException {
        //Test: 3 Verify that user cannot signup with username less than 3 characters
        //5.Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("gd");
        //6.Input your email on the email field
        driver.findElement(By.id("user_email")).sendKeys("ke7vvv@qa.team");
        //7. Input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("kent@op454321");
        //8. Click on Submit button to Register
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 6)
    public void Signup_Email_Check  () throws InterruptedException {
        //Test 4: Verify user cannot signup with invalid email address
        //5.Input your username on the username field
        driver.findElement(By.id("user_username")).clear();
        driver.findElement(By.id("user_username")).sendKeys("9ot7");
        //6.Input your email on the email field
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.id("user_email")).sendKeys("kekyoteam@-gmail.com");
        //7. Input your password on the password field
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys("kezxnt@op454321");
        //8. Click on Submit button to Register
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 7)
    public void Signup_Password_Check  () throws InterruptedException {
        // Test 5: Verify user cannot register with password less than or equal to one character*
        //5.Input your username on the username field
        driver.findElement(By.id("user_username")).clear();
        driver.findElement(By.id("user_username")).sendKeys("ot7");
        //6.Input your email on the email field
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.id("user_email")).sendKeys("kewwttyoy@qa.team");
        //7. Input your password on the password field
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys("5");
        //8. Click on Submit button to Register
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 10)
    public void Signup_BlankField_Check  () throws InterruptedException {
        //Test 6: Verify user cannot signup with either/all of the fields blank*
        //5.Input your username on the username field
        driver.findElement(By.id("user_username")).clear();
        driver.findElement(By.id("user_username")).sendKeys("o9890");
        //6.Input your email on the email field
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.id("user_email")).sendKeys("");
        // Test: 5 Verify user cannot login with password less than or equal to one character*
        //7. Input your password on the password field
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys("11272");
        //8. Click on Submit button to Register
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @AfterTest

    public void closeBrowser() {
        //11. Quit your browser
        driver.quit();
    }
}



