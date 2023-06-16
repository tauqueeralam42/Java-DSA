public class Palindrome {
    
    public static void isPalindrome(String str){
        int n = str.length();
        for(int i=0; i<n/2; i++){
            if(str.charAt(i)!=str.charAt(n-1-i)){
                System.out.println("This is not a Palindrome");
                return;
            }     
        }
        System.out.println("This string is a Palindrome");

    }

    public static void main(String[] args) {
        String str = "madam";
        isPalindrome(str);
    }
}
