import java.util.Stack;

public class ReverseStack {

    public static void pushAtBottum(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottum(s, data);
        s.push(top);
    }

    public static void reverseStack(Stack <Integer> s){

        if(s.isEmpty()){
            return;
        }

        int top = s.pop();
        reverseStack(s);
        pushAtBottum(s, top);
    }
    


    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);


        reverseStack(s);

        while(!s.isEmpty()){
            System.out.println(s.pop());
        }


    }
}
