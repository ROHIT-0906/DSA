
import java.util.LinkedList;
import java.util.Stack;



public class IsPalindrome {
    // public static class Node{
    //     char data;
    //     Node next;
    //     Node(char data){
    //         this.data = data;
    //         this.next = null;
    //     }
    // }

    // public static Node head;

    // public static boolean isPalindrome( Node head){
    //     Stack<Character> stack = new Stack<>();
    //     Node temp = head;
    //     while(temp != null){
    //         stack.push(temp.data);
    //         temp = temp.next;
    //     }

    //     temp = head;

    //     while(temp != null){
    //         if(stack.pop() != temp.data){
    //             return false;
    //         }
    //         temp = temp.next;
    //     }

    //     return true;
    // }

    public static boolean isPalindrome(LinkedList<Character> ch){
        Stack<Character> stack = new Stack<>();

        for(Character c : ch){
            stack.push(c);
        }

        for(Character c :ch){
            if(!c.equals(stack.pop())){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Node ch1 = new Node('A');
        //  ch1.next = new Node('B');
        //  ch1.next.next = new Node('C');
        //  ch1.next.next.next = new Node('B');
        //  ch1.next.next.next.next = new Node('A');

        //  boolean result = isPalindrome(ch1);
        //  System.out.println(result);

        LinkedList<Character> ch = new LinkedList<>();
        ch.addLast('A');
        ch.addLast('B');
        ch.addLast('C');
        ch.addLast('D');
        ch.addLast('A');

        System.out.println(isPalindrome(ch));
    }

}
