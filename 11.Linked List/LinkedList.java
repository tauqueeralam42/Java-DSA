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

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.add(0, 11);
        ll.print();

        ll.removeFirst();
        ll.removeLast();
       
        ll.print();
        System.out.println(ll.size);

        System.out.println(ll.itrSearch(3));
    }
    
}
