import java.util.Arrays;

public class ChocolateCut {
    
    public static void main(String[] args) {
        int n = 4, m = 6;
        int costVer[] = {2,1,3,1,4};
        int costHor[] = {4,1,2};

        Arrays.sort(costHor);
        Arrays.sort(costVer);

        int h=costHor.length-1, v=costVer.length-1;
        int hp=1, vp=1;
        int cost = 0;
        while(h>=0 && v>=0){
            if(costHor[h] > costVer[v]){
                cost += (vp*costHor[h]);
                hp++;h--;
            }
            else{
                cost += (hp*costVer[v]);
                hp++;v--;
            }
        }
        while(h>=0){
            cost += (hp*costHor[h]);
            hp++;h--;
        }
        while(v>=0){
            cost += (vp*costVer[v]);
            vp++;v--;
        }

        System.out.println(cost);
    }
}
