package com.saucedemo.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    //tworzenie webdrivera
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--headless=new");
        options.addArguments("start-maximized");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");

        //inicjalizacja drivera
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}