public class BitManipulation{

    public static int getIthBit(int n, int i){
        int bitMask = 1<<i;
        if((n&bitMask)==0)
            return 0;
        else
            return 1;
    }

    public static int setIthBit(int n, int i){
        int bitMask = 1<<i;
        return n|bitMask;
    }

    public static int clearIthBit(int n, int i){
        int bitMask = ~(1<<i);
        return n & bitMask;
    }

    public static int updateIthBit(int n, int i, int newBit){

        n = clearIthBit(n, i);
        int bitMask = newBit<<i;
        return n | bitMask;
    }

    public static int clearIBits(int n, int i){
        int bitMask = (-1)<<i;
        return n & bitMask;
    }

    public static int clearRangeofBits(int n, int i, int j){
        int a = (-1)<<(j+1);
        int b = ~(-1<<i);
        int bitMask = a|b;
        return n & bitMask;
    }
   
    public static void main(String[] args) {
       System.out.println( clearRangeofBits(10, 1,4));
    }
}