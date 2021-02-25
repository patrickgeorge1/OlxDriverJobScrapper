package com.company;

import com.company.document_parsers.OlxDocumentParser;
import com.company.utils.HttpRequestType;
import com.company.utils.Job;
import com.company.utils.WebsiteDownloader;
import com.company.vendors.OlxVendor;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
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

        // Get the webpage
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Thread.sleep(2000);

        // Find the proper frame and click on the accept button
        String xpath =  "//IFrame[starts-with(@src, 'https://consent.google.com')]";
        WebElement we = driver.findElements(By.xpath(xpath)).get(0);
        driver.switchTo().frame(we);
        driver.findElement(By.id("introAgreeButton")).click();

        // driver.close();
    }

}
