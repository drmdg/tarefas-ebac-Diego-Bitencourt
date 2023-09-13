public class Civic extends Cars{
    public Civic(String marca, String modelo, String cor, Integer ano) {
        super(marca, modelo, cor, ano);
    }

    @Override
    public void ligarCarro() {
        System.out.println("Ligando Civic");
    }

    @Override
    public void desligarCarro() {
        System.out.println("Desligando Civic");
    }
}
