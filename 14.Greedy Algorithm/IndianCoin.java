import java.util.*;

public class IndianCoin {
    
    public static void main(String arg[]){
        Integer coins[] = {1,2,5,10,20,50,100,500,2000};
        int amount = 590;
        int count=0;

        Arrays.sort(coins, Comparator.reverseOrder());
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<coins.length; i++){
            if(amount>=coins[i]){
                while(amount>=coins[i]){
                    count++;
                    amount -= coins[i];
                    ans.add(coins[i]);

                }
            }
        }

        System.out.println("Min no. of coins = "+count);
        System.out.println(ans);
    }
}
