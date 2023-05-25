import java.util.*;

public class Stacks {

    // //Stack using ArrayList
    // static class Stack {
    //     static ArrayList<Integer> list = new ArrayList<>();

    //     public static boolean isEmpty() {
    //     return list.size() == 0;
    //     }

    //     public static void push(int data) {
    //     list.add(data);
    //     }

    //     public static int pop() {
    //     if(isEmpty()) {
    //     return -1;
    //     }
    //     int top = list.get(list.size()-1);
    //     list.remove(list.size()-1);
    //     return top;
    //     }

    //     public static int peek() {
    //     if(isEmpty()) {
    //     return -1;
    //     }
    //     return list.get(list.size()-1);
    //     }
    // }


    // // Stack using Linked List
    // static class Node {
    //     int data;
    //     Node next;

    //     Node(int data) {
    //         this.data = data;
    //         this.next = null;
    //     }
    // }

    // static class Stack {
    //     static Node head = null;

    //     public static boolean isEmpty() {
    //         return head == null;
    //     }

    //     public static void push(int data) {
    //         Node newNode = new Node(data);

    //         if(isEmpty()) {
    //             head = newNode;
    //             return;
    //         }

    //         newNode.next = head;
    //         head = newNode;
    //     }

    //     public static int pop() {
    //         if(isEmpty()) {
    //             return -1;
    //         }

    //         int top = head.data;
    //         head = head.next;
    //         return top;
    //     }

    //     public static int peek() {
    //         if(isEmpty()) {
    //             return -1;
    //         }
    //         return head.data;
    //     }
    // }

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            s.push(str.charAt(i));
        }
 
        StringBuilder ans = new StringBuilder(""); 
        while(!s.isEmpty()) {
            ans.append(s.pop());
        }

        return ans.toString();
    }

    public static void reverseStack(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i=1; i<stocks.length; i++) {
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                span[i] = i+1;
            }
            else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }

    public static void nextGreaterElem(int arr[], int nextGreater[]) {
        Stack<Integer> s = new Stack<>();

        for(int i=arr.length-1; i>=0; i--) {
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nextGreater[i] = -1;
            }
            else {
                nextGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }

    public static boolean validParantheses(String str) {
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '{' || str.charAt(i) == '(' || str.charAt(i) == '[') {
                s.push(str.charAt(i));
            }
            else if(s.isEmpty()) {
                return false;
            }
            else if((s.peek()=='{' && str.charAt(i)=='}') || 
            (s.peek()=='(' && str.charAt(i)==')') || 
            (s.peek()=='[' && str.charAt(i)==']')) {
                s.pop();
            }
            else {
                return false;
            }
        }
        if(s.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean hasDuplicates(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch!=')') {
                s.push(ch);
            }
            else {
                int count = 0;
                while(s.peek()!='(') {
                    s.pop();
                    count++;
                }
                s.pop();
                if(count==0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void printStack(Stack<Integer> s) {
        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void main(String[] args) {
        // Stack s = new Stack();
        // Stack<Integer> s = new Stack<>();

        // s.push(1);
        // s.push(2);
        // s.push(3);

        // while (!s.isEmpty()) {
        //     System.out.println(s.peek());
        //     s.pop();
        // }

        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // pushAtBottom(s, 4);

        // while (!s.isEmpty()) {
        //     System.out.println(s.pop());
        // }

        // String str = "abc";
        // System.out.println(reverseString(str));

        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // //3,2,1
        // reverseStack(s);
        // printStack(s);  //1,2,3

        // int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        // int span[] = new int[stocks.length];
        // stockSpan(stocks, span);
        
        // for(int i=0; i<span.length; i++) {
        //     System.out.println(span[i]);
        // }

        // int arr[] = {6,8,0,1,3};
        // int nextGreater[] = new int[arr.length];
        // nextGreaterElem(arr, nextGreater);
        // for(int i=0; i<arr.length; i++) {
        //     System.out.println(nextGreater[i]);
        // }

        // String str = "[()]";
        // System.out.println(validParantheses(str));

        String str = "(((a+b)+(c+d)))";
        String str2 = "(a-b)";
        System.out.println(hasDuplicates(str));
    }
}
