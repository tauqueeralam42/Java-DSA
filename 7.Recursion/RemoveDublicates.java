public class RemoveDublicates {
    
    public static void removeDublicates(String str, int idx, StringBuilder newStr , boolean map[] ){
        if(idx == str.length()){
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        if(map[currChar-'a']==true){
            removeDublicates(str, idx+1, newStr, map);
        }
        else{
            map[currChar-'a']=true;
            removeDublicates(str, idx+1, newStr.append(currChar), map);
        }
    }


    public static void main(String[] args) {
        String str = "abbcadbcd";
        boolean map[] = new boolean[26];
        StringBuilder newStr = new StringBuilder();
        removeDublicates(str, 0, newStr, map);
    }
}
