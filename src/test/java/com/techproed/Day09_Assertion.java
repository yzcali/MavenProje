package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day09_Assertion {

    private static  WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        driver.get("http://google.com");

        //Test Case: Google.com un basligi "Google Arama Sayfasi" olsun.
        String title= driver.getTitle();
       // Google in title i "Google Arama Sayfasi" na esit mi degil mi?

        Assert.assertEquals("Google Arama Sayfasi",title);

      // sonuc failed cunku "Google != Google Arama Sayfasi"


    }
    @Test
    public void test2(){
        driver.get("http://amazon.com");
        // Amazon.com un basligi Amazon u iceriyor mu

        String title= driver.getTitle();

        boolean iceriyorMu=title.contains("Amazon");
        // boolean veri tipinde deger giriyoruz false ya da true seklinde
        Assert.assertTrue(iceriyorMu);

    }
    @Test
    public void test3(){
        driver.get("http://facebook.com");
        String title= driver.getTitle();

       // Facebook un title i Youtube kelimesini icermesin.

        boolean iceriyorMu=title.contains("Youtube");
        Assert.assertFalse(iceriyorMu); // false oldugunu dogrula
    }
    @Test
    public void test4(){
        driver.get("http://google.com");


        String title= driver.getTitle();

        System.out.println("Merhabalar");

        Assert.assertEquals("Google Arama Sayfasi",title);
        // test basarisiz oldugu icin alt satir calismaz , consoul da test dogrulama islemi bitti! yazmaz.
        System.out.println("test dogrulama islemi bitti!");

       // bu test failed olsada asagidaki testler calismaya devam eder .
    }
    @Test
    public void test5(){
        driver.get("http://facebook.com");
        String title= driver.getTitle();
        boolean iceriyorMu=title.contains("Youtube");
        Assert.assertFalse(iceriyorMu);
    }
   @AfterClass
    public static void tearDown(){
       driver.quit();
   }






}
