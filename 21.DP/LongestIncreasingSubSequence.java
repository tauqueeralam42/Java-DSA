import java.util.*;

public class LongestIncreasingSubSequence {
    public static int lcs(int arr1[], int arr2[]){
        int dp[][] = new int[arr1.length+1][arr2.length+1];
        for(int i=1; i<=arr1.length; i++){
            for(int j=1; j<= arr2.length; j++){
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[arr1.length][arr2.length];
    }

    public static int lis(int arr1[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr1)
            set.add(i);
        int arr2[] = new int[set.size()];
        int i=0;
        for(int num : set){
            arr2[i] = num;
            i++;
        }
            

             
        Arrays.sort(arr2);
        return lcs(arr1,arr2);
    }
    

    public static void main(String[] args) {
        int arr1[] = {50,3,10,7,40,80};
        System.out.println(lis(arr1));
    }
}
