//2. Add Two Numbers

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int sum = temp1.val+temp2.val;
        int carry=0;
        ListNode ansTemp = new ListNode((sum%10) + carry);
        if(sum>9) {
            carry=1;
        }
        temp1 = temp1.next;
        temp2 = temp2.next;
        ListNode ans = ansTemp;
        while(temp1 != null && temp2 != null) {
            sum = temp1.val+temp2.val+carry;
            ansTemp.next = new ListNode(sum%10);

            if(carry==1) {
                carry=0;
            }

            if(sum>9) {
                carry=1;
            }

            temp1 = temp1.next;
            temp2 = temp2.next;
            ansTemp = ansTemp.next;
        }

        while(temp1 != null) {
            sum=temp1.val+carry;
            ansTemp.next = new ListNode((sum)%10);

            if(carry==1) {
                carry=0;
            }

            if(sum>9) {
                carry=1;
            }

            temp1 = temp1.next;
            ansTemp = ansTemp.next;
        }

        while(temp2 != null) {
            sum=temp2.val+carry;
            ansTemp.next = new ListNode(sum%10);

            if(carry==1) {
                carry=0;
            }

            if(sum>9) {
                carry=1;
            }

            temp2 = temp2.next;
            ansTemp = ansTemp.next;
        }

        if(carry==1) {
            ansTemp.next = new ListNode(1);
        }

        return ans;
    }
}