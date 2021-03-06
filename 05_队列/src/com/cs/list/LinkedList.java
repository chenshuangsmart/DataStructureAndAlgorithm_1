//package com.cs.list;
//
//import javax.naming.ldap.PagedResultsControl;
//
//public class LinkList<E> extends AbstractList<E> {
//	private Node<E> first;
//	private Node<E> last;
//	
//	private static class Node<E> {
//		E element;
//		Node<E> prev;
//		Node<E> next;
//		
//		public Node(Node<E>prev,E element,Node<E> next) {
//			this.prev = prev;
//			this.element = element;
//			this.next = next;
//		}
//		
//		@Override
//		public String toString() {
//			// TODO Auto-generated method stub
//			StringBuffer stringBuffer = new StringBuffer();
//			
//			if (prev != null) {
//				stringBuffer.append(prev.element);
//			} else {
//				stringBuffer.append("null");
//			}
//			
//			stringBuffer.append("_").append(element).append("_");
//			
//			if (next != null) {
//				stringBuffer.append(next.element);
//			} else {
//				stringBuffer.append("null");
//			}
//			
//			return stringBuffer.toString();
//		}
//	}
//
//	@Override
//	public void clear() {
//		// TODO Auto-generated method stub
//		size = 0;
//		first = null;
//		last = null;
//	}
//
//	@Override
//	public E get(int index) {
//		// TODO Auto-generated method stub
//		return node(index).element;
//	}
//
//	@Override
//	public E set(int index, E element) {
//		// TODO Auto-generated method stub
//		Node<E> node = node(index);
//		E old = node.element;
//		node.element = element;
//		return old;
//	}
//
//	@Override
//	public void add(int index, E element) {
//		// TODO Auto-generated method stub
//		rangeCheckForAdd(index);
//		
//		if (index == size) {	// 在最后面添加元素
//			Node<E> oldLast = last;
//			last = new Node<E>(oldLast, element, null);
//			if (oldLast == null) {
//				first = last;
//			} else {
//				oldLast.next = last;
//			}
//		} else {
//			Node<E> nextNode = node(index);
//			Node<E> prevNode = nextNode.prev;
//			Node<E> newNode = new Node<E>(prevNode, element, nextNode);
//			nextNode.prev = newNode;
//			
//			if (prevNode == null) {	// index = 0
//				first = newNode;
//			} else {
//				prevNode.next = newNode;
//			}
//		}
//		size++;
//	}
//
//	@Override
//	public E remove(int index) {
//		// TODO Auto-generated method stub
//		rangeCheck(index);
//		
//		Node<E> node = node(index);
//		Node<E> prev = node.prev;
//		Node<E> next = node.next;
//		
//		if (prev == null) {	// index == 0
//			first = next;
//		} else {
//			prev.next = next;
//		}
//		
//		size--;
//		return node.element;
//	}
//
//	@Override
//	public int indexOf(E element) {
//		if (element == null) {
//			Node<E> node = first;
//			for (int i = 0; i < size; i++) {
//				if (node.element == null) {
//					return i;
//				}
//				node = node.next;
//			}
//		} else {
//			Node<E> node = first;
//			for (int i = 0; i < size; i++) {
//				if (element.equals(node.element)) {
//					return i;
//				}
//				node = node.next;
//			}
//		}
//		return ELEMENT_NOT_FOUND;
//	}
//	
//	/**
//	 * 获取index位置对应的节点对象
//	 * @param index
//	 * @return
//	 */
//	private Node<E> node(int index) {
//		rangeCheck(index);
//		
//		if (index < (size >> 1)) {	// 在左半区
//			Node<E> node = first;
//			for (int i = 0; i < index; i++) {
//				node = node.next;
//			}
//			return node;
//		} else {
//			Node<E> node = last;
//			for (int i = size - 1; i > index; i--) {
//				node = node.prev;
//			}
//			return node;
//		}
//	}
//	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		StringBuffer stringBuffer = new StringBuffer(); 
//		stringBuffer.append("size = ").append(size).append(" [");
//		Node<E> node = first;
//		for (int i = 0; i < size; i++) {
//			if (i != 0) {
//				stringBuffer.append(", ");
//			}
//			stringBuffer.append(node);
//			node = node.next;
//		}
//		stringBuffer.append("]");
//		return stringBuffer.toString();
//	}
//}

package com.cs.list;

import com.cs.list.AbstractList;

public class LinkedList<E> extends AbstractList<E> {
	private Node<E> first;
	private Node<E> last;
	
	private static class Node<E> {
		E element;
		Node<E> prev;
		Node<E> next;
		public Node(Node<E> prev, E element, Node<E> next) {
			this.prev = prev;
			this.element = element;
			this.next = next;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			
			if (prev != null) {
				sb.append(prev.element);
			} else {
				sb.append("null");
			}
			
			sb.append("_").append(element).append("_");

			if (next != null) {
				sb.append(next.element);
			} else {
				sb.append("null");
			}
			
			return sb.toString();
		}
	}

	@Override
	public void clear() {
		size = 0;
		first = null;
		last = null;
	}

	@Override
	public E get(int index) {
		return node(index).element;
	}

	@Override
	public E set(int index, E element) {
		Node<E> node = node(index);
		E old = node.element;
		node.element = element;
		return old;
	}

	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);

		// size == 0
		// index == 0
		if (index == size) { // 往最后面添加元素
			Node<E> oldLast = last;
			last = new Node<>(oldLast, element, null);
			if (oldLast == null) { // 这是链表添加的第一个元素
				first = last;
			} else {
				oldLast.next = last;
			}
		} else {
			Node<E> next = node(index); 
			Node<E> prev = next.prev; 
			Node<E> node = new Node<>(prev, element, next);
			next.prev = node;
			
			if (prev == null) { // index == 0
				first = node;
			} else {
				prev.next = node;
			}
		}
		
		size++;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);

		Node<E> node = node(index);
		Node<E> prev = node.prev;
		Node<E> next = node.next;
		
		if (prev == null) { // index == 0
			first = next;
		} else {
			prev.next = next;
		}
		
		if (next == null) { // index == size - 1
			last = prev;
		} else {
			next.prev = prev;
		}
		
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
		
		if (index < (size >> 1)) {
			Node<E> node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		} else {
			Node<E> node = last;
			for (int i = size - 1; i > index; i--) {
				node = node.prev;
			}
			return node;
		}
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

