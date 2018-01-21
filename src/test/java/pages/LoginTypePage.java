package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTypePage extends BasePage{
    public LoginTypePage(WebDriver navegador) {
        super(navegador);
    }

    public LoginTypePage typeEmail(String email){
        navegador.findElement(By.id("email-cpf")).sendKeys(email);
        return this;
    }

    public LoginTypePage typeSenha(String senha){
        navegador.findElement(By.id("password")).sendKeys(senha);
        return this;
    }

    public HomePage clickEntrarButton(){
        navegador.findElement(By.id("login-button")).click();
        return new HomePage(navegador);
    }

    public LoginTypePage typeNewEmail(String email){
        navegador.findElement(By.id("email")).sendKeys(email);
        return this;
    }

    public NewUserFormPage clickContinuarButton(){
        navegador.findElement(By.id("continue-button")).click();
        return new NewUserFormPage(navegador);
    }

    public NewUserFormPage newUserRegistration(String email){
        typeNewEmail(email);
        clickContinuarButton();
        return new NewUserFormPage(navegador);


    }

    public HomePage logandoUserExistente(String email, String senha){
        typeEmail(email);
        typeSenha(senha);
        clickEntrarButton();
        return new HomePage(navegador);
    }

    public LoginTypePage logandoUserInvalido(String email, String senha){
        typeEmail(email);
        typeSenha(senha);
        clickEntrarButton();
        return this;
    }

    public LoginTypePage logandoSenhaInvalida(String email, String senha){
        typeEmail(email);
        typeSenha(senha);
        clickEntrarButton();
        return this;
    }

}
