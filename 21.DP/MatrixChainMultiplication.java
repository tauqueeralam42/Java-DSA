public class MatrixChainMultiplication {

    public static int mnm(int arr[], int i, int j){
        if(i==j)
            return 0;
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int cost1 = mnm(arr, i, k);
            int cost2 = mnm(arr,k+1, j);
            int cost3 = arr[i-1]*arr[k]*arr[j];
            int finalCost = cost1+cost2+cost3;
            ans = Math.min(ans,finalCost);
        }

        return ans;
    }
    

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
        System.out.println(mnm(arr,1,4));
    }
}
