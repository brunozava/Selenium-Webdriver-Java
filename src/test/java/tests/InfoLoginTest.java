package tests;

import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.HomePage;
import pages.LoginTypePage;
import suporte.Web;

public class InfoLoginTest {
    private WebDriver navegador;

    //@Rule
    //public TestName test = new TestName();

    @Before
    public void setUp() {
        navegador = Web.createChrome();
    }

    @Test
    public void testLogandoComUsuarioExistente(){
        String textoToast = new HomePage(navegador)
                .clicandoEmLoginPage()
                .logandoUserExistente("bruno_zava@hotmail.com", "130887")
                .capturarTextoToast();
        Assert.assertEquals("Bruno", textoToast);
    }

    @Test
    public void testLogandoComUsuarioInvalido(){
        String msgUserInvalido = new HomePage(navegador)
                .clicandoEmLoginPage()
                .logandoUserInvalido("gjgjgjgj@fdgdf.com", "123456")
                .msgUserInvalido();
        Assert.assertEquals("Ops! Usuário não encontrado. Confira seus dados ou crie uma conta", msgUserInvalido);
    }

    @Test
    public void testLogandoComSenhaInvalida(){
        String msgSenhaInvalida = new HomePage(navegador)
                .clicandoEmLoginPage()
                .logandoSenhaInvalida("bruno_zava@hotmail.com", "kkkk")
                .msgSenhaInvalida();
        Assert.assertEquals("Senha incorreta.", msgSenhaInvalida);

    }

    @Test
    public void testCriarUsuarioNovoPF(){
        String capturarTextoToast = new HomePage(navegador)
        //String capturarTextoToastNewUser = new HomePage(navegador)
        //new HomePage(navegador)
                .clicandoEmLoginPage()
                .newUserRegistration("brunoxyzkkxycrdf@ns.com")
                .cadastrarNovoUsuarioPF("Bruno", "Zavanella", "2", "Jan", "1966", "24521273297", "09111", "200", "33", "11", "992788844", "11", "988775566", "130887");
        Assert.assertEquals("Bruno", capturarTextoToast);
    }

    @Test
    public void testCriarUsuarioNovoPJ(){
        String capturarTextoToast = new HomePage(navegador)
                .clicandoEmLoginPage()
                .newUserRegistration("jjj@pj.com")
                .cadastrarNovoUsuarioPJ("Bruno", "Zavanella", "65863568000181", "12345", "09111", "100", "777", "11", "998776611", "11", "977556633", "130887");
        Assert.assertEquals("Bruno",capturarTextoToast );

    }

    @Test
    public void testRealizarBuscaValida(){
        String verificarProdutobuscado = new HomePage(navegador)
                .buscarProduto("camiseta")
                .verifySearchProductTrue();
        Assert.assertEquals("camiseta", verificarProdutobuscado );
    }

    @Test
    public void testRealizarBuscaInvalida(){
        String verificarProdutobuscado = new HomePage(navegador)
                .buscarProduto("aaaaaa")
                .verifySearchProductFalse();
        Assert.assertEquals("OPS! O ITEM PROCURADO NÃO PODE SER ENCONTRADO.", verificarProdutobuscado );
    }

    //@After
    //public void tearDown() {
        //navegador.quit();
    //}
}
