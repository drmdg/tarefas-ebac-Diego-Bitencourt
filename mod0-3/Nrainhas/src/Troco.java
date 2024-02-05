import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;


public class Troco {


    public static String calcularTroco(int[] moedasDisponiveis, int troco ){
        int index=moedasDisponiveis.length-1;
        int[] numeroDeMoedas = {0,0,0};

       while(troco > 0){
           if(troco-moedasDisponiveis[index]>=0){
               troco=troco-moedasDisponiveis[index];
               numeroDeMoedas[index]++;
           }else {
               index--;
           }
       }
       return "numero de moedas 5=> "+numeroDeMoedas[2]+"   numero de moedas 2=> "+numeroDeMoedas[1]+"   numero de moedas 1=> "+numeroDeMoedas[0];
    }

    public static void main(String[] args) {
        int[] moedasDisponiveis = {5,2,1};
        Arrays.sort(moedasDisponiveis);
        int troco = 18;

        System.out.println(calcularTroco(moedasDisponiveis,troco));

    }
}
