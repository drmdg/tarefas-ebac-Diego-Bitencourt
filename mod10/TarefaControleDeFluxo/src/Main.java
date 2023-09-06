import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Double primeiraNota,segundaNota,terceiraNota,quartaNota;

        System.out.println("Digite a primeira nota do aluno: ");
        primeiraNota = scanner.nextDouble();

        System.out.println("Digite a segunda nota do aluno: ");
        segundaNota = scanner.nextDouble();

        System.out.println("Digite a terceira nota do aluno: ");
        terceiraNota = scanner.nextDouble();

        System.out.println("Digite a quarta nota do aluno: ");
        quartaNota = scanner.nextDouble();

        Double media = calcularMedia(primeiraNota,segundaNota,terceiraNota,quartaNota);
        System.out.println("A média do aluno foi: "+media);

        verificarAprovacao(media);

    }

    private static void verificarAprovacao(Double media) {
        if (media >= 7){
            System.out.println("Aluno aprovado!");
        }else if(media >= 5){
            System.out.println("Aluno em recuperação!");
        }else {
            System.out.println("Aluno reprovado!");
        }
    }

    private static Double calcularMedia(Double primeiraNota,Double segundaNota,Double terceiraNota,Double quartaNota) {
        return (primeiraNota+segundaNota+terceiraNota+quartaNota)/4;
    }


}