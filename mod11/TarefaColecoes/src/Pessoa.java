public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private String sexo;

    public Pessoa(String nome, String sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                '}';
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public int compareTo(Pessoa o) {
        return this.nome.compareTo(o.getNome());
    }
}
