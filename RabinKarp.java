class RabinKarp{
  final static int PRIME = 101;
  public static void main(String args[]){
    String string = "GACGCCA";
    String substring = "GCCs";
    System.out.println(solve(string, substring));
  }

  static int solve(String s, String ss){
    int ssIdx = -1;
    if(ss.length() > s.length())
      return ssIdx;
    int ssHash = getHash(ss);
    int slidingWindowHash = 0;
    for(int i = 0 , j = ss.length()-1 ; j < s.length() ; j++, i++){
      if(i == 0)
        slidingWindowHash = getHash(s.substring(i,j+1));
      else{
        slidingWindowHash -= s.charAt(i-1);
        slidingWindowHash /= PRIME;
        slidingWindowHash += s.charAt(j)*(int)Math.pow(PRIME, ss.length()-1);
      }
      if(slidingWindowHash == ssHash){
        boolean match = true;
        for(int k = 0 ; k < ss.length() ; k++){
          if(s.charAt(i+k) != ss.charAt(k)){
            match = false;
            break;
          }
        }
        if(match){
          ssIdx = i;
          break;
        }
      }
    }
    return ssIdx;
  }

  private static int getHash(String s){
    int hash = 0;
    for(int i = 0 ; i < s.length() ; i++){
      hash += s.charAt(i)*(int)Math.pow(PRIME, i);
    }
    return hash;
  }
}
