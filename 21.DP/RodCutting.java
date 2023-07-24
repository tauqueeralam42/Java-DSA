public class RodCutting {

    public static int rodCutting(int len[], int pri[], int rl){
        int dp[][] = new int[pri.length+1][rl+1];
        for(int i=1; i<=pri.length; i++){
            for(int j =1; j<=rl; j++){
                if(len[i-1]<=j)
                    dp[i][j] = Math.max(pri[i-1]+dp[i][j-len[i-1]],dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[pri.length][rl];
    }
    

    public static void main(String[] args) {
        int length[] = {1,2,3,4,5,6,7,8};
        int price[] = {1,5,8,9,10,17,17,20};
        int rodLength = 8;

        System.out.println(rodCutting(length, price, rodLength));
    }
}
