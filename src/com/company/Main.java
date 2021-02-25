package com.company;

import com.company.document_parsers.OlxDocumentParser;
import com.company.utils.HttpRequestType;
import com.company.utils.Job;
import com.company.utils.WebsiteDownloader;
import com.company.vendors.OlxVendor;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


/**
 * File / Project structure / Modules / Dependencies add Jar client-combined.jar
 * File / Project structure / Modules / Dependencies add Libs  libs from selenium java client
 * Chrome Driver :              https://sites.google.com/a/chromium.org/chromedriver/
 * Selenium Client Java :       https://www.selenium.dev/downloads/
 */
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        File file = new File("D:/chromeWebDriver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        waitForPageLoad(driver);
        waitForAcceptCookiesFrame(webDriver);
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        driver.findElement(By.className("RveJvd snByac"));
    }
}
