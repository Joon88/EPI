class IntToSprdCode{
  public static void main(String args[]){
    // starts with 1
    System.out.println(encode(27));
    // starts with 0
    System.out.println(decode("ZZ"));
  }

  private static String encode(int x){
    StringBuilder sb = new StringBuilder();
    while(x > 0){
      x--;
      char c = (char)(x%26 + 'A');
      sb.append(c);
      x = x/26;
    }
    return sb.reverse().toString();
  }

  public static int decode(String col) {
		int result = 0;
		for (int i = 0; i < col.length() ; i++) {
			char c = col.charAt(i) ;
			//result = (result+1)*26 + c - 'A';
			result = (result)*26 + c - 'A' + 1;
		}
		return result-1;
		}
}
