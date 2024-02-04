public class Fatorial {

    public static long calculaFatorial(long n){
        if (n==1 || n==0){
            return 1;
        }
        return calculaFatorial(n-1)*n;
    }

    public static void main(String[] args) {
        System.out.println(calculaFatorial(7));
    }
}
