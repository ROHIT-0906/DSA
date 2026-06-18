
public class QueueB {
    // static class Queue{
    //     static int arr[];
    //     static int size;
    //     static int rear;
    //     static int front;

    //     Queue(int n){
    //         arr = new int[n];
    //         size = n;
    //         rear = -1;
    //         front = -1;
    //     }

    //     public static boolean isEmpty(){
    //         return rear==-1 && front == -1;
    //     }

    //     //isfull
    //     public static boolean isFull(){
    //         return (rear+1)%size == front;
    //     }

    //     //add
    //     public static void add(int data){
    //         if(isFull()){
    //             System.out.println("Queue overflow");
    //             return;
    //         }
    //         if (front == -1) {
    //             front = 0;
    //         }
    //         rear = (rear+1) % size;
    //         arr[rear] = data;
    //     }

    //     //remove

    //     public static int remove(int data){
    //         if(isEmpty()){
    //             System.out.println("Queue is empty");
    //             return -1;
    //         }

    //         int result  = arr[front];
            
    //         if(front == rear){
    //             rear = front = -1;
    //         }else{
    //             front = (front + 1) % size;
    //         }
    //         return result;
    //     }

    //     public static int  peek(){
    //         if(isEmpty()){
    //             System.out.println("queue is empty");
    //             return -1;
    //         }

    //         return arr[front];

    //     }


    // }

    //USING NODE

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class Queue{
       static Node head = null;
       static Node tail = null;

       public static boolean isEmpty(){
        return head == null && tail == null;
    }

    public static void add(int data){

        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode; 
    }

    public static int remove(){
        if(isEmpty()){
            System.out.println("queue is empty");
            return -1;
        }

         int front = head.data;

        if(head == tail){
            head = tail = null;
        }else{
            head = head.next;
        }

       
        
        return front;

    }

    public static int peek(){
        if(isEmpty()){return -1;}
        return head.data;
    }

    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }

}
