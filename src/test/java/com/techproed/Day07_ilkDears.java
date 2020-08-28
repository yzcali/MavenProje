package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day07_ilkDears {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.amazon.com");

        WebElement searchB =driver.findElement(By.xpath("//input[@type='text']"));
        searchB.sendKeys("samsung headphones"+ Keys.ENTER);
        //searchB.submit();



       // WebElement sonucSayisi = driver.findElement(By.xpath("//span[@dir='auto']"));
       // System.out.println(sonucSayisi.getText());



      //  WebElement pro= driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'"));
       //  pro.click();

        List<WebElement> listem = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement w : listem){
            System.out.println(w.getText());
        }


    }
}
