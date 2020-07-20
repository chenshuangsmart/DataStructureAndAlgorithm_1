package com.cs.list;
/**
 * 数组链表
 * @author chenshuang
 *
 * @param <E>
 */
public class ArrayList<E> extends AbstractList<E> {
	/*
	 * 存放所有的元素
	 */
	private E[] elements;
	private static final int DEFAULT_CAPACITY = 10;
	
	public ArrayList(int capacity) {
		capacity = capacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY : capacity;
		elements = (E[])new Object[capacity];
	}
	
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		} 
		size = 0;
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
