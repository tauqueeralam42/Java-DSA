public class MaxSubArraysSum {
    
    public static int maxSubArraysSum(int arr[]){
        int maxSum=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length;j++){
                int currSum=0;
                for(int k=i; k<=j; k++){
                    currSum+=arr[k];
                }
                if(currSum>maxSum)
                    maxSum=currSum;
            }
        }
        return maxSum;
    }

    public static int prefixSum(int arr[]){
        int maxSum= Integer.MIN_VALUE;
        int prefix[]=new int[arr.length];
        prefix[0]=arr[0];
        for(int i=1; i<arr.length; i++)
            prefix[i]=prefix[i-1]+arr[i];
        
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                int currentSum =0;
                currentSum = i==0?prefix[j]:prefix[j]-prefix[i-1];
                if(maxSum<currentSum)
                    maxSum=currentSum;
            }

        }
        return maxSum;
    }

    public static int kadanes(int arr[]){
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;
        for(int i=0; i<arr.length; i++){
            currSum+=arr[i];
            if(currSum<0)
                currSum=0;
            if(maxSum<currSum)
                maxSum=currSum;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[]={1,-2,6,-1,3};
        System.out.println(kadanes(arr));
    }
}
