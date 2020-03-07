package tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.DriverFactory;

import java.util.List;

public class MyFirstProject {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://amazon.com");
        System.out.println(driver.getTitle());
        driver.navigate().to("http:google.com");
        System.out.println(driver.getTitle());
        driver.navigate().back();
        driver.findElement(By.linkText("Customer Service")).click();
        driver.findElement(By.linkText(" Change Your Payment Method ")).click();
        driver.quit();

    }
}
