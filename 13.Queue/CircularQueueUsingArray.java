public class CircularQueueUsingArray {
    
public static class CircularQueue{
        static int arr[];
        static int size;
        static int rear;
        static int front;

        CircularQueue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty(){
            return rear == -1;
        }

        public static boolean isFull(){
            return (rear+1)%size == front;
        }

        public static void add(int data){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }

            rear = (rear +1)%size;
            arr[rear] = data;

        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            front = (front+1)%size;
            int result = arr[front];
            if(front == rear){
                front = rear = -1;
            }
            return result;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            return arr[front];

        }
    }
    


    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(5);

        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
        
    }
}

