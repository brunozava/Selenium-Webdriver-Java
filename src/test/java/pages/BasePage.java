package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver navegador;

    public BasePage(WebDriver navegador){
        this.navegador = navegador;
    }

    public String capturarTextoToast(){
        return navegador.findElement(By.className("user-name")).getText();
    }

    public String msgUserInvalido(){
        return navegador.findElement(By.id("ga-track-error")).getText();
    }

    public String msgSenhaInvalida(){
        return navegador.findElement(By.id("ga-track-error")).getText();
    }


}
