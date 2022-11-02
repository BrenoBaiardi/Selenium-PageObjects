package br.com.alura.leilao;

import br.com.alura.leilao.login.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {

    private LoginPage paginaDeLogin;


    @BeforeAll
    public static void beforeAll(){
        System.setProperty("webdriver.chrome.driver", "/drivers/chromedriver.exe");
    }

    @BeforeEach
    public void beforeEach(){
        paginaDeLogin = new LoginPage();
    }

    @AfterEach
    public void afterEach(){
        paginaDeLogin.fechar();
    }

    @Test
    public void loginComSucesso() {
        paginaDeLogin.preenhcerLogin("fulano","pass");
        paginaDeLogin.confirmarLogin();

        Assert.assertFalse(paginaDeLogin.isPaginaDeLogin());
        Assert.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());
    }

    @Test
    public void naoDeveriaLogarComDadosInvalidos() {
        paginaDeLogin.preenhcerLogin("batata", "batata");
        paginaDeLogin.confirmarLogin();

        Assert.assertTrue(paginaDeLogin.isPagina(LoginPage.URL_LOGIN + "?error"));
        Assert.assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));
        Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
    }

    @Test
    public void naoAcessaPaginaRestritaSemLogin(){
        paginaDeLogin.navegarParaLances();
        Assert.assertTrue(paginaDeLogin.isPaginaDeLogin());
        Assert.assertFalse(paginaDeLogin.contemTexto("dados do leilao"));
    }
}
