package com.nw.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestAmazon {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello Selenium.");
        String browser = System.getProperty("user.dir")+ File.separator+"resource"+File.separator+"chromedriver";
        System.out.println(browser);
        System.setProperty("webdriver.chrome.driver", browser);

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.cn");

        WebElement we = driver.findElement(By.id("twotabsearchtextbox"));
        we.sendKeys("软件测试");

        driver.findElement(By.className("nav-input")).submit();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.linkText("软件测试(原书第2版)")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // get the current page handle
        String handle = driver.getWindowHandle();
        // get the all pages handle and check which is not the current one.
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle))
                continue;
            driver.switchTo().window(handles);
        }

        driver.manage().window().maximize();
        driver.findElement(By.xpath(".//*[@id='add-to-cart-button']")).submit();

        WebElement txtDisplay = driver.findElement(By.xpath(".//*[@id='huc-v2-order-row-confirm-text']/h1"));
        WebElement txtPrice = driver.findElement(By.xpath(".//*[@id='hlb-subcart']/div[1]/span/span[2]"));

        String strPrice = txtPrice.getText();
        strPrice = strPrice.substring(strPrice.indexOf('¥') + 2, strPrice.length());

        Thread.sleep(Long.parseLong("5000"));
        driver.close();
    }
}
