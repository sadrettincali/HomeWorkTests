package homeWork_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.DriverFactory;
import utilities.WaitSecond;

import java.util.*;

public class TestCases {
    WebDriver driver = DriverFactory.createDriver("chrome");

    @Test(description = "Select randomly dates")
    public void Test1() {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        WaitSecond.wait(2);
        Random r = new Random();

        List<WebElement> labels = driver.findElements(By.tagName("label"));
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        int fridayCount = 0;

        do {
            int index = r.nextInt(7);
            if (checkboxes.get(index).isEnabled()) {
                labels.get(index).click();
                System.out.println(labels.get(index).getText());
                labels.get(index).click();
                if (labels.get(index).getText().equals("Friday")) {
                    fridayCount++;
                }
            }
        } while (fridayCount != 3);

    }


    @Test(description = "verify that dropdowns under Select your date of birth display current year, month,day")
    public void Test2() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        WaitSecond.wait(2);

        Select select1=new Select(driver.findElement(By.id("year")));
        Select select2=new Select(driver.findElement(By.id("month")));
        Select select3=new Select(driver.findElement(By.id("day")));

        String year =select1.getFirstSelectedOption().getText();
        String month =select2.getFirstSelectedOption().getText();
        String day =select3.getFirstSelectedOption().getText();


        System.out.println("" + day + month + year);
        Assert.assertEquals(year, "2020");
        Assert.assertEquals(day, "27");
        Assert.assertEquals(month, "March");
    }


    @Test(description = "verify that options in the All departmentsdropdownare not sorted alphabetically")
    public void Test3() {
        driver.get("https://www.amazon.com");
        WaitSecond.wait(2);
        driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']")).click();
        WaitSecond.wait(2);
        List<WebElement> links = driver.findElements(By.xpath("//*[@id=\"hmenu-content\"]/ul[33]/li "));
        System.out.println("links = " + links);
        List<String> sLists = new ArrayList<>();
        List<String> sLists2 = new ArrayList<>();
        for (WebElement each : links) {
            sLists.add(each.getText());
            sLists2.add(each.getText());
        }
        Collections.sort(sLists);
        String result = "true";
        if (sLists.equals(sLists2)) {
            result = "false";
        }
        Assert.assertEquals("true", result);

    }

    @Test
    public void Test4() {
        driver.get("https://www.amazon.com/gp/site-directory");
        BrowserUtils.wait(3);
        List<WebElement> mainPage = driver.findElements(By.tagName("h2"));


        driver.findElement(By.id("searchDropdownBox")).click();
        List<WebElement> options = driver.findElements(By.tagName("option"));
        int l1 = mainPage.size();
        int l2 = options.size();

        Assert.assertEquals(l1 == l2, false);

    }

    @Test
    public void Test5() {
        driver.get("https://www.w3schools.com/");
        BrowserUtils.wait(3);
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        for (int i = 12; i < allLinks.size(); i++) {
            if (allLinks.get(i).isDisplayed() && !(allLinks.get(i).getText().isEmpty())) {
                System.out.println(allLinks.get(i).getText());
                System.out.println(allLinks.get(i).getAttribute("href"));
            }

        }
    }

    @Test
    public void Test6() {
        driver.get("https://www.selenium.dev/documentation/en/");
        BrowserUtils.wait(3);
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        String title = driver.getTitle();
        boolean result = true;
        for (WebElement each : allLinks) {
            each.click();
            BrowserUtils.wait(2);
            if (driver.getTitle().equals(title)) {
                result = false;
                break;
            }
        }

    }

    @Test
    public void Test7() {
        driver.get("https://amazon.com");
        WaitSecond.wait(2);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
        driver.findElement(By.xpath("(//input[@class='nav-input'])[1]")).click();
        WaitSecond.wait(5);
        List<WebElement> spoons= driver.findElements(By.cssSelector("div[class='a-section aok-relative s-image-square-aspect']"));
        Random r= new Random();
        WebElement element=spoons.get(r.nextInt(spoons.size()));
        element.click();
        String cnnt=driver.findElement(By.xpath("(//span[@class='a-dropdown-prompt'])[1]")).getText();
        Assert.assertEquals(cnnt.contains("1"), true);
        Assert.assertEquals(driver.findElement(By.id("add-to-cart-button")).isEnabled(),true);

    }
    /*
    4.remember name first result that has prime label
    5.select Prime check box on the left
    6.verify that name first result that has prime label is same as step 4
    7.check the last check box under Brand on the left
    8.verify that name first result that has prime label is different
     */
    @Test
    public void Test8(){
        driver.get("https://amazon.com");
        WaitSecond.wait(2);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
        driver.findElement(By.xpath("(//input[@class='nav-input'])[1]")).click();
        WaitSecond.wait(5);
        driver.findElement(By.xpath("(//span[@class='sb_3XafbQtX sb_25yic0YU sb_CyFsQ0hU'])[1]")).click();
        WaitSecond.wait(3);

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
