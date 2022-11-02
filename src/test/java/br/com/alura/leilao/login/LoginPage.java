package br.com.alura.leilao.login;

import br.com.alura.leilao.PageInterface;
import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leiloes.LeiloesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends PageObject implements PageInterface{
    public static final String URL_LOGIN = "http://localhost:8080/login";
    private static final String URL_LEILOES = "http://localhost:8080/leiloes";

    public LoginPage() {
        super(null);
        this.getBrowser().navigate().to(URL_LOGIN);
    }

    public void preenhcerLogin(String username, String password) {
        getBrowser().findElement(By.id("username")).sendKeys(username);
        getBrowser().findElement(By.id("password")).sendKeys(password);
    }

    public LeiloesPage confirmarLogin() {
        getBrowser().findElement(By.id("login-form")).submit();
        return new LeiloesPage(this.getBrowser());
    }

    public Boolean isPaginaDeLogin() {
        return isPagina(URL_LOGIN);
    }

    public String getNomeUsuarioLogado() {
        try {
            return getBrowser().findElement(By.id("usuario-logado")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void navegarParaLances() {
        getBrowser().navigate().to(URL_LEILOES + "/2");
    }

}
