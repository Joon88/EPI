public class StrIntConv{
  public static void main(String args[]){
    System.out.println(stringToInt("-2123"));
    System.out.println(intToStr(4342));
  }

  private static int stringToInt(String s){
    int num = 0;
    for(int i = (s.charAt(0) == '-' ? 1 : 0); i < s.length() ; i++){
      num = num*10 + (s.charAt(i) - '0');
    }
    if(s.charAt(0) == '-')
      return -1*num;
    return num;
  }

  private static String intToStr(int y){
    StringBuilder s = new StringBuilder();
    int x = Math.abs(y);
    while(x > 0){
      s.append(x%10);
      x /= 10;
    }
    if(y < 0){
      s.append('-');
    }
    return s.reverse().toString();
  }
}
