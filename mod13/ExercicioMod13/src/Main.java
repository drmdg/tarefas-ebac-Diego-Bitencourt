import ClassesConcretas.PessoaFisica;
import ClassesConcretas.PessoaJuridica;

public class Main {
    public static void main(String[] args) {


        PessoaFisica pessoaFisica = new PessoaFisica();
        PessoaJuridica pessoaJuridica = new PessoaJuridica();

        pessoaFisica.setNome("Diego de Souza");
        pessoaFisica.setCpf(5646515L);

        pessoaFisica.imprimirNome();
        pessoaFisica.impimirCpf();

        pessoaJuridica.setNome("General Motors");
        pessoaJuridica.setCnpj(64565325135L);

        pessoaJuridica.imprimirNome();
        pessoaJuridica.imprimirCnpj();
    }
}