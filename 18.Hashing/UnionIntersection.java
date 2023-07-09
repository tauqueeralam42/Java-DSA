import java.util.HashSet;

import javax.lang.model.type.IntersectionType;

public class UnionIntersection {
    
    public static void main(String[] args) {
        int arr1[] ={7,3,9};
        int arr2[] = {6,3,9,2,9,4};

        HashSet<Integer> set = new HashSet<>();

        //union
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }

        for(int i=0; i<arr2.length; i++){
            set.add(arr2[i]);
        }
        System.out.println("Union = "+set.size()+" "+set);

        set.clear();
        //Intersection
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }
        HashSet<Integer> ans = new HashSet<>();
        int count = 0;
        for(int i=0; i<arr2.length; i++){
            if(set.contains(arr2[i])){
                count++;
                ans.add(arr2[i]);
                set.remove(arr2[i]); 
            }
        }
        System.out.println("Intersection = "+ count+" " + ans);
    }
}
