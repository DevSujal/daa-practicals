import java.util.Arrays;

public class StringEditing {
    // String Editing
    static class subscript {
        String opr;
        int val;
        subscript(String opr, int val){
            this.opr = opr;
            this.val = val;
        }
        public String toString(){
            return val + " / " + opr;
        }
    }

    public static subscript[][] lcs(String s1, String s2){
        s1 = " " + s1;
        s2 = " " + s2;
        if(s1.length() < s2.length()){
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }

        int m = s1.length();
        int n = s2.length();

        subscript c[][] = new subscript[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = new subscript("D",0);
            }
        }
        c[0][0].opr = "   ";

        for (int i = 1; i < c.length; i++) {
            c[i][0].val = i;
            c[i][0].opr = " D ";
        }
        for (int i = 1; i < c[0].length; i++) {
            c[0][i].val = i;
            c[0][i].opr = " I ";
        }
        for (int i = 1; i < m; i++) {
           for (int j = 1; j < n; j++) {
            if(s1.charAt(i) == s2.charAt(j)) {
                c[i][j].val = c[i-1][j-1].val;
                c[i][j].opr = " U ";
            }else{
                if((c[i][j-1].val + 1) == (c[i-1][j].val + 1) && (c[i-1][j].val + 1) == (c[i-1][j-1].val + 2)){
                    c[i][j].val = (c[i][j-1].val + 1);
                    c[i][j].opr = "IDU";
                }else if(i < j){
                    c[i][j].val = c[i][j - 1].val + 1;
                    c[i][j].opr = " I "; 
                }else{
                    c[i][j].val = c[i-1][j].val + 1;
                    c[i][j].opr = " D "; 
                }
            }
           } 
        }
        return c;
    }
    public static void main(String[] args) {
        subscript c[][] = lcs("BABB", "AABAB");
        for (subscript[] subscript : c) {
            System.out.println( Arrays.toString(subscript));
        }
        System.out.println();
    }
}
