package com.tngtech.linklist;
/**
 * 
 */

/**
 * 
 * 简单单向链表
 * 
 * @author tngtech
 * 
 *         <p>
 *         博客:http://blog.csdn.net/jacman
 * 
 *         <p>
 *         Github:https://github.com/tangthis
 */
public class SimpleLinkList {

	/** 头节点 */
	private SimpleLinkNode header = null;

	/** 尾节点 */
	private SimpleLinkNode tail = null;

	/**
	 * 初始化一个链表（设置头节点head）
	 * 
	 * @param node
	 */
	public void initList(SimpleLinkNode node) {
		this.header = node;
		this.header.next = tail;
	}

	/**
	 * 添加节点
	 * 
	 * @param node
	 */
	public void addToList(SimpleLinkNode node) {
		if (header == null) {
			initList(node);
		} else {
			SimpleLinkNode temp = header;
			header = node;
			header.next = temp;
		}
	}

	/**
	 * 遍历打印节点
	 * 
	 * @param myList
	 */
	public static void printList(SimpleLinkList myList) {
		SimpleLinkNode tmp = null;
		for (tmp = myList.getHeader(); tmp != null; tmp = tmp.next) {
			System.out.print(tmp.getElement() + " ");
		}
		System.out.println();
	}

	/**
	 * 打印单链表
	 * 
	 * @param head
	 *            链表头指针
	 */
	public static void printLinkNode(SimpleLinkNode head) {
		if (head == null || head.next == null) {
			return;
		}
		System.out.print(head.getElement() + " ");
		head = head.next;
		while (head != null) {
			System.out.print(head.element + " ");
			head = head.next;
		}
		System.out.println();
	}

	/**
	 * 删除链表中的节点
	 * 
	 * @param node
	 * @param myList
	 */
	public void deleteNode(SimpleLinkNode node, SimpleLinkList myList) {
		if (myList == null) {
			return;
		}

		// 判断是否头节点并且删除
		if (myList.header != null && myList.header.getElement() == node.getElement()) {
			header = header.next;
			return;
		}

		SimpleLinkNode tmp;
		for (tmp = myList.getHeader(); tmp != null; tmp = tmp.next) {
			if (tmp.next != null && node.getElement() == tmp.next.getElement()) {// 该元素和下一个元素相同，指针指向下一个元素的下一个元素
				if (tmp.next.next != null) {
					tmp.next = tmp.next.next;
				} else {
					tmp.next = null;
				}
				break;// 跳出循环
			}
		}

	}

	public SimpleLinkNode getHeader() {
		return header;
	}

	public void setHeader(SimpleLinkNode header) {
		this.header = header;
	}

	public SimpleLinkNode getTail() {
		return tail;
	}

	public void setTail(SimpleLinkNode tail) {
		this.tail = tail;
	}
	/**
	 * 合并2个有序链表
	 * @param a 有序链表1
	 * @param b	有序链表2
	 * @param union 合并后的链表
	 * @return
	 */
	public static SimpleLinkNode union(SimpleLinkNode a, SimpleLinkNode b, SimpleLinkNode union) {
		SimpleLinkNode pc = union = a;
		SimpleLinkNode pa = a.next;
		SimpleLinkNode pb = b.next;

		while (pa != null && pb != null) {
			if (pa.element < pb.element) {
				pc.next = pa;
				pc = pa;
				pa = pa.next;
			} else {
				pc.next = pb;
				pc = pb;
				pb = pb.next;
			}
			pc.next = pb;
		}
		return union;
	}

	public static void main(String[] args) {
		SimpleLinkList pa = new SimpleLinkList();
		for (int i = 1; i <= 10; i++) {
			SimpleLinkNode node = new SimpleLinkNode(i);
			pa.addToList(node);
		}
		System.out.println("链表pa:");
		printList(pa);
		SimpleLinkList pb = new SimpleLinkList();
		for (int i = 20; i <= 30; i++) {
			SimpleLinkNode node = new SimpleLinkNode(i);
			pb.addToList(node);
		}
		System.out.println("链表pb:");
		printList(pb);
		SimpleLinkNode union = null;
		union = union(pa.getHeader(), pb.getHeader(), union);
		System.out.println("合并后union:");
		printLinkNode(union);
	}

}
