public class InvertedHalfPyramidwithNumbers {
    
    public static void invertedHalfPyramidwithNumbers(int rows){
        for(int i=0; i<rows; i++){
            for(int j=0; j<rows-i; j++){
                System.out.print(j+1 +" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        invertedHalfPyramidwithNumbers(4);
    }
}
