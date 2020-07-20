package com.list;

/* 206. 反转链表
 *	https://leetcode-cn.com/problems/reverse-linked-list/ 
 */
public class _206_反转链表 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/// 采用递归实现
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newNode = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newNode ;
    }
	
	/// 采用迭代实现
	public ListNode reverseList1(ListNode head) {
		return null;
	}

}
