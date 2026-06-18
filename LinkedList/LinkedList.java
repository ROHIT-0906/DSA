
public class LinkedList {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;

        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        //'Node creation'
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        //Next main agle node ka value set kiya 
        newNode.next = head;

        //head newNode ko assign ho jayega
        head = newNode;
    }

    public void addLast(int data){
        //Node creation
        Node newNode = new Node(data);
        size++;
        if(head == null){
           head = tail = newNode;
            return;
        }
        tail.next = newNode;

        tail = newNode;

    }

    public void printLinkedList(){
        if(head == null){
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void add(int idx, int data){
        if(idx == 0 ){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while(i<idx-1){
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            return val;
        }
        int val = head.data;
        head =  head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size == 0 ){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head  = tail = null;
            size = 0;
            return val;
        }

        Node prev = head;
        for(int i = 0; i<size-2; i++){
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }

        if(head.data == key){
            return 0;
        }

        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }
        return idx + 1;
    }

    public int recSearch(int key){
        return helper(head, key);
    }

    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthNode(int n){
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }

        if(n == sz){
            head = head.next;
            return;
        }

        int i = 1;
        int iToFind = sz-n;
        Node prev = head;
        
        while(i< iToFind){
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;

    }


    private Node findMidNode(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean checkPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        //find mid
        Node midNode = findMidNode(head);

        //reverse 2nd half
        Node curr = midNode;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;

        while(right != null){
            if(left.data != right.data){
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        // ll.printLinkedList();
        ll.addFirst(1);
        // ll.printLinkedList();
        ll.addLast(2);
        // ll.printLinkedList();
        ll.addLast(3);
        // ll.printLinkedList();
        // ll.add(2, 5);
        // ll.removeFirst();
        // ll.removeLast();
        // ll.reverse();
        // ll.deleteNthNode(3);
        ll.printLinkedList();
        System.out.println(ll.checkPalindrome());
        // System.out.println(ll.size);

        // System.out.println(ll.recSearch(5));
    }
    
}