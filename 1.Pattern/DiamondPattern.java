public class DiamondPattern {
    public static void diamonPattern(int row){
        for(int i=0; i<row; i++){
            for(int j=0; j<row-1-i; j++)
                System.out.print("  ");
            for(int j=0; j<2*i+1; j++)
                System.out.print("* ");
            System.out.println();
        }
        for(int i=row-1; i>=0; i--){
            for(int j=0; j<row-1-i; j++)
                System.out.print("  ");
            for(int j=0; j<2*i+1; j++)
                System.out.print("* ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        diamonPattern(4);
    }
}
