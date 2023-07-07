import java.util.ArrayList;

import javax.lang.model.util.ElementScanner14;

public class BSTBasic {
    
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root , int val){
        if(root == null){
           root = new Node(val);
            return root;
        }

        if(root.data > val){
            root.left = insert(root.left, val);
        }
        else if(root.data < val){
            root.right = insert(root.right, val);
        }

        return root;

    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean searchBST(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(root.data>key){
            return searchBST(root.left, key);
        }
        else{
            return searchBST(root.right, key);
        }
    }

    public static Node delete(Node root, int val){
        if(root.data > val){
            root.left = delete(root.left, val);
        }
        else if(root.data < val){
            root.right = delete(root.right, val);
        }
        else{
            //Case1 leaf node
            if(root.left == null && root.right == null){
                return null;
            }
            //Case2 One Child
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }

            //Case3 Both Child
            Node succ = findInorderSuccessor(root.right);
            root.data = succ.data;
            root.right = delete(root.right, succ.data);
        }

        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left != null)
            root = root.left;

        return root;
        
    }

    public static void printRange(Node root , int n1, int n2){
        if(root == null){
            return;
        }
        if(root.data >=n1 && root.data<=n2){
            printRange(root.left, n1, n2);
            System.out.print(root.data+" ");
            printRange(root.right, n1, n2);
        }
        else if(root.data < n1){
            printRange(root.right, n1, n2);  
        }
        else{
            printRange(root.left, n1, n2);
        }
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i=0; i<path.size(); i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
    }

    public static void rootLeafPath(Node root,ArrayList<Integer> path){
        
        if(root == null){
            return ;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }

        rootLeafPath(root.left,path);
        rootLeafPath(root.right,path);

        path.remove(path.size()-1);
    }


    public static void main(String[] args) {
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();

        //System.out.println(searchBST(root, 7));

        //root = delete(root, 10);
        //inorder(root);

       // printRange(root, 3, 8);

       ArrayList<Integer> path = new ArrayList<>();
       rootLeafPath(root,path);
    }
}
