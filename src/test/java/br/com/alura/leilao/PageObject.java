package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class PageObject {

    private static WebDriver browser;

    private PageObject() {
        throw new IllegalStateException("utility class");
    }

    public static WebDriver getBrowser(){
        if (browser == null) {
            System.setProperty("webdriver.chrome.driver", "/drivers/chromedriver.exe");
            browser = new ChromeDriver();
        }
        return browser;
    }
}
