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
class LL{
    ListNode head; // acts as head
    ListNode tail;
}
class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    
    ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }else{
            int len = length(head);
            
            //two halfs - first and second;
            ListNode first = head;
            ListNode second = first;
            int half = (len / 2) - 1;
            while(second != null && half > 0){
                second = second.next;
                half--;
            }
            ListNode temp = second.next;
            second.next = null;
            second = temp;
            
            first = mergeSort(first);
            second = mergeSort(second);
            
            return mergeLists(first, second);
            
        }
    }
    
    LL append(LL ll, ListNode node){
        if(ll.head == null){
            ll.head = node;
            ll.tail = node;
        }else{
            ll.tail.next = node;
            node.next = null;
            ll.tail = ll.tail.next;
        }
        return ll;
    }
    
    ListNode mergeLists(ListNode first, ListNode second){
        LL ll = new LL();
        
        if(first == null || second == null){
            return first == null ? second : first;
        }else{
            
            while(first != null && second != null){
                if(first.val < second.val){
                    ListNode next = first.next;
                    ll = append(ll, first);
                    first = next;
                }else{
                    ListNode next = second.next;
                    ll = append(ll, second);
                    second = next;
                }
            }
            
//             while(first != null){
//                 ListNode next = first.next;
//                 ll = append(ll, first);
//                 first = next;
//             }
            
//             while(second != null){
//                 ListNode next = second.next;
//                 ll = append(ll, second);
//                 second = next;
//             }
            
            ll.tail.next = (first != null)?first: second;
            
            return ll.head;
        }
    }
    
    int length(ListNode head){
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }
    
}