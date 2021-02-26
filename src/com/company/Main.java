package com.company;

import com.company.document_parsers.OlxDocumentParser;
import com.company.utils.HttpRequestType;
import com.company.utils.Job;
import com.company.utils.WebsiteDownloader;
import com.company.vendors.OlxVendor;
import org.apache.commons.io.FileUtils;
import org.jsoup.nodes.Document;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

    public static void main(String[] args) throws Exception {

        File file = new File("D:/chromeWebDriver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        // Prepare Chrome driver, healess mode
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--headless");
        co.addArguments("--window-size=1325x744");
//        co.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(co);

        // Get page and wait, take screenshot
        driver.get("https://www.olx.ro/locuri-de-munca/gorj-judet/q-sofer/");
        Thread.sleep(2000);
        takeSnapShot(driver, "./poza.png");

//        // Find the proper iframe "accept cookies" and click on the accept button
//        String xpath =  "//IFrame[starts-with(@src, 'https://consent.google.com')]";
//        WebElement we = driver.findElements(By.xpath(xpath)).get(0);
//        driver.switchTo().frame(we);
//        driver.findElement(By.id("introAgreeButton")).click();

         driver.close();
    }


    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(fileWithPath);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);
    }

}
