class Solution {
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newNode = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = reverse(l1);
        ListNode head2 = reverse(l2);
        int carry = 0;
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        ListNode dummy = new ListNode(-1);
        ListNode currNode = dummy;

        while(temp1 != null || temp2 != null){
            int sum = carry;
            if(temp1 != null){
                sum += temp1.val;
                temp1 = temp1.next;
            }
            if(temp2 != null){
                sum += temp2.val;
                temp2 = temp2.next;
            }
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            currNode.next = newNode;
            currNode = currNode.next;
        }

        if(carry > 0){
            currNode.next = new ListNode(carry);
        }

        return reverse(dummy.next);
    }
}
