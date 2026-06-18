import java.util.*;

public class QueueQ {
    // public static void printNonRepeating(String str){
    //     int[] freq = new int[26];
    //     Queue<Character> q = new LinkedList<>();

    //     for(int i=0; i<str.length(); i++){
    //         char ch = str.charAt(i);
    //         q.add(ch);
    //         freq[ch-'a']++;
    //          while(!q.isEmpty() && freq[q.peek() - 'a'] > 1){
    //             q.remove();
    //          }

    //          if(q.isEmpty()){
    //             System.out.print("-1"+" ");
    //          }else{
    //             System.out.print(q.peek()+" ");
    //          }
    //     }
    //     System.out.println();

    // }

    // public static Queue interLeave(Queue<Integer> q){
    //     int halfsize = q.size() /2 ;

    //     Queue<Integer> q1 = new LinkedList<>();
        
    //     for(int i=0; i<halfsize; i++){
    //         q1.add(q.remove());
    //     }

    //     while(!q1.isEmpty()){
    //         q.add(q1.remove());
    //         q.add(q.remove());
    //     }

    //     return q;

    // }

    public static Queue reversQueue(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }

        while(!s.isEmpty()){
            q.add(s.pop());
        }

        return q;

    }

    public static void main(String[] args) {
        // String str = "gghhhooebcfebc";
        // printNonRepeating(str);

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        // System.out.println(interLeave(q));
        System.out.println(reversQueue(q));
    }
}
