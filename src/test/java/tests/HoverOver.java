package tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.WaitSecond;

public class HoverOver {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        driver.manage().window().maximize();
        WaitSecond.wait(2);
        Actions actions= new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("ui-id-3"))).perform();
        WaitSecond.wait(2);
        actions.moveToElement(driver.findElement(By.id("ui-id-4"))).perform();
        WaitSecond.wait(2);
        driver.findElement(By.id("ui-id-7")).click();


        WaitSecond.wait(3);
        driver.quit();
    }



}
