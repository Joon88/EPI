class ReplaceAndRemove{
  public static void main(String args[]){
    char[] c = {'a', 'c', 'a', 'a', ' ', ' ', ' '};
    System.out.println(solve(4, c));
  }

  public static String solve(int s, char[] c){
    int ctrA = 0, idx = 0;
    for(int i = 0 ; i < s ; i++){
      if(c[i] != 'b'){
        c[idx++] = c[i];
      }
      if(c[i] == 'a')
        ctrA++;
    }
    int newIdx = idx + ctrA - 1;
    for(int i = idx-1 ; i >= 0 ; i--){
      if(c[i] == 'a'){
        c[newIdx--] = 'd';
        c[newIdx] = 'd';
      } else
        c[newIdx] = c[i];
      newIdx--;
    }
    return String.valueOf(c);
  }
}
