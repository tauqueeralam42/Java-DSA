import java.util.*;

public class JobSequencing {

    public static class Job{
        int deadline;
        int profit;
        int idx;
        Job(int i, int d,  int p){
            idx = i;
            profit =p;
            deadline =d;
        }
    }

    public static void main(String[] args) {
        int jobInfo[][] = {{4,20},{1,10},{1,40},{1,30}};


        // ArrayList<Integer> seq = new ArrayList<>();
        // Arrays.sort(jobInfo, Comparator.comparingDouble(o-> o[1]));
        // int time =0;
        // int maxProfit = 0;
        // for(int i=jobInfo.length-1; i>=0; i--){
        //     if(jobInfo[i][0]> time){
        //         maxProfit += jobInfo[i][1];
        //         seq.add(jobInfo[i][1]);
        //         time++;
        //     }
        // }
        // System.out.println(maxProfit);
        // System.out.println(seq);


        ArrayList<Job> jobs = new ArrayList<>();
        for(int i=0; i<jobInfo.length; i++){
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        Collections.sort(jobs, (a,b)-> b.profit - a.profit);

        ArrayList<Integer> seq = new ArrayList<>();
        int time =0;
        int maxProfit =0;
        for(int i=0; i<jobs.size(); i++){
            Job curr = jobs.get(i);
            if(curr.deadline > time){
                maxProfit += curr.profit;
                seq.add(curr.idx);
                time++;
            }
        }
        System.out.println(maxProfit);
        System.out.println(seq);
    }
}
