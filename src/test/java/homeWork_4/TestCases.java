package homeWork_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.DriverFactory;
import utilities.WaitSecond;

import java.util.*;

public class TestCases {
    WebDriver driver = DriverFactory.createDriver("chrome");

    @Test(description = "verify that options in the All departmentsdropdownare not sorted alphabetically")
    public void Test3(){
        driver.get("https://www.amazon.com");
        WaitSecond.wait(2);
        driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']")).click();
        WaitSecond.wait(2);
        List<WebElement> links= driver.findElements(By.xpath("//*[@id=\"hmenu-content\"]/ul[33]/li "));
        System.out.println("links = " + links);
        List <String> sLists= new ArrayList<>();
        List <String> sLists2= new ArrayList<>();
        for (WebElement each : links){
            sLists.add(each.getText());
            sLists2.add(each.getText());
        }
        Collections.sort(sLists);
        String result= "true";
        if (sLists.equals(sLists2)){
            result="false";
        }
        System.out.println("sLists = " + sLists);
        System.out.println("sLists2 = " + sLists2);
        System.out.println("result = " + result);
        Assert.assertEquals("true", result);

    }







    @Test(description = "verify that dropdowns under Select your date of birth display current year, month,day")
    public void Test2() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        WaitSecond.wait(2);
        String year = driver.findElement(By.id("year")).getText();
        String month = driver.findElement(By.id("month")).getText();
        String day = driver.findElement(By.id("day")).getText();

        System.out.println(""+year+month+day);
        Assert.assertEquals(year, "2020");
        Assert.assertEquals(day, "24");
        Assert.assertEquals(month, "March");
    }


    @Test(description = "Select randomly dates")
    public void Test1() {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        WaitSecond.wait(2);
        List<WebElement> checkboxes = driver.findElements(By.tagName("span"));
        int count = 0;
        while (count < 3) {
            for (WebElement each : checkboxes) {
                if (each.isDisplayed()) {
                    each.click();
                    WaitSecond.wait(2);
                    System.out.println(each.getText());
                    each.click();
                    WaitSecond.wait(2);
                }
            }
            count++;
        }
    }


    @BeforeMethod
    public void setup() {
        driver.manage().window().maximize();
        WaitSecond.wait(2);
    }

    @AfterMethod
    public void closed() {
        WaitSecond.wait(2);
        driver.quit();
    }

}
