package com.tngtech.linklist;
/**
 * 
 */

/**
 * 
 * �򵥵�������
 * 
 * @author tngtech
 * 
 *         <p>
 *         ����:http://blog.csdn.net/jacman
 * 
 *         <p>
 *         Github:https://github.com/tangthis
 */
public class SimpleLinkList {

	/** ͷ�ڵ� */
	private SimpleLinkNode header = null;

	/** β�ڵ� */
	private SimpleLinkNode tail = null;

	/**
	 * ��ʼ��һ����������ͷ�ڵ�head��
	 * 
	 * @param node
	 */
	public void initList(SimpleLinkNode node) {
		this.header = node;
		this.header.next = tail;
	}

	/**
	 * ��ӽڵ�
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
	 * ������ӡ�ڵ�
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
	 * ��ӡ������
	 * 
	 * @param head
	 *            ����ͷָ��
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
	 * ɾ�������еĽڵ�
	 * 
	 * @param node
	 * @param myList
	 */
	public void deleteNode(SimpleLinkNode node, SimpleLinkList myList) {
		if (myList == null) {
			return;
		}

		// �ж��Ƿ�ͷ�ڵ㲢��ɾ��
		if (myList.header != null && myList.header.getElement() == node.getElement()) {
			header = header.next;
			return;
		}

		SimpleLinkNode tmp;
		for (tmp = myList.getHeader(); tmp != null; tmp = tmp.next) {
			if (tmp.next != null && node.getElement() == tmp.next.getElement()) {// ��Ԫ�غ���һ��Ԫ����ͬ��ָ��ָ����һ��Ԫ�ص���һ��Ԫ��
				if (tmp.next.next != null) {
					tmp.next = tmp.next.next;
				} else {
					tmp.next = null;
				}
				break;// ����ѭ��
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
	 * �ϲ�2����������
	 * @param a ��������1
	 * @param b	��������2
	 * @param union �ϲ��������
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
		System.out.println("����pa:");
		printList(pa);
		SimpleLinkList pb = new SimpleLinkList();
		for (int i = 20; i <= 30; i++) {
			SimpleLinkNode node = new SimpleLinkNode(i);
			pb.addToList(node);
		}
		System.out.println("����pb:");
		printList(pb);
		SimpleLinkNode union = null;
		union = union(pa.getHeader(), pb.getHeader(), union);
		System.out.println("�ϲ���union:");
		printLinkNode(union);
	}

}
