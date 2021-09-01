package com.pluralsight;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedCondition.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class WebDriverDemo {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");


        WebDriver driver = new ChromeDriver(options);
//        driver.get("http://www.pluralsight.com");
        driver.get("https://cap7.lightning.force.com/lightning/r/Case/5000900000Euk9qAAB/view");

        WebElement username = driver.findElement((By.id("username")));
        username.click();
        username.sendKeys("nelly.valverde-97pv@force.com");

        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.sendKeys("pieskikotki1");
        password.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(presenceOfElementLocated(By.xpath("//div[@class='slds-form']//force-record-layout-item")));
        List<WebElement> fields = driver.findElements((By.xpath("//div[@class='slds-form']//force-record-layout-item//span/slot[1]/slot/*")));
        System.out.println(fields.size());

        for (WebElement field : fields ) {
            System.out.println(field.getText());
        }

// //div[@class='slds-form']//force-record-layout-item"
                WebElement ownerName = driver.findElement(By.xpath("//span[contains(@class, \"owner-name\")]//a/span"));
        String ownerNameText = ownerName.getText();
        System.out.println(ownerNameText);

//        System.out.println("siema");
    }
}

