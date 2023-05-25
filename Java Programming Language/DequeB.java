import java.util.*;
import java.util.LinkedList;

public class DequeB {

    static class Stack {
        static Deque<Integer> dq = new LinkedList<>();

        public boolean isEmpty() {
            return dq.isEmpty();
        }

        public void push(int data) {
            dq.addFirst(data);
        }

        public int pop() {
            int top = dq.getFirst();
            dq.removeFirst();
            return top;
        }

        public int peek() {
            return dq.getFirst();
        }
    }

    static class Queue {
        Deque<Integer> dq = new LinkedList<>();

        public boolean isEmpty() {
            return dq.isEmpty();
        }
        
        public void add(int data) {
            dq.addLast(data);
        }

        public int remove() {
            return dq.removeFirst();
        }

        public int peek() {
            return dq.getFirst();
        }
    }
    public static void main(String[] args) {
        // Deque<Integer> deque = new LinkedList<>();
        // deque.addFirst(1);
        // deque.addFirst(2);
        // deque.addLast(3);
        // deque.addLast(4);
        // System.out.println(deque);
        // deque.removeFirst();
        // deque.removeLast();
        // System.out.println(deque);
        // System.out.println("First element is " + deque.getFirst());
        // System.out.println("Last element is " + deque.getLast());

        // Stack s = new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // while(!s.isEmpty()) {
        //     System.out.println(s.pop());
        // }

        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
