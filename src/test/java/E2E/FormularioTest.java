package E2E;

import E2E.FormularioPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class FormularioTest {

    private FormularioPage paginaFormulario;

    @BeforeEach
    public void beforeEach() {
        this.paginaFormulario = new FormularioPage();
    }

    @AfterEach
    public void afterEach() {
        this.paginaFormulario.fechar();
    }

    @Test
    public void deveEfetuarCadastro() {
        paginaFormulario.preencheFormulario("Josue Messias", "Josue.messias@gmail.com", "josue12345");

        Assertions.assertTrue(paginaFormulario.isPaginaDeCadastro());
        Assertions.assertEquals("Josue Messias", paginaFormulario.getNomeUsuarioCadastrado());

    }

    @Test
    public void usuarioCadastraComNomeIncompleto() {
        paginaFormulario.preencheFormulario("Jo ", "Josue.messias@gmail.com", "josue12345");

        Assertions.assertTrue(paginaFormulario.isPaginaDeCadastro());
        Assertions.assertEquals("Por favor, insira um nome completo.", paginaFormulario.getNomeIncompleto());
    }

    @Test
    public void campoNomeEmBranco() {
        paginaFormulario.preencheFormulario("", "Josue.messias@gmail.com", "josue12345");

        Assertions.assertTrue(paginaFormulario.isPaginaDeCadastro());
        Assertions.assertEquals("O campo Nome é obrigatório.", paginaFormulario.getNomeEmBranco());
    }

    @Test
    public void campoSenhaEmBranco() {
        paginaFormulario.preencheFormulario("Josue Messias", "Josue.messias@gmail.com", "");

        Assertions.assertTrue(paginaFormulario.isPaginaDeCadastro());
        Assertions.assertEquals("O campo Senha é obrigatório.", paginaFormulario.getSenhaEmBranco());
    }

    @Test
    public void campoEmailEmBranco() {
        paginaFormulario.preencheFormulario("Josue Messias", "", "josue12345");

        Assertions.assertTrue(paginaFormulario.isPaginaDeCadastro());
        Assertions.assertEquals("O campo E-mail é obrigatório.", paginaFormulario.getEmailEmBranco());
    }

    @Test
    public void emailIncompleto() {
        paginaFormulario.preencheFormulario("Josue Messias", "Josue@gmail", "josue12345");

        Assertions.assertTrue(paginaFormulario.isPaginaDeCadastro());
        Assertions.assertEquals("Por favor, insira um e-mail válido.", paginaFormulario.EmailIncompleto());
    }

    @Test
    public void senhaIncompleta() {
        paginaFormulario.preencheFormulario("Josue Messias", "Josue.messias@gmail.com", "josu");

        Assertions.assertTrue(paginaFormulario.isPaginaDeCadastro());
        Assertions.assertEquals("A senha deve conter ao menos 8 caracteres.", paginaFormulario.SenhaIncompleto());
    }

    @Test
    public void numerosNoCampoNome() {
        paginaFormulario.preencheFormulario("374658", "Josue.messias@gmail.com", "josue12345");

        Assertions.assertTrue(paginaFormulario.isPaginaDeCadastro());
        Assertions.assertEquals("Por favor, insira um nome completo.", paginaFormulario.NumerosNoCampoNome());
    }

    @Test
    public void numerosNoCampoEmail() {
        paginaFormulario.preencheFormulario("Josue Messias", "374658", "josue12345");

        Assertions.assertTrue(paginaFormulario.isPaginaDeCadastro());
        Assertions.assertEquals("Por favor, insira um e-mail válido.", paginaFormulario.NumerosNoCampoEmail());
    }

    @Test
    public void nomeEsenhaEmBranco() {
        paginaFormulario.preencheFormulario("", "Josue.messias@gmail.com", "");

        Assertions.assertTrue(paginaFormulario.isPaginaDeCadastro());
        Assertions.assertEquals("O campo Nome é obrigatório.", paginaFormulario.getNomeEmBranco());
        Assertions.assertEquals("O campo Senha é obrigatório.", paginaFormulario.getSenhaEmBranco());
    }

    @Test
    public void nomeIncompletoEsenhaIncompleta() {
        paginaFormulario.preencheFormulario("josu", "Josue.messias@gmail.com", "josue");

        Assertions.assertTrue(paginaFormulario.isPaginaDeCadastro());
        Assertions.assertEquals("Por favor, insira um nome completo.", paginaFormulario.getNomeIncompleto());
        Assertions.assertEquals("A senha deve conter ao menos 8 caracteres.", paginaFormulario.SenhaIncompleto());
    }

    @Test
    public void emailIncompletoEsenhaIncompleta() {
        paginaFormulario.preencheFormulario("josue Messias", "Josue@gmail", "josue");

        Assertions.assertTrue(paginaFormulario.isPaginaDeCadastro());
        Assertions.assertEquals("Por favor, insira um e-mail válido.", paginaFormulario.EmailIncompleto());
        Assertions.assertEquals("A senha deve conter ao menos 8 caracteres.", paginaFormulario.SenhaIncompleto());
    }

    @Test
    public void nomeIncompletoEemailIncompleto() {
        paginaFormulario.preencheFormulario("josu", "Josue@gmail", "josue12345");

        Assertions.assertTrue(paginaFormulario.isPaginaDeCadastro());
        Assertions.assertEquals("Por favor, insira um nome completo.", paginaFormulario.getNomeIncompleto());
        Assertions.assertEquals("Por favor, insira um e-mail válido.", paginaFormulario.EmailIncompleto());
    }
    @Test
    public void emailIncompletoEsenhaEmbranco() {
        paginaFormulario.preencheFormulario("josue Messias", "Josue@gmail", "");

        Assertions.assertTrue(paginaFormulario.isPaginaDeCadastro());
        Assertions.assertEquals("Por favor, insira um e-mail válido.", paginaFormulario.EmailIncompleto());
        Assertions.assertEquals("O campo Senha é obrigatório.", paginaFormulario.getSenhaEmBranco());
    }
    @Test
    public void emailNoCampoNomeEnomeNoEmail() {
        paginaFormulario.preencheFormulario("Josue.messias@gmail.com","Josu Messias","josue123456");

        Assertions.assertTrue(paginaFormulario.isPaginaDeCadastro());
        Assertions.assertEquals("Por favor, insira um nome completo.", paginaFormulario.getNomeIncompleto());
        Assertions.assertEquals("Por favor, insira um e-mail válido.", paginaFormulario.EmailIncompleto());


    }
    @Test
    public void todosOsCamposEmbranco() {
        paginaFormulario.preencheFormulario("", "", "");

        Assertions.assertTrue(paginaFormulario.isPaginaDeCadastro());
        Assertions.assertEquals("O campo Nome é obrigatório.", paginaFormulario.getNomeEmBranco());
        Assertions.assertEquals("O campo E-mail é obrigatório.", paginaFormulario.getEmailEmBranco());
        Assertions.assertEquals("O campo Senha é obrigatório.", paginaFormulario.getSenhaEmBranco());
    }
    @Test
    public void usuarioCadastradoDepoisExcluido() throws InterruptedException {
        paginaFormulario.preencheFormulario("Josue Messias", "Josue.messias@gmail.com", "josue123456");
        paginaFormulario.btnExcluiUsuarioCadastrado();

        this.paginaFormulario.esperarCarregar();
        Assertions.assertTrue(paginaFormulario.isPaginaDeCadastro());
    }
    @Test
    public void usuarioCadastrandoMaisDeUmaVez() {
        paginaFormulario.preencheFormulario("Josue Messias", "Josue.messias@gmail.com", "josue123456");
        paginaFormulario.preencheFormulario("Josue Messias", "Josue.messias@gmail.com", "josue123456");
        Assertions.assertTrue(paginaFormulario.isPaginaDeCadastro());
        Assertions.assertEquals(true, paginaFormulario.verificarEmailNaoCadastraMaisDeUmaVez());

    }


}











