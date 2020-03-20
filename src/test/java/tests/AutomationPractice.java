package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.DriverFactory;
import utilities.WaitSecond;

import java.util.List;

public class AutomationPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://automationpractice.com");
        driver.manage().window().maximize();
       driver.navigate().to("http://amazon.com");
        WaitSecond.wait(2);
        driver.navigate().back();
        WaitSecond.wait(2);
        driver.navigate().forward();
        WaitSecond.wait(2);
        driver.get("http://google.com");
        WaitSecond.wait(2);
        driver.navigate().to("http://automationpractice.com");
        WaitSecond.wait(2);
         WebElement element= driver.findElement(By.xpath("//a[contains(@title, 'Short Sleeve T-shirts')][1]"));
         element.click();
        WaitSecond.wait(2);

        driver.findElement(By.xpath("//button[contains(@class, 'exclusive')]")).click();



        WaitSecond.wait(3);
        driver.quit();
    }
}
