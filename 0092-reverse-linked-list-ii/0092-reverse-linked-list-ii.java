/**
 * Definition for singly-linked list.
 */
// public class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp= new ListNode(0);
        temp.next=head;

        ListNode leftNode=temp;
        ListNode currNode=head;
        for(int i=0;i<left-1;i++){
            leftNode=leftNode.next;
            currNode=currNode.next;
        }
        ListNode subNode=currNode;
        ListNode prev=null;
        for(int i=0;i<=right-left;i++){
            ListNode nextNode=currNode.next;
            currNode.next=prev;
            prev=currNode;
            currNode=nextNode;
        }
        leftNode.next=prev;
        subNode.next=currNode;
        return temp.next;
    }
}
