package ClassesConcretas;

import ClasseAbstrata.Pessoa;

public class PessoaFisica extends Pessoa {

    private Long cpf;

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    @Override
    public void imprimirNome() {
        System.out.println("Imprimindo o nome da classe PessoaFisica: "+ this.getNome());
    }
    public void impimirCpf(){
        System.out.println("Imprimindo CPF: " + this.cpf);
    }
}
