
import java.util.*;

public class NearByCars {
    static class Point{
        int x;
        int y;
        int distSq;
        int idx;
        public Point(int x, int y, int i){
            this.x = x;
            this.y = y;
            distSq = x*x + y*y;
            this.idx = i;
        }
    }
    

    public static void main(String[] args) {
        int pts[][] = {{3,3},{5,-1},{-2,4}};
        int k =2;
        ArrayList<Point> pt = new ArrayList<>();

        for(int i=0; i<pts.length; i++){
            pt.add(new Point(pts[i][0], pts[i][1],i));
        }

        Collections.sort(pt, (b,a)-> b.distSq - a.distSq);

        for(int i=0; i<k; i++){
            System.out.println("C"+pt.get(i).idx);
        }

        
    }
}
