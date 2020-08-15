import java.util.Deque;
import java.util.LinkedList;
class PolishEval {
  public static void main(String args[]){
    System.out.println(solve("+4-*325"));
  }

  private static int solve(String expr){
    char[] e = expr.toCharArray();
    Deque<Integer> stack = new LinkedList<>();
    for(int i = e.length - 1 ; i >= 0 ; i--){
      if(!Character.isDigit(e[i])){
        int op1 = stack.poll();
        int op2 = stack.poll();

        switch(e[i]) {
          case '+':
            stack.addFirst(op1 + op2);
            break;
          case '-':
            stack.addFirst(op1 - op2);
            break;
          case '*':
            stack.addFirst(op1 * op2);
            break;
          case '/':
            stack.addFirst(op1 / op2);
            break;
          case '^':
            stack.addFirst((int)Math.pow(op1, op2));
            break;
          default:
            throw new IllegalArgumentException("wrong argument passed");
        }
      } else{
        stack.addFirst(e[i]-'0');
      }
    }
    return stack.poll();
  }
}
