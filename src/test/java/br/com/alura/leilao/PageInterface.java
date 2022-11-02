package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;

public interface PageInterface {

    WebDriver getBrowser();

    default void fechar(){
        getBrowser().quit();
    }
    default boolean contemTexto(String texto) {
        return getBrowser().getPageSource().contains(texto);
    }

    default Boolean isPagina(String pagina) {
        return getBrowser().getCurrentUrl().equals(pagina);
    }
}
