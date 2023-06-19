public class RecursionBasic {
    
    public static void printDecreasing(int n){
        if(n==1){
            System.out.print(n);
            return;
        }
        System.out.print(n+" ");
        printDecreasing(n-1);
    }

    public static void printIncreasing(int n){
        if(n==1){
            System.out.print(1+" ");
            return;
        }
        printIncreasing(n-1);
        System.out.print(n+" ");

    }

    public static int fact(int n){
        if(n==0 || n==1)
            return 1;
        return n*fact(n-1);
    }

    public static int firstNSum(int n){
        if(n==1)
            return 1;
        return n+firstNSum(n-1);
    }

    public static int fib(int n){
        if(n==1 || n==0 )
            return n;
        return fib(n-1)+fib(n-2);

    }

    public static int firstOccu(int arr[], int key, int i){
        if(i==arr.length)
            return -1;
        if(arr[i]==key)
            return i;
        return firstOccu(arr, key, i+1);
    }

    public static int lastOccu(int arr[], int key, int i){
        if(i==arr.length)
            return -1;
        int found = lastOccu(arr, key, i+1);
        if(key == arr[i] && found==-1)
            return i;
        return found;
    }

    public static int pow(int a, int n){
        if(n==0)
            return 1;
        int halfpow = pow(a,n/2);
        int halfPowSq = halfpow*halfpow;
        if(n%2!=0)
            return a*halfPowSq;
        return halfPowSq;
    }
    

    public static void main(String[] args) {
       // printIncreasing(5);
       //System.out.println(fact(5));
       //System.out.println(firstNSum(5));
       //System.out.println(fib(25));

      // int arr[] = {2,3,8,5,7,8,5,4,2,1};
       //System.out.println(lastOccu(arr, 5, 0));

       System.out.println(pow(2, 10));
        
    }
}
