package WebFirst;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class WebFistHomework1
{

    static protected WebDriver driver;

    public  void waitforClickable(By by, int time)
        {
            WebDriverWait wait = new WebDriverWait(driver,time);
            wait.until(ExpectedConditions.elementToBeClickable(by));
        }

    public  void waitforDisaplay(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public  void waitforDisaapear(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    @Test
    public void userShouldBeLoginSccessfully()
    {
        // opening the browser
        System.setProperty("webdriver.chrome.driver","src\\test\\java\\BrowserDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // opening url
        driver.get("http://thedemosite.co.uk/");

        // clicking on add user
        driver.findElement(By.linkText("3. Add a User")).click();

        //type username
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("rajpatel1");

        //type password
        driver.findElement(By.name("password")).sendKeys("Test1234");

        //click on save
        driver.findElement(By.name("FormsButton2")).click();

        //click on login
        driver.findElement(By.linkText("4. Login")).click();

        //type username
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("rajpatel1");

        //type password
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Test1234");

        //click on login
        driver.findElement(By.name("FormsButton2")).click();

        //closing browser
        driver.quit();

    }





    @Test
    public void userShouldBeLoginPanelSuccessfully()
    {
        // opening the browser
        System.setProperty("webdriver.chrome.driver","src\\test\\java\\BrowserDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // opening url
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //type username
        driver.findElement(By.xpath("//input[@ name=\"txtUsername\"]")).sendKeys("admin");


        //type password
        driver.findElement(By.xpath("//input[@name=\"txtPassword\"]")).sendKeys("admin123");

        //click on login
        driver.findElement(By.id("btnLogin")).click();
        System.out.println("login clicked");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //closing browser
        driver.quit();



    }

    @Test
    public void userShouldCreateAnAccountSuccessfully()
    {
        // opening the browser
        System.setProperty("webdriver.chrome.driver","src\\test\\java\\BrowserDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // opening url
        driver.get("http://automationpractice.com/");

        //click on login
        driver.findElement(By.xpath("//a[@class=\"login\"]")).click();

        //type email address
        driver.findElement(By.xpath("//input[@id=\"email_create\" and @name=\"email_create\"]")).sendKeys("set@test");
       // driver.findElement(By.xpath("//input[@name=\"email_create\"]")).sendKeys("john@test.com");

        //////////////////////////////////////////////////////////////////////////////////////////////////
        //closing browser
        driver.quit();
    }

    @Test
    public void userShouldBeSignInSuccessfully()
    {
        // opening the browser
        System.setProperty("webdriver.chrome.driver","src\\test\\java\\BrowserDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // opening url
        driver.get("https://www2.hm.com/en_gb/index.html");

        //clicking on ladies
        driver.findElement(By.linkText("Ladies")).click();

        //clicking on cloth
        driver.findElement(By.xpath("//li[1]/ul/li[1]/a")).click();

        //click on sign
        driver.findElement(By.xpath("//a[@data-remodal-trigger=\"signin\" and @class=\"menu__myhm\"]")).click();

        //type email address
        driver.findElement(By.name("j_username")).sendKeys("fhgfydsfd@mail.com");

        //type password
        driver.findElement(By.name("j_password")).sendKeys("12345");

        //click on sign in
        driver.findElement(By.xpath("//button[contains(@class,\"btn-login\")]")).click();

        //closing browser
        driver.quit();


    }

    @Test
    public void userShouldBeRegisterSuccessfully()
    {
        // opening the browser
        System.setProperty("webdriver.chrome.driver","src\\test\\java\\BrowserDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        driver=new ChromeDriver(options);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // opening url
        driver.get("http://way2automation.com/way2auto_jquery/index.php");

        //type name
        driver.findElement(By.xpath("//input[@name=\"name\"]")).sendKeys("ramesh");

        //type phone
        driver.findElement(By.name("phone")).sendKeys("09898989898");

        //type email
        driver.findElement(By.name("email")).sendKeys("s43535345dfdser@test.com");

        //type city
        driver.findElement(By.name("city")).sendKeys("Gujarat");

      //  WebDriverWait wait = new WebDriverWait(driver,5);
        //*[@id="load_form"]/fieldset[6]/input

        //type  username
        driver.findElement(By.xpath("//fieldset[6]/input")).sendKeys("fdsfds");

        //type password
        driver.findElement(By.xpath("//fieldset[7]/input")).sendKeys("098765dfgffdsfdsdgfdfg4");

        //click on submit
        driver.findElement(By.xpath("//form[@class=\"ajaxsubmit\"]/div/div[2]/input")).click();

        // closing browser
        driver.quit();

    }

}
