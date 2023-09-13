public class Corvette extends Cars{
    public Corvette(String marca, String modelo, String cor, Integer ano) {
        super(marca, modelo, cor, ano);
    }

    @Override
    public void ligarCarro() {
        System.out.println("Ligando Corvette");
    }

    @Override
    public void desligarCarro() {
        System.out.println("Desligando Corvette");
    }
}
