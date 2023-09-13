public abstract class Cars {

    String marca;
    String modelo;
    String cor;
    Integer ano;

    public Cars(String marca, String modelo, String cor, Integer ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
    }

    public abstract void ligarCarro();

    public abstract void desligarCarro();

}
