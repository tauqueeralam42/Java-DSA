import java.util.Stack;

public class NextGreaterElement {

    // public static void nextGreater(int arr[], int ans[]) {

    //     for (int i = 0; i < arr.length - 1; i++) {
    //         for (int j = i + 1; j < arr.length; j++) {
    //             if (arr[j] > arr[i]) {
    //                 ans[i] = arr[j];
    //                 break;
    //             } else {
    //                 ans[i] = -1;
    //             }
    //         }
    //     }
    //     ans[arr.length - 1] = -1;
    // }


    public static void nextGreater(int arr[], int ans[]){
        Stack<Integer> s = new Stack<>();

        for(int i= arr.length-1; i>=0;  i--){
            while(! s.isEmpty() && arr[i]>= s.peek()){
                s.pop();
            }

            if(s.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = s.peek();
            }

            s.push(arr[i]);
        }
    }

    public static void main(String[] args) {
        int arr[] = {6,8,0,1,3};
        int ans[] = new int[arr.length];
        nextGreater(arr, ans);
        for(int i=0; i<ans.length; i++){
        System.out.print(ans[i]+" ");
        }

        

    }
}
