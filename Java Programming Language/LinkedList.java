public class LinkedList {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {

        // step 1 - create new node
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step 2 - new node's next = head
        newNode.next = head;
        // step 3 - head = newNode
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;

    }

    public void print() {
        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void addMiddle(int index, int data) {

        if (index == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {

        if (size == 0) {
            System.out.println("LL is empty.");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {

        if (size == 0) {
            System.out.println("LL is empty.");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = tail.data;
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        tail = temp;
        tail.next = null;
        size--;
        return val;
    }

    public int iterativeSearch(int key) { // O(n)
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public int helperFn(int key, Node temp) {
        if (temp == null) {
            return -1 - size;
        }

        if (temp.data == key) {
            return 0;
        }

        return helperFn(key, temp.next) + 1;
    }

    public int recursiveSearch(int key) {
        return helperFn(key, head);
    }

    public void reverse() { // O(n)
        Node prev = head;
        Node curr = head.next;
        Node next;

        tail = prev;
        prev.next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public int removeNthFromEnd(int n) {
        Node temp = head;

        if (n == size) {
            removeFirst();
        } else if (n > size || n == 0) {
            System.out.println("The node does not exist in Linked List.");
            return Integer.MIN_VALUE;
        }
        for (int i = 0; i < size - n - 1; i++) {
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = temp.next.next;
        return val;
    }

    // Slow-Fast Approach (Step-1)
    public Node findMidNode(Node head) { // helper fn
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }
        return slow; // slow is my middle
    }

    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        // step 1 - find midNode
        Node midNode = findMidNode(head);

        // step 2 - reverse the 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;

        // step 3 - check left half and right half
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static boolean isCycle() { // Floyd's CFA
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycle() {
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        if (cycle == false) {
            return;
        }
        
        // find meeting point
        slow = head;
        Node prev = null;  //last node
        while (slow != fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }
        
        // remove cycle -> last.next = null
        prev.next = null;
    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; //midNode
    }

    public Node mergeSort(Node head) {  //O(nlogn)
        if(head==null || head.next==null) {
            return head;
        }

        //find mid
        Node mid = getMid(head);

        //left & right MS
        Node rightHead = mid.next;
        mid.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //merge
        return merge(newLeft, newRight);
    }

    private Node merge(Node left, Node right) {
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while(left!=null && right!=null) {
            if(left.data < right.data) {
                temp.next = left;
                left = left.next;
                temp = temp.next;
            }
            else {
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }
        
        while(left!=null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }

        while(right!=null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }

    public void zigzag() {

        //find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr= next;
        }

        //alternate merging - zig-zag merging
        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        while(left != null && right != null) {
            nextL = left.next;
            nextR = right.next;
            left.next = right;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }

    }

    public static void main(String[] args) {
        // LinkedList ll = new LinkedList();
        // ll.addFirst(3);
        // ll.addFirst(2);
        // ll.addLast(4);
        // ll.addLast(5);
        // ll.addMiddle(0, 1);
        // ll.print();
        // System.out.println(ll.size);

        // ll.removeFirst();
        // ll.print();

        // ll.removeLast();
        // ll.print();
        // System.out.println(ll.size);

        // System.out.println(ll.iterativeSearch(4));
        // System.out.println(ll.recursiveSearch(2));

        // ll.reverse();
        // ll.print();

        // ll.removeNthFromEnd(3);
        // ll.print();

        // LinkedList ll = new LinkedList();
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(1);
        // ll.addLast(1);

        // System.out.println(ll.checkPalindrome());

        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // // 1->2->3->2
        
        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        // LinkedList ll = new LinkedList();
        // ll.addLast(10);
        // ll.addLast(1);
        // ll.addLast(3);
        // ll.addLast(11);
        // ll.addLast(6);

        // ll.print();
        // ll.head = ll.mergeSort(ll.head);
        // ll.print();

        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        ll.print();
        ll.zigzag();
        ll.print();
    }
}
