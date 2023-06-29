import java.util.Deque;
import java.util.LinkedList;

public class StackQueueUsingDeque {

    public static class Stack{

        static Deque<Integer> de = new LinkedList<>();

        public static void push(int data){
            de.addLast(data);
        }

        public static int pop(){
            return de.removeLast();
        }

        public static int peek(){
            return de.getLast();
        }
    }

    

    public static void main(String[] args) {

        Stack s = new Stack();
        s.push(10);
        s.push(1);

        System.out.println(s.pop());
        
    }
}
