package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;

public class NewUserFormPage extends BasePage {
    public NewUserFormPage(WebDriver navegador) {
        super(navegador);
    }

    //--------------------------------//
    //INICIANDO CADASTRO PESSOA FISICA
    //-------------------------------//

    public NewUserFormPage typeName(String name){
        navegador.findElement(By.id("name")).sendKeys(name);
        return this;
    }
    public NewUserFormPage typelastName(String lastname){
        navegador.findElement(By.id("last-name")).sendKeys(lastname);
        return this;
    }
    public NewUserFormPage selectMaleGender(){
        navegador.findElement(By.id("male")).click();
        return this;
    }

    public NewUserFormPage typeDiaNasc(String dia){
        WebElement campoDia = navegador.findElement(By.id("dayBrithday"));
        new Select(campoDia).selectByVisibleText(dia);
        return this;
    }

    public NewUserFormPage typeMesNasc(String mes){
        WebElement campoMes = navegador.findElement(By.id("monthBrithday"));
        new Select(campoMes).selectByVisibleText(mes);
        return this;
    }

    public NewUserFormPage typeAnoNasc(String ano){
        WebElement campoAno = navegador.findElement(By.id("yearBrithday"));
        new Select(campoAno).selectByVisibleText(ano);
        return this;
    }

    public NewUserFormPage typeCPF(String cpf){
        navegador.findElement(By.id("cpf")).sendKeys(cpf);
        return this;
    }

    public NewUserFormPage typeCEP1(String cep1){
        navegador.findElement(By.id("cep-1")).sendKeys(cep1);
        return this;
    }

    public NewUserFormPage typeCEP2(String cep2){
        navegador.findElement(By.id("cep-2")).sendKeys(cep2);
        navegador.findElement(By.id("cep-2")).sendKeys(Keys.TAB);
        return this;
    }

    public NewUserFormPage typeAddressNumber(String addressn){
        navegador.findElement(By.id("address-number")).sendKeys(addressn);
        return this;
    }

    public NewUserFormPage typePhoneNumberDDD(String PhoneNumberDDD){
        navegador.findElement(By.id("phone-number-ddd")).sendKeys(PhoneNumberDDD);
        return this;
    }

    public NewUserFormPage typePhoneNumber(String PhoneNumber){
        navegador.findElement(By.id("phone-number")).sendKeys(PhoneNumber);
        return this;
    }

    public NewUserFormPage typeCelPhoneNumberDDD(String CelPhoneDDD){
        navegador.findElement(By.id("celphone-number-ddd")).sendKeys(CelPhoneDDD);
        return this;
    }

    public NewUserFormPage typeCelPhoneNumber(String CelPhoneNumber){
        navegador.findElement(By.id("celphone-number")).sendKeys(CelPhoneNumber);
        return this;
    }

    public NewUserFormPage typePassword(String password){
        navegador.findElement(By.id("password")).sendKeys(password);
        return this;
    }

    public NewUserFormPage selectPoliticaProvacidade(){
        navegador.findElement(By.id("check-privacy-policy")).click();
        return this;
    }

    public HomePage clicarContinuarButton(){
        //navegador.findElement(By.className("left-icon")).click();
        navegador.findElement(By.cssSelector(".left-icon")).click();
        return new HomePage(navegador);
    }

    public String getNome(){
        return navegador.findElement(By.className("user-name")).getText();
    }
    //--------------------------------//
    //INICIANDO CADASTRO PESSOA JURIDICA
    //-------------------------------//

    public NewUserFormPage selectPJ(){
        //navegador.findElement(By.linkText("PESSOA JURÍDICA")).click();
        //navegador.findElement(By.cssSelector('.box-tab a[href="register.jsp?target=null&emailId=hjk@ggg.com&register=business"]')).click();
        //navegador.findElement(By.cssSelector('a[href="register.jsp?target=null&emailId=hjk@ggg.com&register=business"]')).click();
        navegador.findElement(By.xpath("html/body/div[2]/div/div[2]/form/div/div[1]/ul/li[2]/a")).click();
        return this;
    }

    public NewUserFormPage typeRazaoSocial(String razaoSocial){
        navegador.findElement(By.id("company-name")).sendKeys(razaoSocial);
        return  this;
    }

    public NewUserFormPage typeNomeFantasia(String nomeFantasia){
        navegador.findElement(By.id("fantasy-name")).sendKeys(nomeFantasia);
        return  this;
    }

    public NewUserFormPage typeCNPJ(String cnpj){
        navegador.findElement(By.id("cnpj")).sendKeys(cnpj);
        return this;
    }

    public NewUserFormPage typeInscricaoMunicipal(String inscMunicipal){
        navegador.findElement(By.id("municipal-registration")).sendKeys(inscMunicipal);
        return this;
    }

    public NewUserFormPage marcaIsento(){
        navegador.findElement(By.id("exempt")).click();
        return this;
    }

    public String cadastrarNovoUsuarioPJ(String razaoSocial, String nomeFantasia, String cnpj, String inscMunicipal, String cep1, String cep2, String numero, String phoneDDD, String phoneNumber, String celDDD, String celNumber, String password){
        selectPJ();
        typeRazaoSocial(razaoSocial);
        typeNomeFantasia(nomeFantasia);
        typeCNPJ(cnpj);
        typeInscricaoMunicipal(inscMunicipal);
        marcaIsento();
        typeCEP1(cep1);
        typeCEP2(cep2);
        typeAddressNumber(numero);
        typePhoneNumberDDD(phoneDDD);
        typePhoneNumber(phoneNumber);
        typeCelPhoneNumberDDD(celDDD);
        typeCelPhoneNumber(celNumber);
        typePassword(password);
        selectPoliticaProvacidade();
        clicarContinuarButton();
        //return new HomePage(navegador);
        getNome();
        return getNome();
    }

    public String cadastrarNovoUsuarioPF(String name, String lastname, String dia, String mes, String ano, String cpf, String cep1, String cep2, String numero, String phoneDDD, String phoneNumber, String celDDD, String celNumber, String password){
        typeName(name);
        typelastName(lastname);
        selectMaleGender();
        typeDiaNasc(dia);
        typeMesNasc(mes);
        typeAnoNasc(ano);
        typeCPF(cpf);
        typeCEP1(cep1);
        typeCEP2(cep2);
        typeAddressNumber(numero);
        typePhoneNumberDDD(phoneDDD);
        typePhoneNumber(phoneNumber);
        typeCelPhoneNumberDDD(celDDD);
        typeCelPhoneNumber(celNumber);
        typePassword(password);
        selectPoliticaProvacidade();
        clicarContinuarButton();
        //return new HomePage(navegador);
        getNome();
        return getNome();
    }















}
