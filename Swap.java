
public class Swap {
  public static void main(String args[]){
    System.out.println(swapBits(11, 1, 6));
  }

  public static long swapBits(long x, int i, int j){
    if((x >>> i) != (x >>> j)){
      long mask = (1 << i) | (1 << j);
      x ^= mask;
    }
    return x;
  }
}
