package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.PageInterface;
import br.com.alura.leilao.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class LeiloesPage implements PageInterface {
    public static final String URL_LEILOES = "http://localhost:8080/leiloes";

    private final WebDriver browser;

    public LeiloesPage(WebDriver browser) {
        this.browser = browser;
    }

    public LeiloesPage() {
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

    public CadastroLeilaoPage carregarFormulario() {
        getBrowser().findElement(By.id("novo_leilao_link")).click();
        return new CadastroLeilaoPage(getBrowser());
    }

    public boolean isLeilaoCadastrado(String nome, String valor, String data) {
        WebElement linhaDaTabela = getBrowser().findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
        WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement colunaData = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement colunaValor = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
        return colunaNome.getText().equals(nome)
                && colunaData.getText().equals(data)
                && colunaValor.getText().equals(valor);
    }
}
