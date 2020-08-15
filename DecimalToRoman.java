import java.util.*;
class DecimalToRoman{
  public static void main(String args[]){
    System.out.println(solve(0));
  }

  private static String solve(int n){
    StringBuilder sb = new StringBuilder();
    Map<Integer, Character> m = new HashMap<>();
    m.put(1000, 'M');
    m.put(500, 'D');
    m.put(100, 'C');
    m.put(50, 'L');
    m.put(10, 'X');
    m.put(5, 'V');
    m.put(1, 'I');
    for(int factor : new int[]{1000, 500, 100, 50, 10, 5, 1}){
      int x = n/factor;
      while(x > 0){
        sb.append(m.get(factor));
        n -= factor;
        x--;
      }
      int subtractFactor;
      if(factor == 1000 || factor == 500)
        subtractFactor = 100;
      else if(factor == 100 || factor == 50)
        subtractFactor = 10;
      else
        subtractFactor = 1;
      if(n > 0 && n >= factor-subtractFactor){
        sb.append(m.get(subtractFactor));
        sb.append(m.get(factor));
        n -= (factor - subtractFactor);
      }
    }
    return sb.toString();
  }
}
