public class OddOrEven{

    public static void checkOddEven(int n){
        int bitMask =1;
        if((n & bitMask)==1)
            System.out.println("Odd");
        else
            System.out.println("Even");
    }
    public static void main(String[] args) {
        checkOddEven(11);
    }
}