class TestPalindromicity{
  public static void main(String args[]){
    System.out.println(solve("A man, a plan, a canal, Panama."));
  }

  static boolean solve(String s){
    char[] c = s.toCharArray();
    int i = 0, j = c.length-1;
    while(i<=j){
      if(!Character.isLetterOrDigit(c[i])){
        i++;
        continue;
      }
      if(!Character.isLetterOrDigit(c[j])){
        j--;
        continue;
      }
      if(Character.toLowerCase(c[i]) != Character.toLowerCase(c[j])){
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}
