package com.cs.list.circle;

import com.cs.list.AbstractList;

class CircleLinkedList<E> extends AbstractList<E> {
	private Node<E> first;
	private Node<E> last;
	private Node<E> current;
	
	private static class Node<E> {
		E element;
		Node<E> next;
		Node<E> prev;
		
		public Node(Node<E> prev,E element, Node<E> next) {
			this.prev = prev;
			this.element = element;
			this.next = next;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			StringBuffer sb = new StringBuffer();
			
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
	
	public void reset() {
		current = first;
	}
	
	public E next() {
		if (current == null) {
			return null;
		}
		current = current.next;
		return current.element;
	}
	
	public E remove() {
		if (current == null) {
			return null;
		}
		Node<E> nextNode = current.next;
		E element = remove(current);
		
		if (size == 0) {
			current = null;
		} else {
			current = nextNode;
		}
		return element;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		size = 0;
		first = null;
		last = null;
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
		
		if (index == size) {	// 往最后面添加元素
			Node<E> oldLastNode = last;
			last = new Node<E>(oldLastNode.prev, element, first);
			if (oldLastNode == null) {	// 这是链表添加的第一个元素
				first = last;
				first.next = last;
				last.prev = first;
			} else {
				oldLastNode.next = last;
				first.prev = last;
			}
		} else {
			Node<E> next = node(index);
			Node<E> prev = next.prev;
			Node<E> node = new Node<E>(prev, element, next);
			prev.next = node;
			next.prev = node;
			
			if (next == first) {	// index == 0
				first = node;
			}
		}
		size++;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		rangeCheck(index);
		
		return remove(node(index));
	}
	
	private E remove(Node<E> node) {
		if (size == 1) {
			first = null;
			last = null;
		} else {
			Node<E> prevNode = node.prev;
			Node<E> nextNode = node.next;
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
			
			if (node == first) {	// index == 0
				first = nextNode;
			}
			if (node == last) {	// index == size - 1
				last = prevNode;
			}
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
