import java.util.ArrayList;

public class BasicArrayList {

    public static void swap(ArrayList<Integer> list, int idx1, int idx2){
        int temp = list.get(idx2);
        list.set(idx2, list.get(idx1));
        list.set(idx1, temp);
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);

        // swap(list, 2, 4);
        // System.out.println(list);

        // System.out.println(list.get(3));


        list.remove(2);
        System.out.println(list);

        list.set(2, 10);
        System.out.println(list);

        list.add(1, 0);
        System.out.println(list);

    }
}
