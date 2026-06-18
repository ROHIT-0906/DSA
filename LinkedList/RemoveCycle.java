public class RemoveCycle {
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

    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void removeCycle(){
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                cycle = true;
                break;
            }
        }

        if(cycle == false){
            return;
        }

        slow = head;
        Node prev = null;
        while(slow != fast){
            prev = fast;
            slow =slow.next;
            fast = fast.next;
        }

        prev.next = null;
    }


    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        // find mid
        Node mid = getMid(head);

        Node rightHead = mid.next;
        mid.next = null;
        Node newLeftHead = mergeSort(head);
        Node newRightHead = mergeSort(rightHead);

        return merge(newLeftHead, newRightHead);
    }

    private Node merge(Node head, Node rightHead){
        Node dummy = new Node(-1);
        Node temp = dummy;
        while(head != null && rightHead != null){
            if(head.data<=rightHead.data){
                temp.next = head;
                head = head.next;
                temp = temp.next;
            }else{
                temp.next = rightHead;
                rightHead = rightHead.next;
                temp = temp.next;
            }
        }

        while(head != null){
            temp.next = head;
            head = head.next;
            temp = temp.next;

        }
        while(rightHead != null){
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;

        }

        return dummy.next;

    }

    public void zigzag(){
        //find mid 
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        //reverse 2nd half
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

        Node left = head ;
        Node right = prev;
        Node nextL, nextR;

        //alt-merge, zig-zag merge

        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            
            left = nextL;
            right = nextR;
        }

    }

    public void addLast(int data){
        //Node creation
        Node newNode = new Node(data);
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
            System.out.print(temp.data + "->");
            temp = temp.next;
            if(temp == null){
                System.out.print("null");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;

        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        RemoveCycle ll = new RemoveCycle();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        ll.printLinkedList();

        // ll.head = ll.mergeSort(ll.head);
        ll.zigzag();
        ll.printLinkedList();

    }

}
