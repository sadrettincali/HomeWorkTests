package homeWork_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.DriverFactory;
import utilities.WaitSecond;

public class TestCases {
    private WebDriver driver;
    private By registrationForm = By.linkText("Registration Form");

    @Test
    public void Test1() {
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
        driver.findElement(By.name("lastname")).sendKeys("Madocan");
        WaitSecond.wait(2);
        driver.findElement(By.name("username")).sendKeys("sado12345");
        WaitSecond.wait(2);
        driver.findElement(By.name("email")).sendKeys("sadocan@email.com");
        WaitSecond.wait(2);
        driver.findElement(By.name("password")).sendKeys("sadomado12345");
        WaitSecond.wait(2);
        driver.findElement(By.name("phone")).sendKeys("571-710-7171");
        WaitSecond.wait(2);
        driver.findElement(By.cssSelector("*[value='male']")).click();
        WaitSecond.wait(2);
        driver.findElement(By.name("birthday")).sendKeys("05/06/1997");
        Select selectDep = new Select(driver.findElement(By.name("department")));
        selectDep.selectByVisibleText("Department of Engineering");
        WaitSecond.wait(2);
        Select selectJob=new Select(driver.findElement(By.name("job_title")));
        selectJob.selectByVisibleText("SDET");
        WaitSecond.wait(2);
        driver.findElement(By.id("inlineCheckbox2")).click();
        WaitSecond.wait(3);
        driver.findElement(By.id("wooden_spoon")).click();
        WaitSecond.wait(4);
        String actual= driver.findElement(By.tagName("p")).getText();
        String expected="You've successfully completed registration!";
        Assert.assertEquals(expected,actual);
    }

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.manage().window().maximize();
        WaitSecond.wait(3);


    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
