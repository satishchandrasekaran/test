package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UltimateQA {

        WebDriver driver;
        WebElement name;
        WebElement msg;
        WebElement btn;
        WebElement successMessage;
        WebDriverWait wait;
        WebElement logo;

        @Test
        public void f()  throws InterruptedException{

            logo= driver.findElement(By.id("logo"));
            Assert.assertEquals(true,logo.isDisplayed());

            name=driver.findElement(By.cssSelector(".et_pb_contact_field_0>input#et_pb_contact_name_1.input"));
            name.sendKeys("Satish");
            msg= driver.findElement(By.cssSelector(".et_pb_contact_field_1>textarea"));
            msg.sendKeys("UltimateQA message");
            btn= driver.findElement(By.cssSelector(".et_contact_bottom_container>button"));
            wait.until(ExpectedConditions.elementToBeClickable(btn));
            btn.click();
            Thread.sleep(10000);
            successMessage=driver.findElement(By.xpath("//*[text()=\"Form filled out successfully\"]"));
            String msg=successMessage.getText();
            Assert.assertEquals(msg,"Form filled out successfully");

        }
        @BeforeClass
        public void beforeClass() {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\chandrasekarans\\Desktop\\chromedriver.exe");
            driver= new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.get("https://www.ultimateqa.com/filling-out-forms/");
            wait=new WebDriverWait(driver, 30);
        }

        @AfterClass
        public void afterClass() {
           driver.close();
        }

    }
