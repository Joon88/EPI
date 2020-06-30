import java.util.Arrays;
public class DelDuplicatesFromSortedArr{
  public static void main(String args[]){
    int arr[] = {0,0,0,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,5,5,5,6};
    //solve(arr);
    variant2(arr, 3);
    System.out.println(Arrays.toString(arr));
  }

  private static void solve(int[] a){
    int elt = a[0];
    int i = 0;
    for(int j = 1 ; j < a.length ; j++){
      if(a[j] > elt){
        elt = a[j];
        a[++i] = a[j];
      }
    }
    System.out.println("Number of elements in final array : " + (i+1));
  }
/*
  private static void variant2(int[] a, int m){
    int elt = a[0], i = 0, eltCount = 1, tmp = 0;
    for(int j = 1 ; j < a.length ; j++){
      if((eltCount >= 2 && a[j] == elt)){
        eltCount++;
        continue;
      }
      if(elt == a[j]){
        eltCount++;
      } else if(a[j] > elt){
         if(eltCount != m){
            for(int k = 1; k <= (eltCount-2) ; k++)
              a[++i] = elt;
         }
         elt = a[j];
         eltCount = 1;
      }
      i++;
      tmp = a[i];
      a[i] = a[j];
      a[j] = tmp;
    }
  }
*/
  private static void variant2(int[] a, int m){
    int elt = a[0], i = 0, eltCount = 1, tmp = 0;
    for(int j = 1 ; j < a.length ; j++){
      if((eltCount >= 2 && a[j] == elt)){
        eltCount++;
        //i++;
        //continue;
      } else if(elt == a[j]){
        eltCount++;
      } else if(a[j] > elt){
         if(eltCount == m){
            i -= (eltCount-2);
         }
         elt = a[j];
         eltCount = 1;
      }
      i++;
      tmp = a[i];
      a[i] = a[j];
      a[j] = tmp;
    }
  }
}
