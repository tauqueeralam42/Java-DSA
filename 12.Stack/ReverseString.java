import java.util.Stack;

public class ReverseString {

    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        
        for(int i=0; i<str.length(); i++){
            s.push(str.charAt(i));
        }

        StringBuilder ans = new StringBuilder("");
        while(!s.isEmpty()){
            ans.append(s.pop());
        }
        return ans.toString();
    }



    public static void main(String[] args) {
        String str = "abcd";
        String newStr = reverseString(str);
        System.out.println(newStr);
    }
    
}
