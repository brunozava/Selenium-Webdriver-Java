package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver navegador) {
        super(navegador);
    }

    public LoginTypePage clicandoEmLoginPage() {
        navegador.findElement(By.className("user-name")).click();
        navegador.findElement(By.className("sub-menu-my-account")).findElement(By.linkText("Login")).click();
        return new LoginTypePage(navegador);
    }

    public SearchPage buscarProduto(String nomeProduto) {
        // navegador.findElement(By.name("q")).sendKeys(nomeProduto);
        // navegador.findElement(By.id("input-search-bt")).click();
        //navegador.findElement(By.name("q")).sendKeys(Keys.ENTER);
        // return new SearchPage(navegador);
        //}

        boolean breakIt = true;
        while (true) {
            breakIt = true;
            try {
                navegador.findElement(By.name("q")).sendKeys(nomeProduto);
                navegador.findElement(By.id("input-search-bt")).click();
            } catch (Exception e) {
                if (e.getMessage().contains("element is not attached")) breakIt = false;
            }
            if (breakIt) {
                break;
            }

        }
        return new SearchPage(navegador);

    }
}