import java.util.Arrays;
import java.util.Scanner;

public class BellmanFord {
    public static void main(String[] args) {
        // Bellman Ford Algorithm
        Scanner sc = new Scanner(System.in);
        int cost[][] = {
                { 999999, 6, 5, 5, 999999, 999999, 999999 },
                { 999999, 999999, 999999, 999999, -1, 999999, 999999 },
                { 999999, -2, 999999, 999999, 1, 999999, 999999 },
                { 999999, 999999, -2, 999999, 999999, -1, 999999 },
                { 999999, 999999, 999999, 999999, 999999, 999999, 3 },
                { 999999, 999999, 999999, 999999, 999999, 999999, 3 },
                { 999999, 999999, 999999, 999999, 999999, 999999, 999999 }
        };
        System.out.print("Enter the source vertex : ");
        int v = sc.nextInt() - 1;
        int dist[] = new int[cost.length];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = cost[v][i];
        }
        System.out.println("before applying bellman ford algorithm : " + Arrays.toString(dist));

        for (int k = 1; k < dist.length; k++) {
            for (int u = 0; u < dist.length; u++) {
                if (u != v) {
                    for (int i = 0; i < dist.length; i++) {

                        if (cost[i][u] != 999999) {
                            if (dist[u] > dist[i] + cost[i][u]) {
                                dist[u] = dist[i] + cost[i][u];
                            }
                        }
                    }
                }
            }
        }
        dist[v] = 0;
        System.out.println("After applying bellman ford algorithm : " + Arrays.toString(dist));
    }
}
