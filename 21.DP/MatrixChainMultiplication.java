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
    
    public static int mnmTab(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n];

        for(int i=0; i<n; i++)
            dp[i][i] = 0;

        for(int len = 2; len<n; len++){
            for(int i=1; i<=n-len; i++){
                int j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<j; k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1]*arr[k]*arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1+cost2+cost3);
                }
            }
        }
        return dp[1][n-1];
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
        System.out.println(mnmTab(arr));
    }
}
