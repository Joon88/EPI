import java.util.Arrays;
public class Sort1234{
  public static void main(String args[]){
    int a[] = {1,4,2,3,4,3,2,1};
    sort(a);
    System.out.println(Arrays.toString(a));
  }

  public static void sort(int[] a){
    int i = 0, j = 0, k = a.length-1, l = a.length-1, tmp;
    while(j<=k){
      if(a[j] == 1){
        tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
        i++;
        j++;
      } else if(a[j] == 2){
        j++;
      } else if(a[j] == 3){
        tmp = a[j];
        a[j] = a[k];
        a[k] = tmp;
        k--;
      } else{
        tmp = a[j];
        a[j] = a[k];
        a[k] = a[l];
        a[l] = tmp;
        k--;
        l--;
      }
    }
  }
}
