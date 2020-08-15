import java.util.Stack;
import java.util.Collections;
import java.util.Arrays;
class InfixToPrefix {
  public static void main(String args[]){
    System.out.println(solve("A,+,(,B,/,C,-,(,D,*,E,^,F,),+,G,),*,H"));
  }

  private static String solve(String infix){
    String[] arr = infix.split(",");
    Collections.reverse(Arrays.asList(arr));
    StringBuffer prefix = new StringBuffer();
    Stack<String> stack = new Stack<>();

    for(String s : arr){
      System.out.println(stack);
      if(s.length() == 1 && "+-*/^)}]".contains(s)){
        switch(s){
          case "-":
          case "+":
            while(!stack.isEmpty() && !"+-)}]".contains(stack.peek()))
              prefix.append(stack.pop());
            stack.push(s);
            break;
          case "*":
          case "/":
          case "^":
            while(!stack.isEmpty() && "^".contains(stack.peek()))
              prefix.append(stack.pop());
            stack.push(s);
            break;
          case ")":
          case "}":
          case "]":
            stack.push(s);
            break;
        }
      } else if("({[".contains(s)){
        switch(s){
          case "(":
            while(!stack.isEmpty() && !stack.peek().equals(")")){
              prefix.append(stack.pop());
            }
            if(stack.isEmpty()){
              System.out.println("Wrong input");
              System.exit(1);
            }
            stack.pop();
            break;
          case "{":
            while(!stack.isEmpty() && !stack.peek().equals("}")){
              prefix.append(stack.pop());
            }
            if(stack.isEmpty()){
              System.out.println("Wrong input");
              System.exit(1);
            }
            stack.pop();
            break;
          case "[":
            while(!stack.isEmpty() && !stack.peek().equals("]")){
              prefix.append(stack.pop());
            }
            if(stack.isEmpty()){
              System.out.println("Wrong input");
              System.exit(1);
            }
            stack.pop();
            break;
        }
      } else{
        prefix.append(s);
      }
    }
    while(!stack.isEmpty()){
      prefix.append(stack.pop());
    }
    return prefix.reverse().toString();
  }
}
