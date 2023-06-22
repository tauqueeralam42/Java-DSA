
public class PairSumInSortedArray {

    public static boolean checkSum(int arr[], int target) {
        int lp = 0, rp = arr.length - 1;
        while (lp < rp) {
            if (arr[lp] + arr[rp] == target)
                return true;
            else if (arr[lp] + arr[rp] > target)
                rp--;
            else
                lp++;
        }

        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };

        System.out.println(checkSum(arr, 5));
    }
}
