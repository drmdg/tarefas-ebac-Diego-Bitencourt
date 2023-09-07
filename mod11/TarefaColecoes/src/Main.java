import java.util.*;

public class Main {
    public static void main(String[] args) {


        nomePessoasComVirgula();
        nomePessoasComVirgulaESexo();


    }

    private static void nomePessoasComVirgulaESexo() {

        Scanner scanner = new Scanner(System.in);
        List<Pessoa> listaNomesMasculino = new ArrayList<Pessoa>();
        List<Pessoa> listaNomesFeminino = new ArrayList<Pessoa>();
        System.out.println("Entre com nomes de pessoas e o seu respectivo sexo");
        System.out.println("Exemplo => Diego-M,Maria-F,Marcos-M");
        String nomesPessoasESexo = scanner.nextLine();

        String[] pessoaSexo=nomesPessoasESexo.split(",");

        for (int i=0;i<pessoaSexo.length;i++){
            String[] especifico = pessoaSexo[i].split("-");
            if (especifico[1].equalsIgnoreCase("m")){
                Pessoa pessoa = new Pessoa(especifico[0],especifico[1]);
                listaNomesMasculino.add(pessoa);
            }else {
                Pessoa pessoa = new Pessoa(especifico[0],especifico[1]);
                listaNomesFeminino.add(pessoa);
            }
        }

        Collections.sort(listaNomesFeminino);
        Collections.sort(listaNomesMasculino);

        System.out.println("**** Pessoas do Sexo Masculino ****");
        System.out.println(listaNomesMasculino);
        System.out.println("**** Pessoas do Sexo Feminino ****");
        System.out.println(listaNomesFeminino);
    }

    /**
     * Não preciso usar o sort, pois o TreeSet já armazena os dados de forma ordenada.
     */
    private static void nomePessoasComVirgula() {
        Scanner scanner = new Scanner(System.in);
        Set<String> listaNomes = new TreeSet<String>();
        String[] stringNomes;

        System.out.println("Entre com nomes de pessoas separando por virgula");
        System.out.println("Exemplo => Diego,Marcos,Maria");

        String nomesPessoas = scanner.nextLine();
        stringNomes=nomesPessoas.split(",");

        for(int i=0;i< stringNomes.length;i++){
            listaNomes.add(stringNomes[i]);
        }

        System.out.println(listaNomes);


    }
}