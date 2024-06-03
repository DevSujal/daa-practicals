import java.util.Arrays;
import java.util.Scanner;

public class hamiltoncycle {
    // Hamiltonian Cycle -> 
    public static void hCycle(int k, int n, int[][] G, int[] x){
        while (true) {
            nextValue(k, n, G, x);

            if(x[k] == 0){
                return;
            }
            if(k == (n-1)){
                System.out.println(Arrays.toString(x));
            }else{
                hCycle(k+1, n, G, x);
            }
        }
    }

    public static void nextValue(int k, int n, int[][] G, int[] x){
        while (true) {
            x[k] = (x[k] + 1) % (n + 1);

            // try {
            //     System.out.println(Arrays.toString(x));
            //     Thread.sleep(1000);
            // } catch (Exception e) {
            //     // TODO: handle exception
            // }
            if(x[k] == 0){
                return;
            }
            int j = 0;
            if(k != 0 && G[x[k-1]-1][x[k]-1] != 0){
                for (j = 0; j < k; j++) {
                    if(x[j] == x[k]){
                        break;
                    }
                }
            }
            if(j == k){
                if(k < (n-1) || k == (n-1) && G[x[0]-1][x[k]-1] != 0)
                    return;
            }
        }
    }
    public static void main(String[] args) {
        int G[][] = {
            {0, 1, 1, 0, 0, 0, 1, 0},
            {1, 0, 1, 0, 0, 0, 0, 1},
            {1, 1, 0, 1, 0, 1, 0, 0},
            {0, 0, 1, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 1, 0, 1, 0, 1, 0},
            {1, 0, 0, 0, 0, 1, 0, 1},
            {0, 1, 0, 0, 0, 0, 1, 0},
        };
        hCycle(0, G.length, G, new int[G.length]);
    }
}
