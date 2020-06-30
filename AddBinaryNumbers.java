import java.lang.StringBuilder;
import java.util.Arrays;
public class AddBinaryNumbers{
  public static void main(String args[]){
    System.out.println(add("101101","111111"));
  }

  private static String add(String x, String y){
    int c1[] = new int[x.length()];
    int c2[] = new int[y.length()];

    int i = 0;
    for(char c : x.toCharArray()){
      c1[i++] = c-'0';
    }

    i = 0;
    for(char c : y.toCharArray()){
      c2[i++] = c-'0';
    }

    int[] c = x.length() > y.length() ? c1 : c2;
    int n = x.length() > y.length() ? y.length() : x.length();
    int carry = 0;
    for(i = 1 ; i <= n ; i++){
      int p = c1[c1.length - i], q = c2[c2.length - i];
      c[c.length - i] = p ^ q ^ carry;
      carry = p&q | p&carry | carry&q;
    }
    i = c.length - n - 1;
    while(i >= 0){
      int p = c[i];
      c[i] = p^carry;
      carry = p&carry;
      i--;
    }
    StringBuilder sb = new StringBuilder();
    for(int a : c){
      sb.append(a);
    }
    String rslt = sb.toString();
    if(carry > 0){
      rslt = carry + rslt;
    }
    return rslt;
  }
}
