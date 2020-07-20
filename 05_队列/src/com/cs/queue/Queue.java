package com.cs.queue;

import com.cs.list.LinkedList;
import com.cs.list.List;

public class Queue<E> {
	private List<E> list = new LinkedList<>();
	
	/// 元素的大小
	public int size() {
		return list.size();
	}
	
	/// 是否为空
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/// 清空
	public void clear() {
		list.clear();
	}
	
	/// 入队
	public void enQueue(E element) {
		list.add(element);
	}
	
	/// 出队
	public E deQueue() {
		return list.remove(0);
	}
	
	/// 获取队列的头元素
	public E front() {
		return list.get(0);
	}
}
