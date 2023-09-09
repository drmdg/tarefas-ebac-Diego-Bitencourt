package ClassesConcretas;

import ClasseAbstrata.Pessoa;

public class PessoaJuridica extends Pessoa {
    private Long Cnpj;

    public Long getCnpj() {
        return Cnpj;
    }

    public void setCnpj(Long cnpj) {
        Cnpj = cnpj;
    }

    @Override
    public void imprimirNome() {
        System.out.println("Imprimindo nome da classe PessoaJuridica: "+ this.getNome());
    }
    public void imprimirCnpj(){
        System.out.println("Imprimindo CNPJ: " +this.Cnpj);
    }
}
