import java.util.*;
class KMP{
  public static void main(String args[]){
    String string = "acacabcacabacacacbbacacabacacabacacacacacaccbacacabacacaacacaccc";
    String pattern = "acacabacacabacacac";
    System.out.println(solve(string, pattern));
  }

  static boolean solve(String str, String pattern){
    int[] prefixArr = new int[pattern.length()];
    for(int i = 1, j = 0 ; i < pattern.length() ; ){
      if(pattern.charAt(i) == pattern.charAt(j)){
        prefixArr[i] = j+1;
        i++;
        j++;
      } else if(j == 0){
        prefixArr[i] = 0;
        i++;
      } else{
        j = prefixArr[j-1];
      }
      System.out.println(Arrays.toString(prefixArr));
    }
    System.out.println(Arrays.toString(prefixArr));
    int j = 0;
    for(int i = 0 ; i < str.length() && j < pattern.length() ; ){
      if(str.charAt(i) != pattern.charAt(j)){
        if(j > 0)
          j = prefixArr[j-1];
        else
          i++;
      } else{
        i++;
        j++;
      }
    }
    if(j == pattern.length()){
      return true;
    }
    return false;
  }
}
