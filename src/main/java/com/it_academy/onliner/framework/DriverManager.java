package com.it_academy.onliner.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>(); // переменную ThreadLocal исп. для
    // безконфлиткного запуска тестов.

    public static void setDriver() {
//      one of the way implementation driver: download and set path to driver in system variable
//      System.setProperty("webDriver.chrome.driver",""); //или в pomFile System property указать путь
        if (driver.get() == null) {
            WebDriverManager.chromedriver().setup();          // подключение с пом-ю библиотеки
            driver.set(new ChromeDriver());
        } else {
            System.out.println("driver has been set" + Thread.currentThread().getId());   //log потом
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeDriver() {
        driver.get().quit();
        driver.remove();
    }
}
