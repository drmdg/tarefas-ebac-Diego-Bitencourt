public class NRainhas {

    public static void main(String[] args) {
        int n = 8;
        resolveRainha(n);
    }

    public static void resolveRainha(int n){
        int[][] tab = new int[n][n];
        if (resolvidoRainha(tab,0,n)){
            imprime(tab);
        } else {
            System.out.println("Não há solução");
        }
    }

    private static boolean resolvidoRainha(int[][] tab, int col,int n){
        if (col == n){
            return true;
        }

        for (int i=0;i<n;i++){
            if(eSeguro(tab,i,col,n)){
                tab[i][col]=1;
                if (resolvidoRainha(tab, col+1, n)){
                    return true;
                }
                tab[i][col]=0;
            }
        }
        return false;
    }

    private static boolean eSeguro(int[][] tab,int linha,int coluna,int n){
        for (int i=0;i<coluna;i++){
            if (tab[linha][i]==1) {
                return false;
            }
        }
        for (int i = linha, j = coluna; i >= 0 && j >= 0; i--, j--) {
            if (tab[i][j] == 1) {
                return false;
            }
        }
        for (int i = linha, j = coluna; i < n && j >= 0; i++, j--) {
            if (tab[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private static void imprime(int[][] tab){
        int n = tab.length;
        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(tab[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
