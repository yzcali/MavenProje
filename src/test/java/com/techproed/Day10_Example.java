package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/*
titleTest => Sayfa başlığının "Best" içerdiğini(contains) doğrulayın
logoTest => BestBuy logosunun görüntülenip görüntülenmediğini doğrulayın
mexicoLinkTest => Linkin görüntülenip görüntülenmediğini doğrulayın
 */

public class Day10_Example {

    static WebDriver driver;


     @Before
     public void beforeMethod(){
         WebDriverManager.chromedriver().setup();

         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.get("http://BestBuy.com");
     }
     @Test
     public void titleTest(){
        String sayfaBasligi= driver.getTitle();
        boolean bestkelimesiniiceriyorMu=sayfaBasligi.contains("Best");
                Assert.assertTrue(bestkelimesiniiceriyorMu);
     }

    @Test
    public void test2() {


        WebElement logo1 = driver.findElement(By.xpath("//img[@class='logo']"));
        boolean seenOrNot = logo1.isDisplayed();
        Assert.assertTrue(seenOrNot);
    }

        @Test
                public void test3(){

            WebElement logo2 = driver.findElement(By.linkText("Mexico" ));
            boolean seenOrNot = logo2.isDisplayed();
            Assert.assertTrue(seenOrNot);

        }


    @After
    public  void afterMethod() {
      driver.quit();
    }
}