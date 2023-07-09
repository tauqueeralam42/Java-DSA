public class PrefixProblem {
    public static class Node{
        Node children[] = new Node[26];
        boolean eow = false;
        int freq=1;

        Node(){
            for(int i=0; i<26; i++)
                children[i] = null;

            
        }
    }
    public static Node root = new Node();
            

    public static void insert(String word){
        Node curr = root;
        for(int level =0; level < word.length(); level++){
            int idx = word.charAt(level)-'a';
            if(curr.children[idx]== null){
                curr.children[idx] = new Node();
            }
            else{
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;

    }

    public static String prefix(String word){
        Node curr = root;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i)-'a';
            curr = curr.children[idx];
            sb.append(word.charAt(i));
            if(curr.freq==1){
                break;
            }
            
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String arr[] = {"zebra","dog","duck","dove"};

        for(int i=0; i<arr.length; i++){
            insert(arr[i]);
        }

        for(int i=0; i<arr.length; i++){
            System.out.print(prefix(arr[i])+" ");
        }
    }


}
