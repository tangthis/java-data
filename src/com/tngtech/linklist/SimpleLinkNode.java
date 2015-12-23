package com.tngtech.linklist;
/**
 * 
 * �򵥵�������-�ڵ�
 * 
 * @author tngtech
 * 
 * <p>����:http://blog.csdn.net/jacman
 * 
 * <p>https://github.com/tangthis
 */
public class SimpleLinkNode {
	int element;
	SimpleLinkNode next;
	
	
	public SimpleLinkNode() {
		super();
	}

	public SimpleLinkNode(int element){
		this.element = element;
	}
	
	public SimpleLinkNode(int element, SimpleLinkNode next) {
		super();
		this.element = element;
		this.next = next;
	}
	public int getElement() {
		return element;
	}
	public void setElement(int element) {
		this.element = element;
	}
	public SimpleLinkNode getNext() {
		return next;
	}
	public void setNext(SimpleLinkNode next) {
		this.next = next;
	}
	
	
}
