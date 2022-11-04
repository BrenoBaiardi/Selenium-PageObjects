package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.login.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LeiloesTest {

    private LeiloesPage paginaDeLeiloes;
    private CadastroLeilaoPage paginaDeCadastro;


    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preenhcerLogin("fulano", "pass");
        paginaDeLeiloes = paginaDeLogin.confirmarLogin();
        paginaDeCadastro = paginaDeLeiloes.carregarFormulario();
    }

    @AfterEach
    public void afterEach(){
        paginaDeLeiloes.fechar();
    }

    @Test
    public void cadastrarLeilaoComSucesso() {
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "leilao do dia " + data;
        String valor = "500.00";
        paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao(data,valor,data);
        paginaDeLeiloes.isLeilaoCadastrado(nome, valor, data);
    }

    @Test
    public void cadastrarLeilaoEmBranco() {
        paginaDeCadastro.cadastrarLeilao("","","");
        Assert.assertTrue(paginaDeCadastro.isPagina(LeiloesPage.URL_LEILOES));
        Assert.assertTrue(paginaDeCadastro.isMensagensDeValidacaoVisiveis());
    }
}
