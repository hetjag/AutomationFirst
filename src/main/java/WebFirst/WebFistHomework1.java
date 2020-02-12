package WebFirst;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WebFistHomework1 {

    static protected WebDriver driver;
    //Wait for clickable method
    public void waitForClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //Wait for visibility method
    public void waitForVisibility(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //wait for element present
    public void waitForElementsPresent(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    //Wait for disaply method
    public void waitforDisaplay(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    //Wait for disaapear method
    public void waitforDisaapear(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    //generate time stamp in string
    public String timeStamp() {
        DateFormat dateFormat = new SimpleDateFormat("ddyyhhmmss");
        Date date = new Date();
        return dateFormat.format(date);

    }


    //get text from element
    public String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }

    //click on element
    public void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }

    public void EnterText(By by, String text) {
        driver.findElement(by).sendKeys(text);

    }

    // select by visible text
    public void selectByVisibleText(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    //
    public void selectByIndex(By by, int number) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(number);
    }

    public void selectByValue(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(text);
    }



    // opening the browser
    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    //closing browser
    @After
    public void closeBrowser() {
        driver.quit();
    }


    @Test
    public void userShouldBeLoginSccessfully() {
       String expect ="**Successful Login**";
        // opening url
        driver.get("http://thedemosite.co.uk/");

        // clicking on add user
        clickOnElement(By.linkText("3. Add a User"));

        //type username

        String name = getTextFromElement(By.xpath("//input[@name=\"username\"]"));
        EnterText(By.xpath("//input[@name=\"username\"]"), "rajpatel");


        //type password
        EnterText(By.name("password"), "Test1234");


        //click on save
        clickOnElement(By.name("FormsButton2"));

      //  driver.findElement(By.id("ggfdhgfd")).getText();

        //click on login
        clickOnElement(By.linkText("4. Login"));


        //type username
        EnterText(By.xpath("//input[@name=\"username\"]"), "rajpatel");


        //type password
        EnterText(By.xpath("//input[@name=\"password\"]"), "Test1234");

        //click on login
        clickOnElement(By.name("FormsButton2"));

        String actual = getTextFromElement(By.xpath("//center/b"));
       Assert.assertEquals("Successful Login",expect,actual);


    }


    @Test
    public void userShouldBeLoginPanelSuccessfully() {
        String expected = "Welcome Admin";

        // opening url
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //type username
        EnterText(By.xpath("//input[@ name=\"txtUsername\"]"),"admin");

        //type password
        EnterText(By.xpath("//input[@name=\"txtPassword\"]"),"admin123");

        //click on login
        clickOnElement(By.id("btnLogin"));
        System.out.println("login clicked");
        String actual = getTextFromElement(By.xpath("//a[@class='panelTrigger']"));


        Assert.assertEquals("User is not able to login",expected,actual);

    }



    @Test
    public void userShouldBeSignInSuccessfully() {

        String expectectErrorMessage = "Wrong email or password, please try again.";
        // opening url
        driver.get("https://www2.hm.com/en_gb/index.html");

        //clicking on ladies
        clickOnElement(By.linkText("Ladies"));

        //clicking on cloth
        clickOnElement(By.xpath("//li[1]/ul/li[1]/a"));


        //click on sign
        clickOnElement(By.xpath("//a[@data-remodal-trigger=\"signin\" and @class=\"menu__myhm\"]"));


        //type email address
        EnterText(By.name("j_username"),"set+"+timeStamp()+"@netgmail.com");

        //type password
        EnterText(By.name("j_password"),"12345");


        //click on sign in
        clickOnElement(By.xpath("//button[contains(@class,\"btn-login\")]"));

        String actualErrorMessage = getTextFromElement(By.xpath("//span[@id=\"modal-txt-signin-password-unknown-error-type-error\"]"));

        //verifying error message display
        Assert.assertEquals("Un-registered user is able to login",expectectErrorMessage,actualErrorMessage);

    }



    @Test
    public void userShouldBeRegisterSuccessfully()
    {
        String expectedMsg ="Registering is quick and easy";
        // opening url
        driver.get("https://www.asda.com/register");

        //type email
        EnterText(By.xpath("//input[@type='email']"),"abcdefg12"+timeStamp()+"@gmail.com");

        //type password
        EnterText(By.xpath("//input[@type=\"password\"]"),"ab123456=");

        //enter postcode
        EnterText(By.xpath("//input[@type=\"text\"]"),"ha0 2hn");

          //click on box
        clickOnElement(By.xpath("//label[1]/span[@class='checkmark']"));

        //click on register
        clickOnElement(By.xpath("//button[@type='submit']"));
        String registerSuccessMesageActiual = getTextFromElement(By.xpath("//div/h1"));

        //verifying register success message dislapying
        Assert.assertTrue("Registration to asda is failed",registerSuccessMesageActiual.contains(expectedMsg));

    }
}
