package com.autumnia.basic.utils.heap;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class HeapView {
	private static Runtime rt = Runtime.getRuntime();
	private static MemoryMXBean mbs = ManagementFactory.getMemoryMXBean();

	public static long printHeap(int idx) {
		rt.gc();
		long totalMemory = rt.totalMemory();
		long freeMemory = rt.freeMemory();
		long usedMemory = totalMemory - freeMemory;
		System.out.println(String.format("%d HEAP:%, 8d bytes", idx, usedMemory));

		return usedMemory;
	}
	
	public static void printHeap2(int count) {
		MemoryUsage heap = mbs.getHeapMemoryUsage();
		MemoryUsage noneHeap = mbs.getNonHeapMemoryUsage();
		
		System.out.println(String.format("%d  HEAP:%, NoneHeap:% TotalHeap:% ", count, heap, noneHeap ));
	}

	public static void main(String[] args)	{

	}
}
