public class LinkedList {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next=null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        size++;
        Node newNode = new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        size++;
        Node newNode = new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void print(){
        if(head==null){
            System.out.println("LinkedList is empty");
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        size++;
        Node newNode = new Node(data);
        Node temp = head;
        int i=0;

        while(i<idx-1){
            i++;
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void removeFirst(){
        if(size==0){
            System.out.println("LinkedList is empty");
            return;
        }
        int val = head.data;
        
        if(size==1){
            head=tail=null;
            System.out.println(val);
            size--;
            return;
        }
        
        head = head.next;
        System.out.println(val);
        size--;
        return;
    }

    public void removeLast(){
        if(size==0){
            System.out.println("LinkedList is empty");
            return;
        }
        int val;
        
        if(size==1){
            val = head.data;
            head=tail=null;
            System.out.println(val);
            size--;
            return;
        }
        Node temp = head;
        for(int i=0; i<size-2; i++){
            temp = temp.next;
        }
        val = tail.data;
        temp.next = null;
        tail = temp;
        
        System.out.println(val);
        size--;
        return;
    }

    public int itrSearch(int key){
        Node temp = head;
        int i=0;
        while(temp!=null){
            if(temp.data == key)
                return i;
            
            temp = temp.next;
            i++;
        }
        return -1;

    }

    public int recSearch(Node head, int key){
        if(head==null)
            return -1;
        if(head.data == key)
            return 0;
        
            int idx = recSearch(head.next, key);
            if(idx== -1)
                return -1;
            
            return idx+1;
    }

    //Reverse the Linked List
    public void reverseLinkedList(){
        Node prev = null;
        Node curr=tail=head;
        Node next;

        while(curr!=null){
            next = curr.next;
            curr.next=prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public static void deleteNthNodefromEnd(int n){
        if(n==size){
            head = head.next;
        }
        Node prev = head;

        for(int i=1; i<size-n; i++){
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }

    public Node findMid(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next; 
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean checkPalindrome(){
        if(head == null || head.next==null){
            return true;
        }
        //find mid node
        Node midNode = findMid();

        // reverse the 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //check left half
        Node left = head;
        Node right = tail;
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public boolean isCycle(){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    public void removeCycle(){
        //detect cycle
        Node fast = head;
        Node slow = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast ){
                cycle = true;
                break;
            }
        }
        if(cycle = false){
            return;
        }

        //find meeting point
        slow = head;
        Node prev = fast;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        //remove cycle
        prev.next = null;
    }
    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    private Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        //find mid
        Node mid = getMid(head);
        //left & rigth MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //merge
        return merge(newLeft, newRight);
    }

    public void zigZag(){
        //find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
       // reverse 2nd half
       Node curr = mid.next;
       mid.next = null;
       Node prev = null;
       Node next;

       while(curr != null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
       }


       Node left = head;
       Node right = prev;
       Node nextL,nextR;

       //Zig Zag merge
       while(left != null && right != null){
        nextL = left.next;
        left.next = right;
        nextR = right.next;
        right.next = nextL;

        left = nextL;
        right = nextR;
       }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(2);
        // ll.addLast(1);


        //ll.add(0, 11);
        

        //ll.removeFirst();
        //ll.removeLast();
       
        // System.out.println(ll.size);
        
        //System.out.println(ll.itrSearch(3));
        //System.out.println(ll.recSearch(head, 3));


       // ll.print();
        // ll.reverseLinkedList();
        // ll.print();

        //deleteNthNodefromEnd(2);
        //ll.print(); 
        
        //System.out.println(ll.checkPalindrome());

        head = new Node(1);
        head.next = new Node(4);
        head.next.next = new Node(3);
        
        
       
        ll.print();
        ll.head = ll.mergeSort(head);
        ll.print();
        ll.zigZag();
        ll.print();

    }
    
}
