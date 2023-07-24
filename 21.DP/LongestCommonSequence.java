public class LongestCommonSequence {
    public static int lcs(String str1, String str2, int n, int m){
        if(n==0 || m==0){
            return 0;
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return lcs(str1, str2, n-1, m-1)+1;
        }
        else{
            return Math.max(lcs(str1, str2, n-1, m), lcs(str1, str2, n, m-1));
        }
    }

    public static int lcsTabulation(String s1, String s2){
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String str1 = "abcdefgh";
        String str2 = "acdgef";

        System.out.println(lcs(str1, str2, str1.length(), str2.length()));
        System.out.println(lcsTabulation(str1, str2));
    }
    
}
