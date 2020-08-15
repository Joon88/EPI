class ReverseAllWordsInSentence{
  public static void main(String args[]){
    char[] c = "Alice likes Bob".toCharArray();
    solve(c);
    System.out.println(String.valueOf(c));
  }

  static void solve(char[] c){
    reverse(c, 0, c.length-1);
    int i = -1, j = 0;
    while(i < c.length){
      if(j == c.length || Character.isWhitespace(c[j])){
        reverse(c, i+1, j-1);
        i = j;
      }
      j++;
    }
  }

  static void reverse(char[] c, int beg, int end){
    for(int i = beg; i < beg+((end-beg+1)/2); i++){
      char tmp = c[i];
      c[i] = c[end-i+beg];
      c[end-i+beg] = tmp;
    }
  }
}
