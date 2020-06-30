public class ArrayAdvance{
  public static void main(String args[]){
    int[] arr = {3,3,1,0,3,0,1};

    System.out.println(solve(arr));
    System.out.println(minSteps(arr));

  }

  private static boolean solve(int[] a){
    int closestPositive = a.length-1;
    for(int i = a.length-2 ; i>=0 ;i--){
      if(a[i] >= closestPositive-i){
        closestPositive = i;
      }
    }
    if(closestPositive == 0){
      return true;
    }
    return false;
  }

  private static int minSteps(int[] a){
    int farthest = a[0];
    int tmpFarthest = farthest;
    int ctr = 0;
    for(int i = 1 ; i <= farthest && farthest < a.length-1 ; i++){
      tmpFarthest = Math.max(tmpFarthest, a[i] + i);
      if(i == farthest && tmpFarthest > farthest){
        ctr++;
        farthest = tmpFarthest;
      }
    }
    if(farthest >= a.length-1)
      return ctr+1;
    return 0;
  }
}
