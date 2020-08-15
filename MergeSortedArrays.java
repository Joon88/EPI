import java.util.Arrays;
class MergeSortedArrays{
  public static void main(String args[]){
    int a[] = {1,3,5,-1,-1,-1, 1};
    int b[] = {2,4,8,9};
    solve(a, 3, b, 4);
    System.out.println(Arrays.toString(a));
  }
  public static void solve(int[] a, int m, int[] b, int n){
    int s = m+n;
    while(m-1 >= 0 && n-1 >= 0){
      if(a[m-1] > b[n-1]){
        a[s-1] = a[m-1];
        m--;
      } else{
        a[s-1] = b[n-1];
        n--;
      }
      s--;
    }
  }
}
