

public class ContainerWithMostWater {

    public static int calWater(int line[]){
        int maxWater =0;
        for(int i=0; i<line.length; i++){
            for(int j=i+1; j<line.length; j++){
                int height = Math.min(line[i], line[j]);
                int width = j-i;
                int currWater = height*width;
                maxWater = Math.max(maxWater, currWater);

            }
        }
        return maxWater;
    }

    //Two Pointer Approach
    public static int calMostWater(int line[]){
        int maxWater = 0;
        int lp = 0, rp = line.length-1;
        while(lp<rp){
            int height = Math.min(line[lp], line[rp]);
            int width = rp-lp;
            int currWater = height*width;
            maxWater = Math.max(maxWater, currWater);
            
            if(line[lp]<line[rp]){
                lp++;
            }
            else{
                rp--;
            }
        }

        return maxWater;
    }
    

    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(calMostWater(height));
        
    }
}
