package com.cs.list;

/**
 * 有动态缩容操作链表
 * @author chenshuang
 *
 */
public class ArrayList2<E> extends AbstractList<E> {
	/*
	 * 存放所有的元素
	 */
	private E[] elements;
	private static final int DEFAULT_CAPACITY = 10;
	
	public ArrayList2(int capacity) {
		capacity = capacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY : capacity;
		elements = (E[])new Object[capacity];
	}
	
	public ArrayList2() {
		this(DEFAULT_CAPACITY);
	}
	
	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		} 
		size = 0;
		
		// 如果容量已经超出默认容量，重新创建一个新的
		if (elements != null && elements.length > DEFAULT_CAPACITY ) {
			elements = (E[])new Object[DEFAULT_CAPACITY];
		}
	}
	
	@Override
	public E get(int index) {
		rangeCheck(index);
		
		return elements[index];
	}
	
	@Override
	public E set(int index, E element) {
		rangeCheck(index);
		
		E old = elements[index];
		elements[index] = element;
		return old;
	}
	
	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		rangeCheckForAdd(index);
		
		ensureCapacity(size + 1);
		
		for (int i = size; i > index; i--) {
			elements[i] = elements[i - 1];
		}
		elements[index] = element;
		size++;
	}
	
	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		rangeCheck(index);
		
		E oldElment = elements[index];
		for (int i = index + 1; i < size; i++) {
			elements[i - 1] = elements[i];
		}
		elements[--size] = null;
		
		trim();
		
		return oldElment;
	}
	
	@Override
	public int indexOf(E element) {
		// TODO Auto-generated method stub
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(elements[i])) {
					return i;
				}
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) {
			return;
		}
		
		// 新扩容为原来的1.5倍
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[])new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		
		System.out.println(oldCapacity + "扩容为" + newCapacity);
	}
	
	/**
	 * 缩容操作
	 */
	private void trim() {
		int oldCapacity = elements.length;
		int newCapacity = oldCapacity >> 1;
		// 不缩容，直接返回
		if (size > newCapacity || oldCapacity <= DEFAULT_CAPACITY) {
			return;
		}
		// 表示剩余空间还很多，需要缩容
		E[] newElements = (E[])new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		
		System.out.println(oldCapacity + "缩容为" + newCapacity);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer string = new StringBuffer();
		string.append("size = ").append(size).append(", [");
		
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(", ");
			} 
			string.append(elements[i]);
		}
		string.append("]");
		return super.toString();
	}
}
