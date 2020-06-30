class BaseConversion{
  public static void main(String args[]){
    System.out.println(baseConvert("101010111100", 2, 16));
  }

  private static String baseConvert(String str, int b1, int b2){
    // convert the number to base 10 first
    int num = 0;
    for(int i = 1 ; i <= str.length() ; i++){
      int n = 0;
      if(str.charAt(i-1) >= 'A'){
        n = str.charAt(i-1) - 'A' + 10;
      } else{
        n = str.charAt(i-1) - '0';
      }
      num = b1*num + n;
    }

    StringBuilder s = new StringBuilder();
    while(num > 0){
      int a = num%b2;
      char digit = '0';
      if(a >= 10){
        digit = (char)('A' + a%10);
      } else{
        digit = (char)(a+'0');
      }
      s.append(digit);
      num = num/b2;
    }
    return s.reverse().toString();
  }
}
