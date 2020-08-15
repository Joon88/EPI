import java.util.*;
class PhNoMnemonics{
  public static void main(String args[]){
    char[] c = "2276696".toCharArray();
    Map<Character, char[]> m = new HashMap<>();
    m.put('2', "ABC".toCharArray());
    m.put('7', "PQRS".toCharArray());
    m.put('6', "MNO".toCharArray());
    m.put('9', "WXYZ".toCharArray());
    solve(c, 0, "", m);
  }

  static void solve(char[] c, int i, String ans, Map<Character, char[]> map){
    if(i == c.length){
      System.out.println(ans);
      return;
    }
    for(char ch : map.get(c[i])){
      solve(c, i+1, ans+ch, map);
    }
  }
}
