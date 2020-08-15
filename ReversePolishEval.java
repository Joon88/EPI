import java.util.Stack;
class ReversePolishEval {
  public static void main(String args[]){
    System.out.println(solve("3,4,+,2,*,1,+"));
  }

  public static int solve(String expr){
    String[] splitExpr = expr.split(",");
    Stack<Integer> stack = new Stack<>();

    for(String token : splitExpr){
      if(token.length() == 1 && "+-*/^".contains(token)){
        int op2 = stack.pop();
        int op1 = stack.pop();

        switch(token) {
          case "+":
            stack.push(op1 + op2);
            break;
          case "-":
            stack.push(op1 - op2);
            break;
          case "*":
            stack.push(op1 * op2);
            break;
          case "/":
            stack.push(op1 / op2);
            break;
          case "^":
            stack.push((int)Math.pow(op1, op2));
            break;
          default:
            throw new IllegalArgumentException("Illegal operator passed");
        }
      } else{
        stack.push(Integer.parseInt(token));
      }
    }
    return stack.pop();
  }
}
