package com.tngtech.linklist;
/**
 * 
 * 简单单项链表-节点
 * 
 * @author tngtech
 * 
 * <p>博客:http://blog.csdn.net/jacman
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
