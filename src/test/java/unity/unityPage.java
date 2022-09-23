package unity;

public class unityPage {
    String nome;
    String cpf;


    public void cadastraPessoa(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;

        System.out.println("Nome: " + this.nome + " CPF: " + this.cpf);
    }

    public void trocaInformacoesDoPerfil(String nomeAlterado, String cpfAlterado){
        System.out.println("Nome: " + nome + " CPF: " + cpf);

        System.out.println("====================== Nome Alterado ========================");

        this.nome = nomeAlterado;
        this.cpf = cpfAlterado;

        System.out.println("Nome: " + nome + " CPF: " + cpf);
    }

    public void perfilPessoaCadastrada(){
        System.out.println("Nome: " + nome + " CPF: " + cpf);
    }
}
