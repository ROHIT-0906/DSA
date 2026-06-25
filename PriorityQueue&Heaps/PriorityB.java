
import java.util.PriorityQueue;

public class PriorityB {

    // Aise class use karke hm custom objects bana skte hai jo ke hamae kisi bhi chij ko
    //priority wise compare karne me help karte hai
    public static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }
    
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("Rohit", 10));
        pq.add(new Student("Aryan", 22));
        pq.add(new Student("Shivam", 15));
        pq.add(new Student("Krish", 12));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name + "->"+ pq.peek().rank);
            pq.remove();
        }
    }
}
