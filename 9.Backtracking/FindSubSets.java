public class FindSubSets {

    public static void findSubsets(String str, String ans, int i){
        if(i==str.length()){
            System.out.println(ans);
        return;
    }

        findSubsets(str, ans+str.charAt(i), i+1);
        findSubsets(str, ans, i+1);
    }

    public static void main(String[] args) {
        findSubsets("abc", "", 0);
    }
    
}
