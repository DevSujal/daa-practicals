import java.util.Arrays;
class Lcs {
    // Longest Common Subsequence
     static class elements {
        char dir;
        int val;
        elements(char dir, int val){
            this.dir = dir;
            this.val = val;
        }
        public String toString(){
            return val + "/" + dir;
        }
    }

    public static elements[][] lcs(String s1, String s2){
        s1 = " " + s1;
        s2 = " " + s2;
        int m = s1.length();
        int n = s2.length();
        elements c[][] = new elements[m][n];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                c[i][j] = new elements('H',0);
            }
        }
        for (int i = 1; i < m; i++) {
           for (int j = 1; j < n; j++) {

            if(s1.charAt(i) == s2.charAt(j)) {
                c[i][j].val = c[i - 1][j - 1].val + 1;
                c[i][j].dir = 'D';
            }else{
                if(c[i-1][j].val >= c[i][j-1].val){
                    c[i][j].val = c[i - 1][j].val;
                    c[i][j].dir = 'U';
                }else{
                    c[i][j].val = c[i][j-1].val;
                    c[i][j].dir = 'S';
                }
            }
           } 
        }
        return c;
    }
    
    public static void printLCS(elements a[][], String s1, int m, int n){
        if(m == 0 || n == 0){
            return;
        }

        if(a[m][n].dir == 'D'){
            printLCS(a, s1, m-1, n-1);
            System.out.print(s1.charAt(m));
        }else{
            if(a[m][n].dir == 'U'){
                printLCS(a, s1, m-1, n);
            }else{
                printLCS(a, s1, m, n-1);
            }
        }
    }
    public static void main(String[] args) {
        
        String s1 = "GDVEGTA";
        String s2 = "GVCEKST";

        elements c[][] = lcs(s1, s2);

        for (elements[] elements : c) {
            System.out.println(Arrays.toString(elements));
        }
        printLCS(c, " " + s1, s1.length(), s2.length());
    }
}