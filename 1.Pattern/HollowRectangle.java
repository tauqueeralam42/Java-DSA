
public class HollowRectangle {
    
    public static void hollowRectangle(int rows, int col){
        for(int i=0; i<rows; i++){
            for(int j=0; j<col; j++){
                if(i==0 || i==rows-1 || j==0 || j==col-1)
                System.out.print("* ");
                else
                System.out.print("  ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        hollowRectangle(4, 5);
    }
}
