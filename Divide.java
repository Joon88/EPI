public class Divide {
  public static void main(String args[]){
    System.out.println(divide((long)Math.pow(2, 30), 1));
  }

  private static long divide(long x, long y){
    int ctr = 0, ctr1 = 0;
    long ty = y;
    while(x >= ty){
      ty = ty << 1;
      ctr++;
    }
    ty = ty >>> 1;
    ctr--;
    System.out.println(ctr);
    x = x-ty;
    ty = y;
    while(x >= ty){
      ctr1++;
      x -= ty;
    }
    System.out.println(ctr1);
    return ((long)Math.pow(2, ctr) + ctr1);
  }
}
