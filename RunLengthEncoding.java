class RunLengthEncoding{
  public static void main(String args[]){
    String encoded = encode("aaaabcccaa");
    String decoded = decode(encoded);
    System.out.println(encoded + " ----- " + decoded);
  }

  private static String decode(String s){
    StringBuilder sb = new StringBuilder();
    int ctr = 0;
    for(int i = 0 ; i < s.length() ; i++){
      if(Character.isDigit(s.charAt(i))){
        ctr = ctr*10 + (s.charAt(i)-'0');
      } else{
        for(int j = 0 ; j < ctr ; j++){
          sb.append(s.charAt(i));
        }
        ctr = 0;
      }
    }
    return sb.toString();
  }

  private static String encode(String s){
    char ch = s.charAt(0);
    int ctr = 1;
    StringBuilder sb = new StringBuilder();
    for(int i = 1 ; i < s.length() ; i++){
      if(s.charAt(i) == ch){
        ctr++;
      } else{
        sb.append(ctr);
        sb.append(ch);
        ctr = 1;
        ch = s.charAt(i);
      }
    }
    sb.append(ctr);
    sb.append(ch);
    return sb.toString();
  }
}
