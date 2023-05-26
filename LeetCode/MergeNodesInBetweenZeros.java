//2181. Merge Nodes in Between Zeros

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head.next;
        ListNode zeroNode = new ListNode();
        int startPt = 1;
        ListNode ansTemp = zeroNode;
        while(temp != null) {
            int sum = 0;
            while(temp.val != 0) {
                sum += temp.val;
                temp = temp.next;
            }
            if(startPt==1) {
                zeroNode.val = sum;
                startPt=0;
            } else {
                zeroNode.next = new ListNode(sum);
                zeroNode = zeroNode.next;
            }
            temp = temp.next;
        }
        return ansTemp;
    }
}