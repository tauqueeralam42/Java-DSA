import java.util.PriorityQueue;

public class MaxSubArrayspfSizeK {
    static class Pair implements Comparable<Pair>{
        int val;
        int idx;

        Pair(int val, int i){
            this.val = val;
            this.idx = i;
        }

        @Override
        public int compareTo(Pair p){
            return p.val - this.val;
        }
    }



    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int res[] = new int[arr.length-1+k];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i=0; i<k; i++)
            pq.add(new Pair(arr[i], i));

            res[0] = pq.peek().val;

        for(int i=k; i<arr.length; i++){
            while(pq.size()>0 && pq.peek().idx <= (i-k))
                pq.remove();
                
            pq.add(new Pair(arr[i], i));
            res[i-k+1] = pq.peek().val;
            
        }

        for(int i=0; i<arr.length-k+1;i++){
            System.out.print(res[i]+" ");
        }
        

        


    }
    
}
