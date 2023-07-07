import java.util.*;
import java.util.LinkedList;

import org.w3c.dom.Node;

public class KthLevel {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static void kthLevel(Node root, int level, int k){
        if(root == null){
            return;
        }
        if(level == k){
            System.out.print(root.data+" ");
            return;
        }

        kthLevel(root.left, level+1, k);
        kthLevel(root.right, level+1, k);
    }

    //iterartively
    public static void kLvlItr(Node root, int k){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        int lv = 1;
        while(lv<k){
            Node curr = q.remove();
            if(curr == null){
                lv++;
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                if(curr.left != null ){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }

            }
        }
        if(lv == k){
            while(q.peek() != null){
                System.out.print(q.remove().data+" ");
            }
        }
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

    kthLevel(root, 1, 3);
    System.out.println();

    kLvlItr(root, 2);
        
    }
    
}


