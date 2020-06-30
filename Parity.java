
public class Parity {
  public static void main(String args[]){
    findParity(7);
    getParity(7);
  }
  // O(log n) where n - word size
  public static void findParity(long x){
    x ^= x >>> 32;
    x ^= x >>> 16;
    x ^= x >>> 8;
    x ^= x >>> 4;
    x ^= x >>> 2;
    x ^= x >>> 1;

    System.out.println("Parity : " + (x&1));
  }

  // O(number od 1s in the word)
  public static void getParity(long x){
    int rslt = 0;
    while(x != 0){
      x = x & (x-1);
      rslt ^= 1;
    }

    System.out.println("Parity : " + rslt);
  }
}
