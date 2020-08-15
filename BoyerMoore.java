import java.util.*;
// Here I've only used the bad character heuristic, but good suffix heuristic can also be used
class BoyerMoore{
  public static void main(String args[]){
    String string = "thst is a test";
    String pattern = "test";
    solve(string, pattern);
  }

  static void solve(String string, String pattern){
    Map<Character, Integer> badCharTable = createBadCharTable(pattern);

    int shifts = 0, m = string.length(), n = pattern.length();
    while(shifts <= (m-n)){
      int j = n-1;

      while(j >= 0 && string.charAt(shifts+j) == pattern.charAt(j)){
        j--;
      }

      if(j < 0){
        System.out.println("Found at index : " + shifts);
        if(shifts+n < m){
          int badCharTableValue = badCharTable.containsKey(string.charAt(shifts+n)) ? badCharTable.get(string.charAt(shifts+n)) : -1;
          shifts += n-badCharTableValue;
        } else
          shifts += 1;
      } else {
        int badCharTableValue = badCharTable.containsKey(string.charAt(shifts+j)) ? badCharTable.get(string.charAt(shifts+j)) : -1;
        shifts += Math.max(1, j-badCharTableValue);
      }
    }
  }

  static Map<Character, Integer> createBadCharTable(String pattern){
    Map<Character, Integer> map = new HashMap<>();
    for(int i = 0 ; i < pattern.length() ; i++){
      map.put(pattern.charAt(i), i);
    }
    return map;
  }
}
