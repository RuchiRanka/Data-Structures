import java.util.PriorityQueue;
import java.util.Comparator;


public class PQ {

    static class Student implements Comparable<Student> {
        String name;
        int rank;
    
        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }
    
        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        // PriorityQueue<Student> pq = new PriorityQueue<>();
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // pq.add(5);
        // pq.add(2);
        // pq.add(6);
        // pq.add(1);

        pq.add(new Student("A",12));
        pq.add(new Student("B",5));
        pq.add(new Student("C",4));
        pq.add(new Student("D",2));

        while(!pq.isEmpty()) {
            // System.out.println(pq.peek());
            System.out.println(pq.peek().name + " -> " + pq.peek().rank);
            pq.remove();
        }
    }
}
