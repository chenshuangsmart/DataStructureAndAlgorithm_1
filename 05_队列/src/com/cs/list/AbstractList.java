package com.cs.list;
import com.cs.list.List;

public abstract class AbstractList<E> implements List<E>{
	/*
	 * 元素的数量
	 */
	protected int size;

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public boolean contains(E element) {
		// TODO Auto-generated method stub
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}

	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		add(size, element);
	}

	protected void outOfBounds(int index) {
		throw new IndexOutOfBoundsException("Index:" + index + "Size:" + size);
	}
	
	/*
	 * 取值时校验范围，所以index必须小于size
	 */
	protected void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			outOfBounds(index);
		}
	}
	
	/*
	 * 添加元素时校验边距
	 */
	protected void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			outOfBounds(index);
		}
	}
}
