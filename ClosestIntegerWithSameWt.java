
public class ClosestIntegerWithSameWt {
  public static void main(String args[]){
    System.out.println(find(7));
  }

  public static long find(long x){
    if((x&1) == 0){
      long z = x&~(x-1);
      z = z >>> 1;
      return (x&(x-1) | z);
    }
    long z = ~x;
    long y = z&~(z-1);
    y = y | (y >>> 1);
    return x^y;
  }
}
