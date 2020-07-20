package com.cs.list.circle;

import com.cs.list.AbstractList;

public class SingleCircleLinkedList<E> extends AbstractList<E> {
	private Node<E> first;
	
	private static class Node<E> {
		E element;
		Node<E> next;
		
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			StringBuffer sb = new StringBuffer();
			sb.append(element).append("_").append(next.element);
			return sb.toString();
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		size = 0;
		first = null;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return node(index).element;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		Node<E> node = node(index);
		E old = node.element;
		node.element = element;
		return old;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		rangeCheckForAdd(index);
		
		if (index == 0) {
			Node<E> newFirstNode = new Node<E>(element, first);
			// 获取到最后一个节点
			Node<E> lastNode = (size == 0) ? newFirstNode : node(size - 1);
			lastNode.next = newFirstNode;
			first = newFirstNode;
		} else {
			Node<E> prevNode = node(index - 1);
			prevNode.next = new Node<E>(element, prevNode.next);
		}
		size++;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		rangeCheck(index);
		
		Node<E> node = first;
		if (index == 0) {
			if (size == 1) {
				 first = null;
			} else {
				Node<E> lasNode = node(size - 1);
				first = first.next;
				lasNode.next = first;
			}
		} else {
			Node<E> prevNode = node(index - 1);
			node = prevNode.next;
			prevNode.next = node.next;
		}
		size--;
		return node.element;
	}

	@Override
	public int indexOf(E element) {
		// TODO Auto-generated method stub
		if (element == null) {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (node.element == null) {
					return i;
				}
				node = node.next;
			}
		} else {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (element.equals(node.element)) {
					return i;
				}
				node = node.next;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	/**
	 * 获取index位置对应的节点对象
	 * @param index
	 * @return
	 */
	private Node<E> node(int index) {
		rangeCheck(index);
		
		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		
		return node;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("size = ").append(size).append(", [");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				sb.append(", ");
			}
			sb.append(node);
			node = node.next;
		}
		sb.append("]");
		return sb.toString();
	}
}
