package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.DriverFactory;
import utilities.WaitSecond;

import java.util.List;

public class EtsyAutomation {
    public static void main(String[] args) {


        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://etsy.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[starts-with(@class,'wt-btn wt-btn--s')]"));
        WaitSecond.wait(2);
        driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']")).sendKeys("bag", Keys.ENTER);
        driver.findElement(By.xpath("//img[@src='https://i.etsystatic.com/17203538/d/il/12a152/1440273622/il_340x270.1440273622_qbba.jpg?version=0']")).click();
            WaitSecond.wait(2);
        driver.navigate().to("https://www.etsy.com/listing/597174565/bag-of-dicks-send-anonymously?ga_order=most_relevant&ga_search_type=all&ga_view_type=gallery&ga_search_query=bag&ref=sr_gallery-1-1&organic_search_click=1&pro=1&frs=1");
            Select select1=new Select(driver.findElement(By.xpath("//select[@id='inventory-variation-select-0']")));
            select1.selectByValue("966957807");
           // driver.findElement(By.xpath("//option[@value='966957805']")).click();
//        driver.findElement(By.xpath("//img[@src='https://i.etsystatic.com/6906788/c/1951/1550/0/158/il/b072b1/2207271185/il_340x270.2207271185_4erq.jpg']"));
//
//        WaitSecond.wait(3);
//        driver.quit();
   }
}
