import java.util.Arrays;
import java.util.Scanner;

public class maximumsumsubarray {
  public static int[] findcrosssum(int arr[], int l, int r, int mid, int m){
    // Maximum Sum Subarray -> 
    int cross = Integer.MIN_VALUE, left = mid+1,  leftsum = Integer.MIN_VALUE;
    int right = mid, rightsum = Integer.MIN_VALUE;
    int lower = mid, upper = mid;
    while (right <= r || left >= 0) {
        if(left-- > 0){
            leftsum += arr[left];
        }
        if(cross < leftsum && leftsum <= m){
            cross = leftsum;
            lower = left;
        }
        if(right++ < r){
            rightsum += arr[right];
        }
        if(cross < rightsum && rightsum <= m){
            cross = rightsum;
            upper = right;
        }

        if(cross < (leftsum + rightsum) && (leftsum + rightsum) <= m){
            cross = leftsum + rightsum;
            lower = left;
            upper = right;
        }
    }

    return new int[]{lower,  upper, cross};
  }
  public static int[] maxsumsubarray(int arr[], int l, int r, int maxResourceAllocation){
    if(l >= r){
      return new int[] {l, r, arr[l]};
    }
    int mid = l + ((r - l) >> 1);
    
    int a[] = maxsumsubarray(arr, l, mid,maxResourceAllocation);
    int b[] = maxsumsubarray(arr, mid+1, r,maxResourceAllocation);
    
    int c[] = findcrosssum(arr, l, r, mid,maxResourceAllocation);
    int ans[] = {0, 0, 0};
    System.out.println(Arrays.toString(a) + " " + Arrays.toString(b) + Arrays.toString(c));
   if(maxResourceAllocation >= a[2]){
     ans = a;
   }if(maxResourceAllocation >= b[2] && b[2] > ans[2] || ans[2] == 0){
     ans = b;
   }if(maxResourceAllocation >= c[2] && c[2] > ans[2] || ans[2] == 0){
     ans = c;
   }
   return ans;
  } 
    public static void main(String[] args) {
      Scanner sc= new Scanner(System.in);
      String s[] = sc.nextLine().split(" ");
      int arr[] = new int[s.length];
      int i = 0;
      for(String temp : s){
        arr[i++] = Integer.parseInt(temp);
      }
      int maxResourceAllocation = sc.nextInt();
      int ans[] = maxsumsubarray(arr, 0, arr.length-1, maxResourceAllocation);
      System.out.println(Arrays.toString(ans));
  }
}
