package test.com.br.formulario;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import test.com.br.PageObject;

import java.util.Objects;


public class FormularioPage extends PageObject {
    private static final String URL_FORMULARIO_CADASTRO = "http://prova.stefanini-jgr.com.br/teste/qa/";

    public FormularioPage() {
        super(null);
        this.browser.navigate().to(URL_FORMULARIO_CADASTRO);
    }

    public void preencheFormulario(String name, String email, String password) {
        this.browser.findElement(By.id("name")).sendKeys(name);
        this.browser.findElement(By.id("email")).sendKeys(email);
        this.browser.findElement(By.id("password")).sendKeys(password);
        this.browser.findElement(By.id("register")).submit();
    }

    public boolean isPaginaDeCadastro() {
        return browser.getCurrentUrl().equals(URL_FORMULARIO_CADASTRO);
    }

    public String getNomeUsuarioCadastrado() {
        try{
            return browser.findElement(By.id("tdUserName1")).getText();
        }catch (NoSuchElementException e) {
            return null;
        }
    }

    public String getNomeEmBranco() {
        return browser.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/form/div[1]/p")).getText();
    }

    public String getSenhaEmBranco() {
       return browser.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/form/div[3]/p")).getText();
    }

    public String getEmailEmBranco() {
        return browser.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/form/div[2]/p")).getText();
    }

    public String getNomeIncompleto() {
        return browser.findElement(By.className("error")).getText();
    }

    public String EmailIncompleto() {
        return browser.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/form/div[2]/p")).getText();
    }

    public String SenhaIncompleto() {
      return browser.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/form/div[3]/p")).getText();
    }

    public String NumerosNoCampoNome() {
        return browser.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/form/div[1]/p")).getText();
    }

    public String NumerosNoCampoEmail() {
        return  browser.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/form/div[2]/p")).getText();
    }

    public String exibeErro(){
       return browser.findElement(By.className("error")).getText();
    }

    public void btnExcluiUsuarioCadastrado() {
        browser.findElement(By.xpath("//*[@id=\"removeUser1\"]")).click();
    }

    public Boolean verificarEmailNaoCadastraMaisDeUmaVez() {
        return Objects.equals(browser.findElement(By.xpath("//*[@id=\"tdUserEmail2\"]")).getText(), browser.findElement(By.xpath("//*[@id=\"tdUserEmail1\"]")));
    }
}