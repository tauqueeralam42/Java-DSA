public class FloydsTriangle {
    
    public static void floydsTriangle(int rows){
        int count =1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<=i; j++){
                System.out.print(count+" ");
                count++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        floydsTriangle(5);
    }
}
