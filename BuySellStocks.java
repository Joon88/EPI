
public class BuySellStocks{
  public static void main(String args[]){

    int[] a = {12,11,13,9,12,8,14,13,15};
    int last = a.length-1;
    int lProfit = 0, rProfit = 0, min = a[0], max = a[last];
    int[] lp = new int[a.length];
    int[] rp = new int[a.length];
    lp[0] = 0;
    rp[last] = 0;

    for(int i=1; i<a.length; i++){
      if(a[i] <= min){
        min = a[i];
        lp[i] = lProfit;
      } else{
        lProfit = Math.max(lProfit, a[i]-min);
        lp[i] = lProfit;
      }

      if(a[last-i] >= max){
        max = a[last-i];
        rp[last-i] = rProfit;
      } else{
        rProfit = Math.max(rProfit, max-a[last-i]);
        rp[last-i] = rProfit;
      }
    }
    int maxProfit = 0;
    for(int i = 0 ; i < a.length-1 ; i++){
      maxProfit = Math.max(maxProfit, lp[i]+rp[i+1]);
    }
    System.out.println(maxProfit);
  }
}
