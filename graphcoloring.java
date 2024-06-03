import java.util.*;
public class graphcoloring {
    // Graph Coloring
    public static boolean mcolor(int k, int n, int[] x, int[][] g, int m){
        boolean isprinted = false;
        while (true) {
            nextValue(k, n, x, g, m);
            if(x[k] == 0){
                return isprinted;
            }
            if(k == (n-1)){
                System.out.println("ans = " + Arrays.toString(x));
                isprinted = true;
            }else{
                isprinted = mcolor(k+1, n, x, g, m);
            }
        }
    }

    public static void nextValue(int k,int n, int[] x, int[][]g, int m){
        while (true){
            x[k] = (x[k] + 1) % (m + 1);
            if(x[k] == 0){
                return;
            }
            int i = 0;
            for (i = 0; i < n; i++) {
                if(g[k][i] != 0 && i != k && x[k] == x[i]){
                    break;
                }
            }
            if(i == n){
                return;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("enter the number of colors : ");
            int m = sc.nextInt();
           
            // int g[][] = new int[][]{
            //     {1, 1, 1, 1, 1},
            //     {1, 1, 1, 1, 1},
            //     {1, 1, 1, 1, 1},
            //     {1, 1, 1, 1, 1},
            //     {1, 1, 1, 1, 1},
            // };
            // int g[][] = new int[][]{
            //     {0, 1, 0, 1},
            //     {1, 0, 1, 0},
            //     {0, 1, 0, 1},
            //     {1, 0, 1, 0},
            // };
            int g[][] = {
                    {0, 1, 1, 0, 1, 1},
                    {1, 0, 1, 0, 0, 0},
                    {1, 0, 0, 1, 0, 0},
                    {0, 0, 1, 0, 1, 0},
                    {1, 0, 0, 1, 0, 1},
                    {1, 0, 0 ,0, 1, 0}
            };
            int n = g.length;
            int x[] = new int[n];
            if(mcolor(0, n, x, g, m)){
                break;
            }else{
                System.out.println("insufficient colors");
            }
        }
        sc.close();
    }
}