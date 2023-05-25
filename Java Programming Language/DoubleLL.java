public class DoubleLL {
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    //add
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if(head==null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head==null) {
            head = tail = newNode;
            return;
        }

        newNode.prev = tail;
        tail.next = newNode;
        tail = tail.next;
    }

    //remove
    public int removeFirst() {
        if(head==null) {
            System.out.println("DLL is empty.");
            return Integer.MIN_VALUE;
        }
        if(head.next==null) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public int removeLast() {
        if(head==null) {
            System.out.println("DLL is empty.");
            return Integer.MIN_VALUE;
        }

        if(head.next==null) {
            int val = head.data;
            head = tail = null;
            size = 0; 
            return val;
        }

        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }

    //print
    public void print() {
        Node temp = head;
        // System.out.print("null <-> ");
        while(temp!=null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.print(temp);
        System.out.println();
    }

    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public static void main(String args[]) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(4);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(5);

        // dll.print();
        // System.out.println(dll.size);
        
        // dll.removeFirst();
        // dll.print();
        // System.out.println(dll.size);
        
        // dll.removeLast();
        // dll.print();
        // System.out.println(dll.size);

        dll.print();
        dll.reverse();
        dll.print();
    }
}
