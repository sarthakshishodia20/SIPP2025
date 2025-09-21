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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        int groupSize = 1;
        ListNode temp = head;
        while (temp != null) {
            ArrayList<Integer> list = new ArrayList<>();
            int count = 0;
            while (temp != null && count < groupSize) {
                list.add(temp.val);
                temp = temp.next;
                count++;
            }
            lists.add(list);
            groupSize++;
        }
        for (ArrayList<Integer> l : lists) {
            if (l.size() % 2 == 0) {
                Collections.reverse(l);
            }
        }
        temp = head;
        for (ArrayList<Integer> a : lists) {
            for (int i = 0; i < a.size(); i++) {
                temp.val = a.get(i);
                temp = temp.next;
            }
        }
        return head;
    }
}
