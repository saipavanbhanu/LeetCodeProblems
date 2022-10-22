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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n == 1){
            return null;
        }
        
        int len = 0;
        ListNode it = head;
        while(it != null){
            len++;
            it = it.next;
        }
        
        int count = len - n - 1;
        it = head;
        if(count == -1){
            it = it.next;
            return it;
        }
        
        while( count > 0 ){
            it = it.next;
            count--;
        }
        
        
        if(it.next != null){
            ListNode temp = it.next;
            it.next = it.next.next;
            temp.next = null;    
        }else{
            it.next = null;
        }
        return head;
    }
}