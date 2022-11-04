package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.PageInterface;
import br.com.alura.leilao.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class CadastroLeilaoPage implements PageInterface {
    private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";

    private final WebDriver browser;

    public CadastroLeilaoPage(WebDriver browser) {
        this.browser = browser;
    }

    public CadastroLeilaoPage() {
        this(PageObject.getBrowser());
    }

    @Override
    public WebDriver getBrowser() {
        return browser;
    }

    @Override
    public void fechar() {
        PageObject.fechar();
    }

    public LeiloesPage cadastrarLeilao(String nome, String valor, String data) {
        getBrowser().findElement(By.id("nome")).sendKeys(nome);
        getBrowser().findElement(By.id("valorInicial")).sendKeys(valor);
        getBrowser().findElement(By.id("dataAbertura")).sendKeys(data);
        getBrowser().findElement(By.id("button-submit")).submit();
        return new LeiloesPage(getBrowser());
    }

    public boolean isMensagensDeValidacaoVisiveis() {
        return contemTexto("não deve estar em branco")
                && contemTexto("minimo 3 caracteres")
                && contemTexto("deve ser um valor maior de 0.1")
                && contemTexto("deve ser uma data no formato dd/MM/yyyy");
    }
}
