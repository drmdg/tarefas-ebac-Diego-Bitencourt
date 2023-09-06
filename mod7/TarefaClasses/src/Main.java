

public class Main {
    public static void main(String[] args) {

        Carro meuCarro = new Carro();

        meuCarro.setMarca("Chevrolet");
        meuCarro.setModelo("Opala SS");
        meuCarro.setCor("Amarelo");
        meuCarro.setAno(1976);

        System.out.println(meuCarro.getMarca());
        System.out.println(meuCarro.getModelo());
        System.out.println(meuCarro.getCor());
        System.out.println(meuCarro.getAno());

        System.out.println("********************");

        meuCarro.ligarCarro();
        meuCarro.acelerarCarro();
        meuCarro.pararCarro();
        meuCarro.desligarCarro();

    }
}