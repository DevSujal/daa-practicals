import java.text.DecimalFormat;
import java.util.Arrays;

public class OBST {
    // Optimal Binary Search Tree
    private static final DecimalFormat decfor = new DecimalFormat("0.00");  
    public static void main(String[] args){
       double p[] = {0.00, 0.20, 0.05, 0.05, 0.10, 0.10};
       double q[] = {0.10, 0.05, 0.10, 0.05, 0.05,0.15};
       double w[][] = new double[p.length][p.length];
       double e[][] = new double[p.length][p.length];
       String r[][] = new String[p.length][p.length];

       for (int i = 0; i < q.length; i++) {
        e[i][i] = q[i];
        w[i][i] = q[i];
       }

       for (int i = 0; i < e.length; i++) {
        for (int j = i+1; j < e.length; j++) {
            w[i][j] = Double.parseDouble(decfor.format(w[i][j-1] + p[j] + q[j]));
        }
       }
       for (int x = 1; x < e.length; x++) {
        int i = 0, j = x;
        while (i < e.length && j < e.length) {
            double min = 9999;
            for(int k = i; k < j; k++){
                if(e[i][k]+e[k+1][j] < min){
                    min = e[i][k] + e[k+1][j];
                }
            }
            String s = "";
            for(int k = i; k < j; k++){
                if(e[i][k]+e[k+1][j] == min){
                    s += k + " ";
                }
            }
            
            r[i][j] = s.trim();
            e[i][j] =  Double.parseDouble(decfor.format(min + w[i][j]));
            i++;j++;
        }
       }

       System.out.println();
       System.out.println("w matrix -> ");
       for (double[] ds : w) {
           System.out.println(Arrays.toString(ds));
        }
        
        System.out.println();
        System.out.println("e matrix -> ");
       for (double[] ds : e) {
        System.out.println(Arrays.toString(ds));
       }
        System.out.println();
        System.out.println("r matrix -> ");
       for (String[] ds : r) {
        System.out.println(Arrays.toString(ds));
       }
    }
}
