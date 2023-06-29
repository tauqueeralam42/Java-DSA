
import java.util.*;
public class ActivitySelection {

     public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };

        // sorting
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // sorted on the basis of end time
        ArrayList<Integer> ans = new ArrayList<>();

        // select 1st activity
        int maxAct = 1;
        int lastEnd = activities[0][2];
        ans.add(activities[0][0]);

        for (int i = 1; i < activities.length; i++) {
            if (activities[i][1] >= lastEnd) {
                // select the activity
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        System.out.println("Max no. of Activities = " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
     }
}