public class FatBottomUpDin {

    private static final int MAXELEMENTOS = 100;
    private static final long[] elementosfat = new long[MAXELEMENTOS];

    public static long calculaFatorialBottomUp(int n) {
        elementosfat[0] = 1;

        for (int i = 1; i <= n; i++) {
            elementosfat[i] = elementosfat[i - 1] * i;
        }

        return elementosfat[n];
    }

    public static void main(String[] args) {
        System.out.println(calculaFatorialBottomUp(7));
    }
}
