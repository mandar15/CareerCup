package com.datastructures;

import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Queue;

class HeapObject implements Comparable<HeapObject> {
	private String type;
	private Date time;
	private int value;
	
	public HeapObject(String type, Date time, int value) {
		this.type = type;
		this.time = time;
		this.value = value;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * Natural ordering is to create a minHeap
	 * @param h
	 * @return
	 */
	@Override
	public int compareTo(HeapObject h) {
		if(this.time.equals(h.time)) {
			return 0;
		} else if(this.time.before(h.time)){
			return -1;
		} else {
			return 1;
		}
	}
}

public class HeapsUsingPriorityQueue {
	Queue<HeapObject> heap;
	
	public HeapsUsingPriorityQueue(int initialCapacity, boolean isMaxHeap) {
		if(isMaxHeap) {
			Comparator<HeapObject> maxHeapComparator = new MaxHeapComparator();
			heap = new PriorityQueue<HeapObject>(initialCapacity, maxHeapComparator);
		} else {
			heap = new PriorityQueue<HeapObject>(initialCapacity);
		}
	}
	
	public void heapify(HeapObject heapObject) {
		System.out.println("\nAdd to heap: {" + heapObject.getTime() + "," + heapObject.getType() + "," + heapObject.getValue() + "}");
		heap.add(heapObject);	
	}
	
	public HeapObject remove() {
		HeapObject h = heap.remove();
		System.out.println("\nRemoved the heap head: {" + h.getTime() + "," + h.getType() + "," + h.getValue() + "}");
		return h;
	}
	
	public void printHeapHead() {
		if(heap.size() > 0) {
			HeapObject head = heap.peek();
			System.out.println("\nCurrent Heap Head: {" + head.getTime() + "," + head.getType() + "," + head.getValue() + "}");
		} else {
			System.out.println("\nHeap is Empty");
		}		
	}
	
	public void printAllHeapElements() {
		System.out.println("\nHeap Dump:");
		for(HeapObject h : heap) {
			System.out.println("{" + h.getTime() + "," + h.getType() + "," + h.getValue() + "}");
		}
	}
	
	class MaxHeapComparator implements Comparator<HeapObject> {
		@Override
		public int compare(HeapObject h1, HeapObject h2) {
			Date d1 = h1.getTime();
			Date d2 = h2.getTime();
			
			if(d1.equals(d2)) {
				return 0;
			} else if(d1.before(d2)) {
				return 1;
			} else {
				return -1;
			}
		}
	}
}

class Driver {
	public static void main(String args[]) throws InterruptedException {
		int initialCapacity = 10;
		int threadSleep = 2000;
		boolean isMaxHeap = true;
		
		HeapsUsingPriorityQueue heap = new HeapsUsingPriorityQueue(initialCapacity, isMaxHeap);
		HeapObject h1 = new HeapObject("Type1", new Date(System.currentTimeMillis()), 1);
		Thread.sleep(threadSleep);
		HeapObject h2 = new HeapObject("Type2", new Date(System.currentTimeMillis()), 2);
		Thread.sleep(threadSleep);
		HeapObject h3 = new HeapObject("Type1", new Date(System.currentTimeMillis()), 3);
		Thread.sleep(threadSleep);
		HeapObject h4 = new HeapObject("Type3", new Date(System.currentTimeMillis()), 4);
		
		heap.heapify(h4);
		heap.heapify(h3);
		heap.heapify(h2);
		heap.heapify(h1);		
		heap.printHeapHead();		
		heap.printAllHeapElements();
		
		heap.remove();
		heap.printHeapHead();		
		heap.printAllHeapElements();
		
		heap.remove();
		heap.printHeapHead();		
		heap.printAllHeapElements();
		
		heap.heapify(h4);
		heap.printHeapHead();		
		heap.printAllHeapElements();
	}
}
