import java.util.*;
import java.util.LinkedList;


public class QueueB {

    // // QUEUES USING ARRAYS
    // static class Queue {
        //     static int arr[];
        //     static int size;
        //     static int rear;
        //     // For Circular queue
        //     static int front;

    //     Queue(int n) {
    //         arr = new int[n];
    //         size = n;
    //         rear = -1;
    //         // For Circular queue
    //         front = -1;
    //     }
    
    //     public static boolean isEmpty() {
    //         return rear == -1 && front == -1;
    //     }
    
    //     // For Circular queue
    //     public static boolean isFull() {
    //         return (rear + 1) % size == front;
    //     }

    //     public static void add(int data) {
    //         if (isFull()) {
    //             System.out.println("Queue is full.");
    //             return;
    //         }
    //         // rear = rear + 1;

    //         // For Circular queue
    //         // adding first element
    //         if (front == -1) {
    //             front = 0;
    //         }
    //         rear = (rear + 1) % size;
    //         arr[rear] = data;
    //     }

    //     public static int remove() {
    //         if (isEmpty()) {
    //             System.out.println("Empty Queue.");
    //             return -1;
    //         }
    //         // int front = arr[0];
    //         // for(int i=0; i<rear; i++) {
    //         // arr[i] = arr[i+1];
    //         // // }
    //         // rear = rear - 1;
    //         // return front;

    //         // For Circular queue
    //         int result = arr[front];
    //         if (front == rear) {
        
    //             // last element delete
    //             rear = front = -1;
    //         } else {
        //             front = (front + 1) % size;
        //         }
        
        //         return result;
    //     }
    
    //     public static int peek() {
        //         if (isEmpty()) {
            //             System.out.println("Empty Queue.");
            //             return -1;
            //         }
            //         // return arr[0];
            //         return arr[front];
    //     }
    // }

    // // QUEUES USING LINKED LIST
    // static class Node {
    //     int data;
    //     Node next;

    //     Node(int data) {
    //         this.data = data;
    //         this.next = null;
    //     }
    // }
    // static class Queue {
    //     static Node head = null;
    //     static Node tail = null;
        
    //     public static boolean isEmpty() {
    //         return head==null && tail==null;
    //     }

    //     //add
    //     public static void add(int data) {
    //         Node newNode = new Node(data);
    //         if(isEmpty()) {
    //             head = tail = newNode;
    //         }
    //         tail.next = newNode;
    //         tail = newNode;
    //     }

    //     //remove
    //     public static int remove() {
    //         if(isEmpty()) {
    //             System.out.println("Empty Queue");
    //             return -1;
    //         }
    //         int front = head.data;
    //         if(head==tail) {
    //             head = tail = null;
    //         }
    //         else {
    //             head = head.next;
    //         }
    //         return front;
    //     }

    //     //peek
    //     public static int peek() {
    //         if(isEmpty()) {
    //             System.out.println("Empty Queue");
    //             return -1;
    //         }
    //         int front = head.data;
    //         return front;
    //     }
    // }

    // //QUEUE USING 2 STACKS
    // static class Queue {
    //     static Stack<Integer> s1 = new Stack<>();
    //     static Stack<Integer> s2 = new Stack<>();

    //     public static boolean isEmpty() {
    //         return s1.isEmpty() && s2.isEmpty();
    //     }

    //     public static void add(int data) {
    //         // if(isEmpty()) {
    //         //     s1.add(data);
    //         //     return;
    //         // }
    //         // while(!s1.isEmpty()) {
    //         //     s2.add(s1.peek());
    //         //     s1.pop();
    //         // }
    //         // s1.add(data);
    //         // while(!s2.isEmpty()) {
    //         //     s1.add(s2.peek());
    //         //     s2.pop();
    //         // }
    //         while(!s1.isEmpty()) {
    //             s2.push(s1.pop());
    //         }
    //         s1.push(data);
    //         while(!s2.isEmpty()) {
    //             s1.push(s2.pop());
    //         }
    //     }
        
    //     public static int remove() {
    //         if(isEmpty()) {
    //             System.out.println("Queue Empty");
    //             return -1;
    //         }
    //         return s1.pop();
    //     }
        
    //     public static int peek() {
    //         if(isEmpty()) {
    //             System.out.println("Queue Empty");
    //             return -1;
    //         }
    //         return s1.peek();
    //     }
    // }

    public static void firstNonrepeatLetter(String str) {
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for(int i=0; i<str.length(); i++) {
            char currChar = str.charAt(i);
            q.add(currChar);
            freq[currChar-'a']++;

            while(!q.isEmpty()) {
                if(freq[q.peek() - 'a'] > 1) {
                    q.remove();
                    if(q.isEmpty()) {
                        System.out.println(-1);
                    }
                }
                else {
                    System.out.println(q.peek());
                    break;
                }
            }
        }
    }

    public static void interleaveQueue(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();

        for(int i=0; i<size/2; i++) {
            firstHalf.add(q.remove());
        }

        while(!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    public static void queueReversal(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()) {
            s.push(q.remove());
        }

        while(!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void main(String[] args) {

        // Queue q = new Queue();
        // Queue<Integer> q = new ArrayDeque<>();
        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.remove();
        // q.add(4);
        // q.remove();
        // q.add(5);

        // while (!q.isEmpty()) {
        //     System.out.println(q.peek());
        //     q.remove();
        // }

        // String str = "aabccxb";
        // String str1 = "aadfcdgdfcgd";
        // firstNonrepeatLetter(str);
        // firstNonrepeatLetter(str1);

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
        // interleaveQueue(q);
        queueReversal(q);
        while(!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
