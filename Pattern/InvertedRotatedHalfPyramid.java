

public class InvertedRotatedHalfPyramid {
    
public static void invertedRotatedHalfPyramid(int rows){
        for(int i=0; i<rows; i++){
            for(int j=0; j<rows; j++){
                if(j<rows-i-1)
                    System.out.print("  ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
        

    }

    public static void main(String[] args) {
        invertedRotatedHalfPyramid(4);
    }
}
