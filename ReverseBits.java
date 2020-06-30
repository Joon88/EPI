public class ReverseBits {
  public static void main(String args[]){
    System.out.println(reverseBits((long)(Math.pow(2, 62) + 432435)));
  }

  public static long reverseBits(long x){
    long rslt = 0;
    for(int i = 0 ; i < 64 ; i++){
      rslt = rslt << 1;
      rslt += (x&1);
      x = x >>> 1;
    }
    return rslt;
  }
}
