import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebSignupTest {
    //import Selenium WebDriver
    private WebDriver driver;

    public SeleniumWebSignupTest(WebDriver driver) {
        this.driver = driver;}
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open your chrome browser
        driver = new ChromeDriver();
        //2. Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
        Thread.sleep(10000);
        //3. Maximize the browser
        driver.manage().window().maximize();
        //4. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        //5.Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("ogaken");
        //6.Input your username on the email field
        driver.findElement(By.id("user_email")).sendKeys("kentop@qa.team");
        //7. Input your username on the password field
        driver.findElement(By.id("user_password")).sendKeys("kentop54321");
        //8. Click on Submit button to Register
        driver.findElement(By.id("submit")).click();
        Thread.sleep(10000);

        // 9.Click on User1 item on the listpage
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        // 10.Search for an item (Learn Xpath) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        //11. Click on Logout button
        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[3]/a")).click();

    }
}

