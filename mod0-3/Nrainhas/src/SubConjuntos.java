import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubConjuntos {


    public static List<List<Integer>> calcularSubconjuntos(List<Integer> conjuntoOriginal, int tamanhoDosSubconjuntos){
        List<List<Integer>> resultado = new ArrayList<>();
        gerarSubconjuntos(conjuntoOriginal,tamanhoDosSubconjuntos,0,new ArrayList<>(),resultado);
        return resultado;

    }

    private static void gerarSubconjuntos(List<Integer> conjuntoOriginal,int tamanhoDosSubconjuntos,int indice,List<Integer> subconjuntoAtual,List<List<Integer>> result) {
        if(subconjuntoAtual.size() == tamanhoDosSubconjuntos){
            result.add(new ArrayList<>(subconjuntoAtual));
            return;
        }
        for (int i = indice; i < conjuntoOriginal.size(); i++) {
            subconjuntoAtual.add(conjuntoOriginal.get(i));
            gerarSubconjuntos(conjuntoOriginal, tamanhoDosSubconjuntos, i + 1, subconjuntoAtual, result);
            subconjuntoAtual.remove(subconjuntoAtual.size() - 1);
        }

    }

    public static void main(String[] args) {
        List<Integer> conjuntoOriginal = Arrays.asList(1, 2, 3,4,5,6,7,8);
        int tamanhoDosSubconjuntos = 2;

        List<List<Integer>> resultado = calcularSubconjuntos(conjuntoOriginal, tamanhoDosSubconjuntos);

        for (List<Integer> subconjunto : resultado) {
            System.out.println(subconjunto);
        }
    }
}
