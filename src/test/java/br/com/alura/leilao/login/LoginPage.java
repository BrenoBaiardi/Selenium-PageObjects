package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    public static final String URL_LOGIN = "http://localhost:8080/login";
    private static final String URL_LEILOES = "http://localhost:8080/leiloes";
    private final WebDriver browser;

    public LoginPage() {
        System.setProperty("webdriver.chrome.driver", "/drivers/chromedriver.exe");
        this.browser = new ChromeDriver();
        this.browser.navigate().to(URL_LOGIN);
    }

    public void fechar() {
        this.browser.quit();
    }

    public void preenhcerLogin(String username, String password) {
        browser.findElement(By.id("username")).sendKeys(username);
        browser.findElement(By.id("password")).sendKeys(password);
    }

    public void confirmarLogin() {
        browser.findElement(By.id("login-form")).submit();
    }

    public Boolean isPaginaDeLogin() {
        return browser.getCurrentUrl().equals(URL_LOGIN);
    }

    public Boolean isPagina(String pagina) {
        return browser.getCurrentUrl().equals(pagina);
    }

    public String getNomeUsuarioLogado() {
        try {
            return browser.findElement(By.id("usuario-logado")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void navegarParaLances() {
        browser.navigate().to(URL_LEILOES + "/2");
    }

    public boolean contemTexto(String texto) {
        return browser.getPageSource().contains(texto);
    }
}
