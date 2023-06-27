import java.util.Stack;

public class MaxAreaHistogram {

     public static void nextSmallerRight(int arr[], int right[]){
            Stack<Integer> s = new Stack<>();

            for(int i=arr.length-1; i>=0; i--){
                while(!s.isEmpty() && arr[i]<=arr[s.peek()]){
                    s.pop();
                }
                if(s.isEmpty()){
                    right[i]= arr.length;
                }
                else{
                    right[i]=s.peek();
                }
                s.push(i);
            }
        }

        public static void nextSmallerLeft(int arr[], int left[]){
            Stack<Integer> s = new Stack<>();

            for(int i=0; i<arr.length; i++){
                while(!s.isEmpty() && arr[i]<= arr[s.peek()]){
                    s.pop();
                }

                if(s.isEmpty()){
                    left[i]=-1;
                }

                else{
                    left[i]= s.peek();
                }

                s.push(i);
            }
        }

    public static int maxArea(int arr[]){
        int maxArea = Integer.MIN_VALUE;
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];
        nextSmallerLeft(arr, left);
        nextSmallerRight(arr, right);

        for(int i=0;i<arr.length; i++){
            int width = right[i]-left[i]-1;
            int currArea = arr[i] * width;
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
       
    }
    
        public static void print(int arr[]){
            for(int i=0; i<arr.length; i++){
                System.out.print(arr[i]+" ");
            }
        }
    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3};


        System.out.println(maxArea(heights));
    }
}
