/**
 * @author DiegoBitencourt
 * @version 1.0.0
 * @see <a href="https://www.pastorecc.com.br/site/photos/cars/243/bg_1Ju5J2WZXFBxRIhk4qdB.jpeg">Opala Amarelo</a>
 */
public class Carro {

    private String marca;
    private String modelo;
    private String cor;
    private int ano;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void ligarCarro(){
        System.out.println("Você ligou o carro");
    }
    public void desligarCarro(){
        System.out.println("Você desligou o carro");
    }
    public void acelerarCarro(){
        System.out.println("Você está acelerando o carro");
    }

    public void pararCarro(){
        System.out.println("Você parou o carro");
    }

}
