public class HollowRhombus {
    public static void hollowRhombus(int rows){
        for(int i=0; i<rows; i++){
            for(int j=0; j<rows-i-1; j++)
                System.out.print(" ");
            for(int j=0; j<rows; j++){
                if(j==0||j==rows-1||i==0||i==rows-1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        hollowRhombus(5);
    }
}
