

public class PairSumSortedAndRotatedArray {
    
    public static boolean pairsum2(int arr[], int target){
        int pivot = -1;
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            if(arr[i]>arr[i+1]){
                pivot = i;
                break;
            }
        }

        int lp = pivot+1, rp = pivot;
        while(lp!=rp){
            if(arr[lp]+arr[rp]==target)
                return true;
            else if(arr[lp]+arr[rp]>target)
                rp = (n+rp-1)%n;
            else 
                lp = (lp+1)%n;
                
        }
        return false;

    }


    public static void main(String[] args) {
        int arr[] = {11,15,6,8,9,10};
        System.out.println(pairsum2(arr, 16));
    }
}
