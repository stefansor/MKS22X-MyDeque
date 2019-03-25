import java.util.*;

public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
     //use scanner to get each token
    public static double eval(String s){
      //sets up deque to use to process the terms
      Scanner stuff = new Scanner(s);
      MyDeque tokens = new MyString();
      while(stuff.hasNext()){
        tokens.addLast(stuff.next())
      }
      while(tokens.size() > 1){

      }


    }
}
