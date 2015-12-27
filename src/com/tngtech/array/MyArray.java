/**
 * 
 */
package com.tngtech.array;

import com.sun.prism.Texture;

/**
 * 数组基本操作
 * 
 * @author tngtech
 * @date 2015年12月27日
 *       <p>
 *       博客:http://blog.csdn.net/jacman
 *       <p>
 *       Github:https://github.com/tangthis
 *
 */
public class MyArray {
	private long[] arry;
	private int length;// 数组长度

	public MyArray(int max) {
		arry = new long[max];
		length = 0;
	}

	public boolean find(long searchKey) {
		for (int i = 0; i < length; i++) {
			if (arry[i] == searchKey) {
				return true;
			}
		}
		return false;
	}

	public void insert(long value) {
		arry[length] = value;
		length++;
	}

	public boolean delete(long value) {
		int j;
		for (j = 0; j < length; j++) {
			if (arry[j] == value) {
				break;
			}
		}

		if (j == length) {
			return false; // 没有找到数据项
		}

		// 删除对应数据项，并且将后面元素从被删除的元素位置重新计算
		for (int k = j; k < length; k++) {
			arry[k] = arry[k + 1];
		}

		length--;
		return true;
	}

	public void display() {
		for (int i = 0; i < length; i++) {
			System.out.print(arry[i] + " ");
		}
		System.out.println();
	}
	
	/**
	 * 二分查找法
	 * 
	 * @param value
	 * @return
	 */
	public int halfFind(long searchKey){
		int lowerBound = 0;
		int upperBound = length - 1;
		
		int curBound;
		while(true){
			curBound = (lowerBound + upperBound) / 2;
			if(arry[curBound] == searchKey){
				return curBound; 
			}else if(lowerBound > upperBound){
				return length; //用length表示找不到的位置
			}else{
				if(arry[curBound] < searchKey){
					lowerBound = curBound + 1;
				}else{
					upperBound = curBound - 1;
				}
			}
		}
	}
	
	//数组基本操作
	public static void myArryOper(){
		MyArray myArray = new MyArray(100);
		//在数据中插入10个元素
		myArray.insert(66);
		myArray.insert(99);
		myArray.insert(22);
		myArray.insert(55);
		myArray.insert(77);
		myArray.insert(44);
		myArray.insert(11);
		myArray.insert(0);
		myArray.insert(33);
		myArray.insert(88);
		
		myArray.display();
		
		long searchKey = 33;
		if(myArray.find(searchKey)){
			System.out.println("找到了" + searchKey);
		}else{
			System.out.println("没有找到"+searchKey);
		}
		
		//删除2个元素
		myArray.delete(0);
		myArray.delete(22);
		System.out.println("删除数组后的元素");
		myArray.display();
	}
	
	//有序数组操作，二分查找法
	public static void sortArrayOper(){
		MyArray myArray = new MyArray(100);
		for(long i = 1 ; i <= 100; i++){
			myArray.insert(i);
		}
		long searchKey = 90;
		int index = myArray.halfFind(searchKey);
		if(index != myArray.length){
			System.out.println("二分查找法，找到了"+searchKey+"，位置："+index);
		}else{
			System.out.println("二分查找法，没有找到了"+searchKey);
		}
	}
	public static void main(String[] args) {
		//myArryOper();
		
		sortArrayOper();
	}
}
