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
class Node{
    ListNode head;
    ListNode tail;
}
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return head;
        }
        
        Node odd = new Node();
        Node even = new Node();
        ListNode it = head;
        boolean flag = false;
        while(it != null){
            ListNode temp = it.next;
            it.next = null;
            if(flag == false){
                odd = append(odd, it);
                flag = true;
            }else{
                even = append(even, it);
                flag = false;
            }
            it = temp;
        }

        odd.tail.next = even.head;
        return odd.head;
    }
    Node append(Node hNode, ListNode node){
        if(hNode.head == null){
            hNode.head = node;
            hNode.tail = node;
        }else{
            hNode.tail.next = node;
            hNode.tail = node;
        }
        return hNode;
    }
}