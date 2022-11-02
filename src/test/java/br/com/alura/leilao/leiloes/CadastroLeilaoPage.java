package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage {
    private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
    private final WebDriver browser;

    public CadastroLeilaoPage(WebDriver browser) {
        this.browser = browser;
    }

    public void fechar() {
        this.browser.quit();
    }

    public boolean contemTexto(String texto) {
        return browser.getPageSource().contains(texto);
    }

    public LeiloesPage cadastrarLeilao(String nome, String valor, String data) {
        browser.findElement(By.id("nome")).sendKeys(nome);
        browser.findElement(By.id("valorInicial")).sendKeys(valor);
        browser.findElement(By.id("dataAbertura")).sendKeys(data);
        browser.findElement(By.id("button-submit")).submit();
        return new LeiloesPage(browser);
    }

    public Boolean isPagina(String pagina) {
        return browser.getCurrentUrl().equals(pagina);
    }

    public boolean isMensagensDeValidacaoVisiveis() {
        return contemTexto("não deve estar em branco")
                && contemTexto("minimo 3 caracteres")
                && contemTexto("deve ser um valor maior de 0.1")
                && contemTexto("deve ser uma data no formato dd/MM/yyyy");
    }
}
