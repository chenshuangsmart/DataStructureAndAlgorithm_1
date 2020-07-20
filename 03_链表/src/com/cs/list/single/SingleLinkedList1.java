package com.cs.list.single;

import com.cs.list.AbstractList;

/**
 * 增加一个虚拟头结点
 * @author chenshuang
 *
 */
public class SingleLinkedList1<E> extends AbstractList<E>{
	private Node<E> first;
	
	public SingleLinkedList1() {
		first = new Node<>(null,null);
	}
	
	private static class Node<E> {
		E element;
		Node<E> next;
		
		public Node(E element,Node<E> next) {
			this.element = element;
			this.next = next;
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		first = null;
		size = 0;
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
		
		Node<E> prevNode = index == 0 ? first : node(index - 1);
		prevNode.next = new Node<E>(element, prevNode.next);
		
		size++;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		
		Node<E> prevNode = index == 0 ? first : node(index - 1);
		Node<E> node = prevNode.next;
		prevNode.next = node.next;
		
		size--;
		
		return node.element;
	}

	@Override
	public int indexOf(E element) {
		if (element == null) {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (node.element == null) return i;
				
				node = node.next;
			}
		} else {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (element.equals(node.element)) return i;
				
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
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(", ");
			}
			
			string.append(node.element);
			
			node = node.next;
		}
		string.append("]");
		return string.toString();
	}
}
