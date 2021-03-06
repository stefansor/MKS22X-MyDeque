import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;


  ///empty object array
  //two constructors default creates array of length 10
  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 0;
    start = 0;
    end = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    if(initialCapacity == 0){
      data = (E[])new Object[1];
    }
    else{
      data = (E[])new Object[initialCapacity];
    }
    size = 0;
    start = 0;
    end = 0;
  }

  public int size(){
    return size;
  }

  @SuppressWarnings("unchecked")
  private void resize(){
    E[] newdata = (E[])new Object[data.length * 2];
    if(start > end){
      int a = 0;
      for(int i = start; i < data.length; i++){
        newdata[a] = data[i];
        a++;
      }
      for(int i = 0; i <= end; i++){
        newdata[a] = data[i];
        a++;
      }
      a--;
      end = a;
    }
    else{
      int b = 0;
      for(int i = start; i <= end; i++){
        newdata[b] = data[i];
        b++;
      }
      b--;
      end = b;
    }
    start = 0;
    data = newdata;
  }

  public String toString(){
    String str = "{";
    if(start <= end){
      for(int i = start; i <= end; i++){
        if(i == end){
          str = str + data[i] + "}";
        }
        else{
          str = str + data[i] + " ";
        }
      }
    }
    else{
      for(int i = start; i < data.length - 1; i++){
        str = str + data[i] + " ";
      }
      for(int i = 0; i <= end; i++){
        if(i == end){
          str = str + data[i] + "}";
        }
        else{
          str = str + data[i] + " ";
        }
      }
    }
    return str;
  }

  public String debugString(){
    String str = "{";
    for(int i = 0; i < data.length; i++){
      if(i == data.length - 1){
        str = str + data[i] + "}";
      }
      else{
        str = str + data[i] + " ";
      }
    }
    return str;
  }

  public void addFirst(E element){
    if(element == null){
      throw new NullPointerException("Cannot add null to a deque");
    }
    else if(end + 1 == start || (start == 0 && end == data.length - 1)){
      resize();
      start = data.length - 1;
      data[start] = element;
    }
    else if(start > 0){
      start--;
      data[start] = element;
    }
    else{
      start = data.length - 1;
      data[start] = element;
    }
    size++;
    if(size() == 1){
      end = start;
    }
  }

  public void addLast(E element){
    if(element == null){
      throw new NullPointerException("Cannot add null to a deque");
    }
    else if(end + 1 == start || (start == 0 && end == data.length - 1)){
      resize();
      end++;
      data[end] = element;
    }
    else if(end == data.length - 1){
      end = 0;
      data[end] = element;
    }
    else if(start == end && data[start] != null){
      end++;
      data[end] = element;
    }
    else if(start == end && data[start] == null){
      data[end] = element;
    }
    else{
      end++;
      data[end] = element;
    }
    size++;
  }

  public E removeFirst(){
    if(size == 0){
      throw new NoSuchElementException("Deque is Empty");
    }
    E trash = null;
    if(start == data.length - 1){
      trash = data[start];
      data[start] = null;
      start = 0;
    }
    else{
      trash = data[start];
      data[start] = null;
      start++;
    }
    size--;
    return trash;
  }

  public E removeLast(){
    if(size == 0){
      throw new NoSuchElementException("Deque is Empty");
    }
    E trash = null;
    if(end == 0){
      trash = data[end];
      data[end] = null;
      end = data.length - 1;
    }
    else{
      trash = data[end];
      data[end] = null;
      end--;
    }
    size--;
    return trash;
  }

  public E getFirst(){
    if(size == 0){
      throw new NoSuchElementException("Deque is Empty");
    }
    return data[start];
  }

  public E getLast(){
    if(size == 0){
      throw new NoSuchElementException("Deque is Empty");
    }
    return data[end];
  }







  public static void main(String[] args){
    MyDeque<Integer> yea = new MyDeque<Integer>();
    System.out.println(yea.start);
    System.out.println(yea.end);
    System.out.println(yea.debugString());
    for(int i = 1; i < 20 ; i++){
      yea.addLast(i);
    }
    System.out.println(yea.debugString());
    System.out.println(yea);
    System.out.println(yea.start);
    System.out.println(yea.end);
    yea.removeLast();
    yea.removeLast();
    yea.removeLast();
    yea.removeLast();
    yea.removeLast();
    yea.removeLast();
    System.out.println(yea);
    System.out.println(yea.start);
    System.out.println(yea.end);

  }
}
