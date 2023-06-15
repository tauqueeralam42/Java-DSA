
public class SolidRhombus {
    

    public static void solidRhombus(int rows){
        for(int i=0; i<rows; i++){
            for(int j=0; j<rows-i-1; j++)
                System.out.print(" ");
            for(int j=0; j<rows; j++)
                System.out.print("* ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        solidRhombus(5);
    }
}
