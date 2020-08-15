class ComputeAllValidIPs{
  public static void main(String args[]){
    solve("19216811");
  }

  private static void solve(String s){
    for(int i = 1 ; i < 4 && i < s.length() ; i++){
      String first = s.substring(0, i);
      if(!isValid(first))
        continue;
      for(int j = i+1 ; j < i+4 && j < s.length() ; j++){
        String second = s.substring(i, j);
        if(!isValid(second))
          continue;
        for(int k = j+1 ; k < j+4 && k < s.length() ; k++){
          String third = s.substring(j, k);
          String fourth = s.substring(k);
          if(!isValid(third) || !isValid(fourth))
            continue;
          System.out.println(first + "." + second + "." + third + "." + fourth);
        }
      }
    }
  }

  private static boolean isValid(String s){
    if(s.length() > 3)
      return false;
    int val = Integer.parseInt(s);
    if(s.startsWith("0") && val > 0)
      return false;
    if(val > 255 || val < 0)
      return false;
    return true;
  }
}
