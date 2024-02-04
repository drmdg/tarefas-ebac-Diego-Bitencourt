public class FatTopDownDin {

    private static final int MAXELEMENTOS = 100;
    private static final long[] elementosfat = new long[MAXELEMENTOS];
    public static long calculaFatorialPD(int n){
        for(int i = 0; i < MAXELEMENTOS; i++){
            elementosfat[i] = -1;
        }

        return calculaFatorial(n);
    }
    public static long calculaFatorial(int n){
        if(elementosfat[n] == -1){
            if (n == 1 || n == 0){
                elementosfat[n] = 1;
            } else {
                elementosfat[n] = calculaFatorial(n - 1) * n;
            }
        }
        return elementosfat[n];
    }

    public static void main(String[] args) {
        System.out.println(calculaFatorialPD(7));
    }
}



