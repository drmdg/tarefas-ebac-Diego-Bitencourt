import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Civic civic = new Civic("Honda","Lxs","Prata",2023);
        Supra supra = new Supra("Toyota","J29","Grafite",2023);
        Corvette corvette = new Corvette("Chevrolet","ZR1","Amarelo",2019);

        civic.ligarCarro();
        corvette.ligarCarro();
        supra.ligarCarro();

        List<Cars> carros =new ArrayList<>();
        carros.add(civic);
        carros.add(supra);
        carros.add(corvette);

        for (Cars carro : carros){
            carro.desligarCarro();
        }


    }
}