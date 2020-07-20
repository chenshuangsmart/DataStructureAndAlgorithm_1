package com.cs.queue.circle;

/**
 * 循环单队列 - 使用数组实现 - 可以进行两端添加，删除操作的循环队列
 * @author chenshuang
 *
 */
public class CircleQueue<E> {
	
	private int front;	// 队头的位置
	private int size;	// 元素个数
	private E[] elements;	// 数组
	private static final int DEFAULT_CAPACITY = 10;	// 默认空间大小
	
	public CircleQueue() {
		elements = (E[])new Object[DEFAULT_CAPACITY];
	}
	
	/// 元素个数
	public int size() {
		return size;
	}
	
	/// 是否为空
	public boolean isEmpty() {
		return size == 0;
	}
	
	/// 清除
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[index(i)] = null;
		}
		size = 0;
		front = 0;
	}
	
	/// 入队
	public void enQueue(E element) {
		ensureCapacity(size + 1);
		
		elements[index(size)] = element;
		size++;
	}
	
	/// 出队
	public E deQueue() {
		E frontElement = elements[front];
		elements[front] = null;
		front = index(1);	// 重置front
		size--;
		return frontElement;
	}
	
	/// 获取队头元素
	public E front() {
		return elements[front];
	}
	
	/// 获取该元素在数组中真实位置的索引
	private int index(int index) {
		index += front;
//		return index % elements.length;	// 该写法比较消耗性能
		return index - (index >= elements.length ? elements.length : 0);
	}
	
	///保证要有capacity的容量
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) {
			return;
		}
		
		// 新容量为原来的1.5倍
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[index(i)];
		}
		elements = newElements;
		
		// 重置front
		front = 0;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("capacity = ").append(elements.length);
		strBuffer.append(" size = ").append(size);
		strBuffer.append(", [");
		
		for (int i = 0; i < elements.length; i++) {
			if (i != 0) {
				strBuffer.append(", ");
			}
			strBuffer.append(elements[i]);
		}
		strBuffer.append("]");
		return strBuffer.toString();
	}
}
