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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        ListNode tail=head;
        int len=1;
        while(tail.next!=null){
            tail=tail.next;
            len++;
        }
        k=k%len;
        if(k==0){
            tail.next=null;
            return head;
        }
        tail.next=head;
        ListNode newLast=getLast(head,len-k);
        ListNode newHead=newLast.next;
        newLast.next=null;
        return newHead;
    }
    public static ListNode getLast(ListNode head,int n){
        ListNode temp=head;
        for(int i=0;i<n-1;i++){
            temp=temp.next;
        }
        return temp;
    }
}