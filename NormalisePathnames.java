import java.util.Stack;
class NormalisePathnames {
  public static void main(String args[]){
    System.out.println(solve("scripts//./../scripts/awkscripts/././"));
  }

  static String solve(String path){
    boolean fromRoot = path.startsWith("/");
    if(fromRoot)
      path = path.substring(1);
    int depthCtr = 0;
    Stack<String> stack = new Stack<>();
    String[] pathArr = path.split("/");
    for(String x : pathArr){
      if(x.equals(".") || x.length() == 0)
        continue;
      else if(x.equals("..") && !stack.isEmpty())
        stack.pop();
      else if(x.equals("..") && !fromRoot)
        depthCtr++;
      else if(x.equals(".."))
        throw new IllegalArgumentException();
      else if(depthCtr > 0)
        depthCtr--;
      else
        stack.push(x);
    }

    StringBuilder sb = new StringBuilder();
    for(String s : stack){
      sb.append(s + "/");
    }
    if(fromRoot)
      sb.insert(0, "/");
    sb.deleteCharAt(sb.length()-1);
    return sb.toString();
  }
}
