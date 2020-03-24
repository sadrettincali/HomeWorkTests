package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.DriverFactory;
import utilities.WaitSecond;

import java.util.List;

public class Herokuapp {
    RemoteWebDriver driver= (RemoteWebDriver) DriverFactory.createDriver("chrome");



    @Test(description = "basic test automation")
    public void Test1(){
        List<WebElement> links=driver.findElements(By.tagName("li"));
        driver.executeScript("arguments[0].scrollIntoView(true)",links.get(14));
        WaitSecond.wait(3);
        int count=1;
        for (WebElement each : links){
            System.out.println(count+ each.getText());
            count++;
        }

    }

    @BeforeMethod
    public void setup() {
        driver.get("https://formy-project.herokuapp.com/");
        driver.manage().window().maximize();
        WaitSecond.wait(3);
    }

    @AfterMethod
    public void closed() {
        WaitSecond.wait(3);
        driver.quit();
    }
}
