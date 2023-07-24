public class ClimbingStairs {

    public static int countWays(int n){
        if(n<0)
            return 0;
        if(n==0 || n==1)
            return 1;
        return countWays(n-1) + countWays(n-2);
    }

    public static int memWays(int n, int ways[]){
        if(n==0 || n==1)
            return 1;

        if(n<0)
            return 0;
        
        if(ways[n] != 0)
            return ways[n];
        
        ways[n] = memWays(n-1, ways)+memWays(n-2, ways);
        return ways[n];
    }

    public static int tabulationWays(int n){
        int dp[] = new int [n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++)
            dp[i] = dp[i-1]+dp[i-2];

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 45;
        int ways[] = new int[n+1];
        //System.out.println(countWays(n));
        //System.out.println(memWays(n, ways));

        System.out.println(tabulationWays(n));
    }
}
