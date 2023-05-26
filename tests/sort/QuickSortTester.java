/**
 * Performs QuickSort tests on generic lists and returns data.
 * 
 * @author Visnu Pandian
 * @version 1.0
 * @since 04-02-2023
 */

package project3.tests.sort;

import java.io.File;
import java.io.IOException;
import java.util.List;

import project1.algorithms.Sort;
import project1.exceptions.InvalidArgumentException;
import project1.exceptions.NullArgumentException;
import project2.lists.ArrayList;
import project2.lists.DoublyLinkedList;
import project2.lists.SinglyLinkedList;
import project3.algorithms.FileSifter;
import project3.algorithms.Signal;

public class QuickSortTester<T> {

	FileSifter<T> sifter = new FileSifter<T>();

	// Initializing all variables.
	static final int testNum = 5; // only 5 since both ascending and descending have separate loops.
	double avgTimeAscending;
	double avgTimeDescending;
	double avgTime;
	double currTime;

	private double ArrayListQuickSortTime;
	private double LinkedListQuickSortTime;
	private double DoublyLinkedListQuickSortTime;

	/**
	 * collectionQuickSort
	 * 
	 * Performs QuickSort on all three data structures.
	 * 
	 * @param filePath Path of clean data file.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * @throws IOException
	 * 
	 * @returns void
	 */

	public void collectionQuickSort(File filePath) throws NullArgumentException, InvalidArgumentException, IOException {

		// Creating arrayList from clean file.
		ArrayList<Signal> array = sifter.toArrayList(filePath);
		ArrayListQuickSortTime = doQuickSort(array); // performing QuickSort.
		System.out.println("\nQuick Sort time (arraylist): " + getArrayListQuickSortTime() + " s");

		// Creating linkedList from clean file.
		SinglyLinkedList<Signal> linked = sifter.toLinkedList(filePath);
		LinkedListQuickSortTime = doQuickSort(linked); // performing QuickSort.
		System.out.println("Quick Sort time (linkedlist): " + getLinkedListQuickSortTime() + " s");

		// Creating DoublyLinkedList from clean file.
		DoublyLinkedList<Signal> doublylinked = sifter.toDoublyLinkedList(filePath);
		DoublyLinkedListQuickSortTime = doQuickSort(doublylinked); // performing QuickSort.
		System.out.println("Quick Sort time (doublylinkedlist): " + getDoublyLinkedListQuickSortTime() + " s");
	}

	/**
	 * doQuickSort
	 * 
	 * Performs QuickSort on ArrayList.
	 * 
	 * @param array ArrayList to be sorted.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * 
	 * @returns avgTime Average time for ten runs of QuickSort.
	 */

	public <E extends Comparable<E>> double doQuickSort(ArrayList<Signal> array)
			throws NullArgumentException, InvalidArgumentException {

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			Long start = System.currentTimeMillis(); // start timer.
			Sort.quickSort((List<E>) array, Sort.ASCENDING);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start);
		}
		avgTimeAscending = currTime / testNum;

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			Long start = System.currentTimeMillis(); // start timer.
			Sort.quickSort((List<E>) array, Sort.DESCENDING);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start);
		}
		avgTimeDescending = currTime / testNum;

		avgTime = (avgTimeAscending + avgTimeDescending) / 1000; // converting from ms to s.
		return avgTime;
	}

	/**
	 * doQuickSort
	 * 
	 * Performs QuickSort on SinglyLinkedList.
	 * 
	 * @param linked SinglyLinkedList to be sorted.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * 
	 * @returns avgTime Average time for ten runs of QuickSort.
	 */

	public <E extends Comparable<E>> double doQuickSort(SinglyLinkedList<Signal> linked)
			throws NullArgumentException, InvalidArgumentException {

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			Long start = System.currentTimeMillis(); // start timer.
			Sort.quickSort((List<E>) linked, Sort.ASCENDING);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start);
		}
		avgTimeAscending = currTime / testNum;

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			Long start = System.currentTimeMillis(); // start timer.
			Sort.quickSort((List<E>) linked, Sort.DESCENDING);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start);
		}
		avgTimeDescending = currTime / testNum;

		avgTime = (avgTimeAscending + avgTimeDescending) / 1000; // converting from ms to s.
		return avgTime;

	}

	/**
	 * doQuickSort
	 * 
	 * Performs QuickSort on DoublyLinkedList.
	 * 
	 * @param doublylinked DoublyLinkedList to be sorted.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * 
	 * @returns avgTime Average time for ten runs of QuickSort.
	 */

	public <E extends Comparable<E>> double doQuickSort(DoublyLinkedList<Signal> doublylinked)
			throws NullArgumentException, InvalidArgumentException {

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			Long start = System.currentTimeMillis(); // start timer.
			Sort.quickSort((List<E>) doublylinked, Sort.ASCENDING);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start);
		}
		avgTimeAscending = currTime / testNum;

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			Long start = System.currentTimeMillis(); // start timer.
			Sort.quickSort((List<E>) doublylinked, Sort.DESCENDING);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start);
		}
		avgTimeDescending = currTime / testNum;

		avgTime = (avgTimeAscending + avgTimeDescending) / 1000; // converting from ms to s.
		return avgTime;

	}

	/**
	 * getArrayListQuickSortTime
	 * 
	 * Gets the time of QuickSort for ArrayList.
	 * 
	 * @param none
	 * 
	 * @return ArrayListQuickSortTime
	 */

	public double getArrayListQuickSortTime() {
		return ArrayListQuickSortTime;
	}

	/**
	 * getLinkedListQuickSortTime
	 * 
	 * Gets the time of QuickSort for SinglyLinkedList.
	 * 
	 * @param none
	 * 
	 * @return LinkedListQuickSortTime
	 */

	public double getLinkedListQuickSortTime() {
		return LinkedListQuickSortTime;
	}

	/**
	 * getDoublyLinkedListQuickSortTime
	 * 
	 * Gets the time of QuickSort for DoublyLinkedList.
	 * 
	 * @param none
	 * 
	 * @return DoublyLinkedListQuickSortTime
	 */

	public double getDoublyLinkedListQuickSortTime() {
		return DoublyLinkedListQuickSortTime;
	}
}
