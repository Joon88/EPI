import java.util.*;
class BalancedParenthesis {
  public static void main(String args[]){
    System.out.println(solve("[()[]{()()}]"));
  }

  static boolean solve(String expr){
    Deque<Character> stack = new LinkedList<>();

    for(int i = 0 ; i < expr.length() ; i++){
      if(expr.charAt(i) == '(' || expr.charAt(i) == '[' || expr.charAt(i) == '{'){
        stack.addFirst(expr.charAt(i));
      } else if(stack.isEmpty()){
        return false;
      } else if(expr.charAt(i) == ')' && stack.peek() != '(' ||
                expr.charAt(i) == '}' && stack.peek() != '{' ||
                expr.charAt(i) == ']' && stack.peek() != '['){
        return false;
      } else{
        stack.pop();
      }
    }
    return stack.isEmpty();
  }
}
