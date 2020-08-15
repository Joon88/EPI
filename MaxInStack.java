import java.util.*;

public class MaxInStack {
  public static void main(String args[]){
    //MaxInStack.MyStack stack = new MaxInStack.MyStack();
    MyStack stack = new MyStack();
    stack.push(2);
    stack.push(2);
    stack.push(1);
    stack.push(4);
    stack.push(5);
    stack.push(5);
    stack.push(3);
    stack.pop();
    stack.pop();
    stack.pop();
    stack.pop();
    stack.push(0);
    stack.push(3);
    System.out.println(stack.getMax());
  }

  static class MyStack {
    private Deque<Integer> mainStack = new LinkedList<>();
    private Deque<Pair> maxStack = new LinkedList<>();

    public void push(int x) {
      if(maxStack.isEmpty()){
        maxStack.addFirst(new Pair(x, 1));
        //mainStack.addFirst(x);
      } else if(maxStack.peek().item == x){
          maxStack.peek().count++;
      } else if(maxStack.peek().item < x){
          maxStack.addFirst(new Pair(x, 1));
      }
        //int max = Math.max(maxStack.peek().item, x);
        //maxStack.addFirst(max);
      mainStack.addFirst(x);
    }

    public Integer pop(){
      if(mainStack.isEmpty()){
        return null;
      }
      int deleted = mainStack.pop();
      if(maxStack.peek().item == deleted){
        maxStack.peek().count--;
      }
      if(maxStack.peek().count == 0)
        maxStack.pop();
      //maxStack.pop();
      return deleted;
    }

    public Integer getMax(){
      System.out.println("Main Stack : " + mainStack);
      System.out.println("Max Stack : " + maxStack);
      return maxStack.peek().item;
    }
  }

  static class Pair{
    private int item;
    private int count;

    public Pair(int item, int count) {
      this.item = item;
      this.count = count;
    }

    public String toString(){
      return item + "-" + count;
    }
  }

}
