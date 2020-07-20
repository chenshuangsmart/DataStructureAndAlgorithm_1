package com.cs;

public class ArrayList<E> {
	private int size;	// 元素的数量
	private E[] elements;	// 所有的元素
	private static final int DEFAULT_CAPACITY = 10;	// 默认数组容量大小
	private static final int ELEMENT_NOT_FOND = -1;	// 元素未找到
	
	public ArrayList(int capacity) {
		capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
		elements = (E[])new Object[capacity];
	}
	
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	/// 清除所有元素
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}
	
	/// 元素的数量
	public int size() {
		return size;
	}
	
	/// 是否为空
	public boolean isEmpty() {
		return size == 0;
	}
	
	/// 是否包含元素
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOND;
	}
	
	/// 添加元素到尾部
	public void add(E element) {
		add(size, element);
	}
	
	/// 获取index位置的元素
	public E get(int index) {
		rangeCheck(index);
		return elements[index];
	}
	
	/// 设置index位置的元素
	public E set(int index,E element) {
		rangeCheck(index);
		E oldElement = elements[index];
		elements[index] = element;
		return oldElement;
	}
	
	/// 在index位置插入一个元素
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		
		ensureCapacity(size + 1);
		
		for (int i = size; i > index; i--) {
			elements[i] = elements[i-1];
		}
		elements[index] = element;
		size++;
	}
	
	/// 删除index位置的元素
	public E remove(int index) {
		rangeCheck(index);
		
		E oldElement = elements[index];
		
		for (int i = index; i < size - 1; i++) {
			elements[i] = elements[i+1];
		}
		// 元素个数减一，并且最后一个元素赋值为空
		elements[--size] = null;
		return oldElement;
	}
	
	/// 查看元素的索引
	public int indexOf(E element) {
		if (element == null) {	// 返回数组中第一个为空的索引
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (elements[i].equals(element)) {
					return i;
				}
			}
		}
		return ELEMENT_NOT_FOND;
	}
	
	/// 保证要有capacity的容量
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) {
			return;	// 容量够
		}
		
		// 新容量为旧容量的1.5倍
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[])new Object[newCapacity];
		
		// 依次赋值
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		System.out.println(oldCapacity + "扩容为" + newCapacity);
	}
	
	/// 校验数组是否越界
	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			outOfBounds(index);
		}
	}
	
	/// 添加元素时，校验数组是否越界
	private void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			outOfBounds(index);
		}
	}
	
	/// 数组越界报错
	private void outOfBounds(int index) {
		throw new IndexOutOfBoundsException("Index:" + index + "Size:" + size);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// 打印完整的数组元素
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("size:").append(size).append(", [");
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				stringBuffer.append(", ");
			}
			stringBuffer.append(elements[i]);
		}
		stringBuffer.append("]");
		return stringBuffer.toString();
	}
}
