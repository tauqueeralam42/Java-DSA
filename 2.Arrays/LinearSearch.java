public class LinearSearch{

    public static void linearSearch(int arr[], int key){

        for(int i=0; i<arr.length; i++){
            if(arr[i]==key){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
        
    }

    public static void main(String[] args) {
        int arr[]={12,34,26,97,35,11};
        int key = 10;
        linearSearch(arr, key);

    }

}