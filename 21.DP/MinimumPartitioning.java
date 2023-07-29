public class MinimumPartitioning {

    public static int minDiffTab(int arr[]){
        int sum = 0;
        int n = arr.length;
        for(int i : arr)
            sum += i;
        int wt = sum/2;
        int dp[][] =new int[n+1][wt+1];
        for(int i=1; i<=n; i++){
            for(int j = 1; j<=wt; j++){
                if(arr[i-1]<= j){
                    int ans1 = arr[i-1]+dp[i-1][j-arr[i-1]];
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return Math.abs(sum - 2*dp[n][wt]) ;
    }
    
    public static void main(String[] args) {
        int numbers[] = {1,6,11,5};
        System.out.println(minDiffTab(numbers));
    }
}
