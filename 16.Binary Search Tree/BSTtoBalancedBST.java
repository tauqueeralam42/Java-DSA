import java.util.ArrayList;

public class BSTtoBalancedBST {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void inorder(Node root, ArrayList<Integer> data){
        if(root == null){
            return;
        }

        inorder(root.left, data);
        data.add(root.data);
        inorder(root.right,data);
    }

    public static Node createBST(ArrayList<Integer> data, int strt, int end){
        if(strt > end){
            return null;
        }

        int mid = (strt+end)/2;
        Node root = new Node(data.get(mid));
        root.left = createBST(data, strt, mid-1);
        root.right = createBST(data, mid+1, end);

        return root;
            
    
    }

    public static void preorder(Node root){
            if(root == null){
               // System.out.print(-1+" ");
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.right = new Node(10);
        root.left.left = new Node(5);
        root.right.right = new Node(11);
        root.left.left.left = new Node(3);
        root.right.right.right = new Node(12);

        ArrayList<Integer> data = new ArrayList<>();
        inorder(root, data);

        preorder(root);
        System.out.println();

        root = createBST(data,0,data.size()-1);
        preorder(root);

        
        
    }
}
