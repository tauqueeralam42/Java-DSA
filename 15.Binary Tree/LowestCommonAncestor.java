import java.util.*;

public class LowestCommonAncestor {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static boolean getpath(Node root, int n, ArrayList<Node> path){
        if(root == null){
            return false;
        }

        path.add(root);

        if(root.data == n){
            return true;
        }

        if(getpath(root.left, n, path) || getpath(root.right, n, path)){
            return true;
        }

        path.remove(path.size()-1);
        return false;

    }

    public static Node getLca(Node root, int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getpath(root, n1, path1);
        getpath(root, n2, path2);

        int i=0;
        for(; i<path1.size() && i<path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }

        return path1.get(i-1);
    }

    public static Node lca2(Node root, int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
    }

    Node left = lca2(root.left, n1,n2);
    Node right = lca2(root.right, n1, n2);

    if(left == null)
        return right;
    if(right == null)
        return left;

        return root;
    }
    

    public static void main(String[] args) {
       /*
                      1
                    /   \
                   2     3
                  / \   / \
                 4   5 6   7
     */
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7 ); 


    //System.out.println(getLca(root, 4, 7).data);

    System.out.println(lca2(root, 1, 7).data);
    }
}
