package myApp;
import java.util.Scanner;
public class Deque{
	private int maxSize;
   private char[] queArray;
   private int front,rear;
   
   public Deque(int s) {
      maxSize = s;
      queArray = new char[maxSize];
      front=-1;rear=-1;
   }
   public void add(char j) {
	if(front==-1&&rear==-1){
	  queArray[++front] = j;
		rear++;
	}
	else
     	{
	 queArray[++rear] = j;
	}
   }
   public char prev(int j) {
	  return queArray[j--];
   }
   public char next(int j) {
	  return queArray[j++];
   }
   public int getRear() {
      return rear;
   } public int getFront() {
      return front;
   }
   public boolean isEmpty() {
      return (front==-1&&rear==-1);
   }
   public boolean isFull() {
      return (rear==maxSize - 1);
   }
public static void main(String args[]){
	Deque d=new Deque(-1);
}
}
