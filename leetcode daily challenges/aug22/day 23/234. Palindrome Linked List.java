/*
Given the head of a singly linked list, return true if it is a palindrome.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false*/

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
    public boolean isPalindrome(ListNode head) {
        ListNode fast=head;
        ListNode slow=head; // to find midpoint
        
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next; //moves two times
        }
        //reverse and check
        ListNode revHead=reversed(slow); //after rev head changes
    
        while(revHead!=null)
        {
            if(revHead.val != head.val) // checks both vaue equal 1 2 || 1 2 
            {
                return false;
            }
            revHead=revHead.next;
            head=head.next;
        }
        return true;
    } 
    
    public ListNode reversed(ListNode head)
    {
        ListNode prev=null;
        while(head!=null)
        {
             ListNode temp=head.next;
             head.next=prev; // try to turn the nodes backwards
             prev=head;
             head=temp;
        }
        return prev;
    }
}
