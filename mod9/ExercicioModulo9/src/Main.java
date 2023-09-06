import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Digite um número inteiro: ");
        int num1 = s.nextInt();
        Integer num2=num1;
        System.out.println("Você digitou o número: "+num2);
    }
}