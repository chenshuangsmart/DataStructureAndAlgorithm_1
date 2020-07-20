package com.list;

/** 237. 删除链表中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @author chenshuang
 *
 */
public class _237_删除链表中的节点 {
	
	/**
	 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
	 * 4 -> 5 -> 1 -> 9
	 * 比如node=5，下面的方法实际是将1的值赋值给5，然后将1删除，实际就等于删除节点5了
	 * @param node
	 */
	public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
