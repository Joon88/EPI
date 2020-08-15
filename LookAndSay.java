class LookAndSay{
  public static void main(String args[]){
    System.out.println(solve(5));
  }

  static String solve(int n){
    String s = "1";
    while(n > 0){
      char[] c = s.toCharArray();
      int ctr = 0;
      s = "";
      while(ctr < c.length){
        char ch = c[ctr];
        int count = 0;
        //ctr++;
        while(ctr < c.length && c[ctr] == ch){
          count++;
          ctr++;
        }
        s += String.valueOf(count) + ch;
        System.out.println(s);
      }
      n--;
    }
    return s;
  }
}
