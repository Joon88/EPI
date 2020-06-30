// Bitwise multiply without using the multiplication aperator
public class BitwiseMultiply{
  public static void main(String args[]){
    System.out.println(multiply(12,11));
    //System.out.println(add(51,14));
  }

  public static long multiply(long x, long y){
    long rslt = 0;
    int ctr = 0;
    while(y != 0){
      if((y&1) == 1){
        rslt = add(rslt, x);
      }
      x = x << 1;
      y = y >>> 1;
    }
    return rslt;
  }
  // this is a full adder, sum = P^Q^R and carry = PQ+QR+RP
  private static long add(long a, long b){
    long sum = 0;
    long carry = 0;
    long mask = 1;
    long tempA = a;
    long tempB = b;
    while(tempA != 0 || tempB != 0){
      long p = a&mask;
      long q = b&mask;
      sum = sum | (p^q^carry);
      carry = p&q | p&carry | carry&q;
      carry <<= 1;
      mask <<= 1;
      tempA <<= 1;
      tempB <<= 1;
    }
    return (sum | carry);
  }
}
