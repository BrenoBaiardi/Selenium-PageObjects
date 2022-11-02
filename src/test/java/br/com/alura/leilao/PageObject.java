package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class PageObject {

    private WebDriver browser;

    public WebDriver getBrowser(){
        return browser;
    }

    public PageObject(WebDriver browser) {
        System.setProperty("webdriver.chrome.driver", "/drivers/chromedriver.exe");
        if (browser == null) {
            this.browser = new ChromeDriver();
        } else {
            this.browser = browser;
        }
    }

}
