package com.nw.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class TestAmazon {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello Selenium.");
        String browser = System.getProperty("user.dir")+ File.separator+"resource"+File.separator+"chromedriver";
        System.out.println(browser);
        System.setProperty("webdriver.chrome.driver", browser);

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");

        Thread.sleep(Long.parseLong("5000"));
        driver.close();
    }
}
