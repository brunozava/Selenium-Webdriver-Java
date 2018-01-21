package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver navegador) {
        super(navegador);
    }

    public String verifySearchProductTrue(){
        String produtoEncontrado = navegador.findElement(By.xpath(".//*[@id='search-linx']/ul/div/li[3]")).getText();
        return produtoEncontrado;
    }

    public String verifySearchProductFalse(){
        //String produtoNaoEncontrado = navegador.findElement(By.xpath("//div[@class='OPS! O ITEM PROCURADO NÃO PODE SER ENCONTRADO.']")).getText();
        //String produtoNaoEncontrado = navegador.findElement(By.cssSelector("div[class='OPS! O ITEM PROCURADO NÃO PODE SER ENCONTRADO.']")).getText();
        String produtoNaoEncontrado = navegador.findElement(By.className("nm-not-found-message")).getText();
        return produtoNaoEncontrado;

    }


}

