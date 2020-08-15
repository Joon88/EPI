import java.util.Stack;
class InfixToPostfix{
  public static void main(String args[]){
    System.out.println(solve("A,+,(,B,/,C,-,(,D,*,E,^,F,),+,G,),*,H"));
  }

  private static String solve(String infix){
    String[] arr = infix.split(",");
    StringBuffer postfix = new StringBuffer();
    Stack<String> stack = new Stack<>();

    for(String s : arr){
      System.out.println(stack);
      if(s.length() == 1 && "+-*/^({[".contains(s)){
        switch(s){
          case "-":
          case "+":
            while(!stack.isEmpty() && !"({[".contains(stack.peek()))
              postfix.append(stack.pop());
            stack.push(s);
            break;
          case "*":
          case "/":
            while(!stack.isEmpty() && "^*/".contains(stack.peek()))
              postfix.append(stack.pop());
            stack.push(s);
            break;
          case "^":
          case "(":
          case "[":
          case "{":
            stack.push(s);
            break;
        }
      } else if(")}]".contains(s)){
        switch(s){
          case ")":
            while(!stack.isEmpty() && !stack.peek().equals("(")){
              postfix.append(stack.pop());
            }
            if(stack.isEmpty()){
              System.out.println("Wrong input");
              System.exit(1);
            }
            stack.pop();
            break;
          case "}":
            while(!stack.isEmpty() && !stack.peek().equals("{")){
              postfix.append(stack.pop());
            }
            if(stack.isEmpty()){
              System.out.println("Wrong input");
              System.exit(1);
            }
            stack.pop();
            break;
          case "]":
            while(!stack.isEmpty() && !stack.peek().equals("[")){
              postfix.append(stack.pop());
            }
            if(stack.isEmpty()){
              System.out.println("Wrong input");
              System.exit(1);
            }
            stack.pop();
            break;
        }
      } else{
        postfix.append(s);
      }
    }
    while(!stack.isEmpty()){
      postfix.append(stack.pop());
    }
    return postfix.toString();
  }
}
