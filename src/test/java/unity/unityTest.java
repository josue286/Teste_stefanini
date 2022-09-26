package unity;

import org.junit.Test;

public class unityTest extends unityPage{
    public unityPage pessoa;

    @Test
    public void cadastraPessoa(){
        this.pessoa = new unityPage();
        pessoa.cadastraPessoa("soca fofo 69", "1234567890");
        pessoa.perfilPessoaCadastrada();
    }

    @Test
    public void alteraPerfil(){
        this.pessoa = new unityPage();
        pessoa.cadastraPessoa("soca fofo 69", "1234567890");
        pessoa.perfilPessoaCadastrada();
        pessoa.trocaInformacoesDoPerfil("espanca utero", "0987654321");
    }
}
