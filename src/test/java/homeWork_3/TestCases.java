package homeWork_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.DriverFactory;
import utilities.WaitSecond;

import java.util.Arrays;
import java.util.List;

public class TestCases {
    private RemoteWebDriver driver;
    private By registrationForm = By.linkText("Registration Form");

    @Test
    public void Test1() {
        driver.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(registrationForm));
        WaitSecond.wait(3);
        driver.findElement(registrationForm).click();
        WaitSecond.wait(3);
        driver.findElement(By.cssSelector("*[name='birthday']")).sendKeys("wrong_dob");
        WaitSecond.wait(3);
        String actual = driver.findElement(By.cssSelector("*[data-bv-validator='date']")).getText();
        String expected = "The date of birth is not valid";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void Test2() {
        driver.findElement(registrationForm).click();
        boolean element1 = driver.findElement(By.cssSelector("*[value='cplusplus']")).isDisplayed();
        boolean element2 = driver.findElement(By.cssSelector("*[value='java']")).isDisplayed();
        boolean element3 = driver.findElement(By.cssSelector("*[value='javascript']")).isDisplayed();

        Assert.assertEquals(element1, true);
        Assert.assertEquals(element2, true);
        Assert.assertEquals(element3, true);

    }

    @Test
    public void Test3() {
        driver.findElement(registrationForm).click();
        WaitSecond.wait(3);
        driver.findElement(By.cssSelector("*[name='firstname']")).sendKeys("a");
        WaitSecond.wait(3);
        String actual = driver.findElement(By.xpath("(//small[@style=''])[1]")).getText();
        String expected = "first name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void Test4() {
        driver.findElement(registrationForm).click();
        driver.findElement(By.name("lastname")).sendKeys("s");
        WaitSecond.wait(3);
        String actual = driver.findElement(By.xpath("(//small[@data-bv-for='lastname'])[2]")).getText();
        String expected = "The last name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void Test5() {

        driver.findElement(registrationForm).click();
        WaitSecond.wait(2);
        driver.findElement(By.name("firstname")).sendKeys("Sadocan");
        WaitSecond.wait(2);
        driver.executeScript("window.scrollBy(0,250)");
        driver.findElement(By.name("lastname")).sendKeys("Madocan");
        WaitSecond.wait(2);
        driver.findElement(By.name("username")).sendKeys("sado12345");
        WaitSecond.wait(2);
        driver.executeScript("window.scrollBy(0,250)");
        driver.findElement(By.name("email")).sendKeys("sadocan@email.com");
        WaitSecond.wait(2);
        driver.findElement(By.name("password")).sendKeys("sadomado12345");
        WaitSecond.wait(2);
        driver.findElement(By.name("phone")).sendKeys("571-710-7171");
        driver.executeScript("window.scrollBy(0,250)");
        WaitSecond.wait(2);
        driver.findElement(By.cssSelector("*[value='male']")).click();
        WaitSecond.wait(2);
        driver.findElement(By.name("birthday")).sendKeys("05/06/1997");
        Select selectDep = new Select(driver.findElement(By.name("department")));
        driver.executeScript("window.scrollBy(0,250)");
        selectDep.selectByVisibleText("Department of Engineering");
        WaitSecond.wait(2);
        Select selectJob = new Select(driver.findElement(By.name("job_title")));
        selectJob.selectByVisibleText("SDET");
        WaitSecond.wait(2);
        driver.findElement(By.id("inlineCheckbox2")).click();
        driver.executeScript("window.scrollBy(0,250)");
        WaitSecond.wait(3);
        driver.findElement(By.id("wooden_spoon")).click();
        WaitSecond.wait(4);
        String actual = driver.findElement(By.tagName("p")).getText();
        String expected = "You've successfully completed registration!";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void Test6() {
        driver.get("https://www.fakemail.net/");
        WaitSecond.wait(2);
        String email = driver.findElement(By.id("email")).getText();
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
        WaitSecond.wait(2);
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        WaitSecond.wait(2);
        driver.findElement(By.name("full_name")).sendKeys("Sadocan");
        driver.findElement(By.name("email")).sendKeys(email);
        WaitSecond.wait(2);
        driver.findElement(By.name("wooden_spoon")).click();
        WaitSecond.wait(3);
        String actual= driver.findElement(By.tagName("h3")).getText();
        String expected="Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(expected,actual);
        driver.navigate().to("https://www.fakemail.net/");
        WaitSecond.wait(5);
        List<WebElement> mails= driver.findElements(By.id("schranka"));
        mails.get(0).click();
        WaitSecond.wait(3);
        String actual1=driver.findElement(By.id("odesilatel")).getText();
        String expected1= "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(expected1,actual1);
        String actual2=driver.findElement(By.id("predmet")).getText();
        String expected2= "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(expected2,actual2);
    }

    @Test
    public void Test7() {
        driver.findElement(By.linkText("File Upload")).click();
        WaitSecond.wait(2);
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\user\\Desktop\\linksForTesting.txt");
        WaitSecond.wait(2);
        driver.findElement(By.id("file-submit")).click();
        WaitSecond.wait(2);
        String actual = driver.findElement(By.tagName("h3")).getText();
        String expected = "File Uploaded!";
        String fileName = driver.findElement(By.id("uploaded-files")).getText();
        System.out.println("fileName = " + fileName);
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void Test8() {
        driver.findElement(By.linkText("Autocomplete")).click();
        WaitSecond.wait(2);
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        WaitSecond.wait(2);
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
        WaitSecond.wait(2);
        String actual= driver.findElement(By.id("result")).getText();
        String expected= "You selected: United States of America";
        Assert.assertEquals(expected,actual);
    }
    @DataProvider(name="testData")
    public static Object [] testData(){

        return new Object [] {"200","301","404","500"};
    }


    @Test(dataProvider = "testData")
    public void TestRemaining(String num){
        driver.findElement(By.linkText("Status Codes")).click();
        WaitSecond.wait(2);
        driver.findElement(By.linkText(num)).click();
        WaitSecond.wait(2);
        String expected="This page returned a "+num+" status code";
        String actual=driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(actual.contains(expected),true);
    }


    @BeforeMethod
    public void setup() {
        driver = (RemoteWebDriver) DriverFactory.createDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.manage().window().maximize();
        WaitSecond.wait(2);

    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
