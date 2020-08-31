package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day10_DropDown {
    static WebDriver driver; // instance variable
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test1(){
        driver.get("http://amazon.com");
        WebElement dropdown= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Baby");
       // select.selectByValue(); (usually u don't use it.)
       // select.selectByIndex();


        // getFirstSelectedOption - dropdown üzerinde şuanda seçili olan
        // webelementi size return eder.
        WebElement secim = select.getFirstSelectedOption();
        System.out.println(secim.getText());

        // getOptions() tüm seçenekleri List<WebElement> şeklinde size return eder.
        List<WebElement> liste = select.getOptions();
        for (WebElement webElement : liste){
            System.out.println(webElement.getText());
        }
        // liste.size() tüm seçeneklerin toplam sayısını size return eder.
        int toplamSecenekSayisi = liste.size();
        System.out.println("Toplam seçim sayısı : " + toplamSecenekSayisi);
    }
}
