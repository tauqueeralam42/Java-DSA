import org.w3c.dom.Node;

public class TransformtoSumTree {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static int sumTree(Node root){
        if(root == null)
            return 0;

        int leftSum = sumTree(root.left);
        int rightSum = sumTree(root.right);

        int sum = leftSum+rightSum+root.data;

        root.data = leftSum+rightSum;
        return sum;
    }

    public static void inorder(Node root){
            if(root == null){
                //System.out.print(-1+" ");
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
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

    sumTree(root);

    inorder(root);


    }
}
