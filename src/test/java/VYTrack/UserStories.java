package VYTrack;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.DriverFactory;
import utilities.WaitSecond;

public class UserStories {
    RemoteWebDriver driver= (RemoteWebDriver) DriverFactory.createDriver("chrome");



    @Test
    public void LoginTest() {
    driver.findElement(By.id("prependedInput")).sendKeys("salesmanager132");
    driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
    driver.findElement(By.id("_submit")).submit();
    WaitSecond.wait(4);
        Actions actions= new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"))).perform();
        WaitSecond.wait(4);
        driver.findElement(By.linkText("Vehicle Contracts")).click();
    }



    @BeforeMethod
    public void setup() {
        driver.get("https://qa2.vytrack.com");
        driver.manage().window().maximize();
        WaitSecond.wait(2);
    }

    @AfterMethod
    public void closed() {
        WaitSecond.wait(2);
        driver.quit();
    }
}

