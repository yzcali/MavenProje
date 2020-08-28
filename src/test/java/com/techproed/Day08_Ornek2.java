package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day08_Ornek2 {
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterClass
    public static void teardown(){

    }
    @Before
    public void Testtenonce (){
        driver.get("http://google.com");

    }
    @After
    public void testtensonra(){


        WebElement sonucSayisi = driver.findElement(By.id("result-stats"));
        System.out.println(sonucSayisi.getText());
    }
    @Test
    public void test1(){
        WebElement searchB= driver.findElement(By.xpath("//input[@name='q']"));
        searchB.sendKeys("elma");
        searchB.submit();

    }
    @Test
    public void test2(){
        WebElement searchB= driver.findElement(By.xpath("//input[@name='q']"));
        searchB.sendKeys("samsung phone");
        searchB.submit();
    }
    @Test
    public void test3(){
        WebElement searchB= driver.findElement(By.xpath("//input[@name='q']"));
        searchB.sendKeys("calisma masasi");
        searchB.submit();
    }
}
