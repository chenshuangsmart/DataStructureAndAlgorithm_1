package com.list;

/** 141. 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * @author chenshuang
 *
 */
public class _141_环形链表 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        while (fastNode != null && fastNode.next != null) {
			if (slowNode == fastNode) {
				return true;
			}
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
		}
        return false;
    }
}
