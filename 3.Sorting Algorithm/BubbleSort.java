public class Bubblesort{

    public static void bubblesort(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            for(int j=0;j<arr.length-1-i; j++){
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {2,5,3,1,4};
        bubblesort(arr);
        for(int i=0; i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}