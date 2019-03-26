import java.util.*;

public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
     //use scanner to get each token
    public static double eval(String s){
      //sets up deque to use to process the terms
      Scanner stuff = new Scanner(s);
      MyDeque tokens = new MyDeque();
      //should be able to simulatneously add the doubles and evaluate expressions
      while(stuff.hasNext()){
        String ne = stuff.next();
        if(!ne.equals("*") || !ne.equals("+") || !ne.equals("-") || !ne.equals("/") || !ne.equals("%")){
          //parse into double and add to tokens
        }
        else if(ne.equals("*")){
          double newval = tokens.removeLast() * tokens.removeLast();
          tokens.addLast(newval);
        }
        else if(ne.equals("+")){
          double newval = tokens.removeLast() + tokens.removeLast();
          tokens.addLast(newval);
        }
        else if(ne.equals("-")){
          double last = tokens.removeLast();
          double first = tokens.removeLast();
          double newval = first - last;
          tokens.addLast(newval);
        }
        else if(ne.equals("/")){
          double last = tokens.removeLast();
          double first = tokens.removeLast();
          double newval = first / last;
          tokens.addLast(newval);
        }
        else if(ne.equals("%")){
          double last = tokens.removeLast();
          double first = tokens.removeLast();
          double newval = first % last;
          tokens.addLast(newval);
        }
      }
      //to compile and debug
      System.out.println(tokens);
      return -1;

    }



    public static void main(String[] args){
      String yea = "1 1 +";
      eval(yea);
    }
}
