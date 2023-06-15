public class ButterflyPattern {
    
    public static void butterflyPattern(int rows){
        for(int i=0; i<rows; i++){
            for(int j=0; j<=i; j++)
                System.out.print("* ");
            for(int j=0; j<2*(rows-i-1); j++)
                System.out.print("  ");
            for(int j=0; j<=i; j++)
                System.out.print("* ");

            System.out.println();
        }
        for(int i=rows-1; i>=0; i--){
            for(int j=0; j<=i; j++)
                System.out.print("* ");
            for(int j=0; j<2*(rows-i-1); j++)
                System.out.print("  ");
            for(int j=0; j<=i; j++)
                System.out.print("* ");

            System.out.println();
        }
    }

    public static void main(String[] args) {
        butterflyPattern(4);
    }
}
