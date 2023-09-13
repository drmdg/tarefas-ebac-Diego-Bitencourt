public class Supra extends Cars{
    public Supra(String marca, String modelo, String cor, Integer ano) {
        super(marca, modelo, cor, ano);
    }

    @Override
    public void ligarCarro() {
        System.out.println("Ligando Supra");
    }

    @Override
    public void desligarCarro() {
        System.out.println("Desligando Supra");
    }
}
