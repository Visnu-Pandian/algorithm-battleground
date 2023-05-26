/**
 * Performs BubbleSort tests on generic lists and returns data.
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

public class BubbleSortTester<T> {

	FileSifter<T> sifter = new FileSifter<T>();

	// Initializing all variables.
	static final int testNum = 5; // only 5 since both ascending and descending have separate loops.
	double avgTimeAscending;
	double avgTimeDescending;
	double avgTime;
	double currTime;

	private double ArrayListBubbleSortTime;
	private double LinkedListBubbleSortTime;
	private double DoublyLinkedListBubbleSortTime;

	/**
	 * collectionBubbleSort
	 * 
	 * Performs BubbleSort on all three data structures.
	 * 
	 * @param filePath Path of clean data file.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * @throws IOException
	 * 
	 * @returns void
	 */

	public void collectionBubbleSort(File filePath)
			throws NullArgumentException, InvalidArgumentException, IOException {

		// Creating arrayList from clean file.
		ArrayList<Signal> array = sifter.toArrayList(filePath);
		ArrayListBubbleSortTime = doBubbleSort(array); // performing BubbleSort.
		System.out.println("\nBubble Sort time (arraylist): " + getArrayListBubbleSortTime() + " s");

		// Creating linkedList from clean file.
		SinglyLinkedList<Signal> linked = sifter.toLinkedList(filePath);
		LinkedListBubbleSortTime = doBubbleSort(linked); // performing BubbleSort.
		System.out.println("Bubble Sort time (linkedlist): " + getLinkedListBubbleSortTime() + " s");

		// Creating DoublyLinkedList from clean file.
		DoublyLinkedList<Signal> doublylinked = sifter.toDoublyLinkedList(filePath);
		DoublyLinkedListBubbleSortTime = doBubbleSort(doublylinked); // performing BubbleSort.
		System.out.println("Bubble Sort time (doublylinkedlist): " + getDoublyLinkedListBubbleSortTime() + " s");
	}

	/**
	 * doBubbleSort
	 * 
	 * Performs BubbleSort on ArrayList.
	 * 
	 * @param array ArrayList to be sorted.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * 
	 * @returns avgTime Average time for ten runs of BubbleSort.
	 */

	private <E extends Comparable<E>> double doBubbleSort(ArrayList<Signal> array)
			throws NullArgumentException, InvalidArgumentException {

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			Long start = System.currentTimeMillis(); // start timer.
			Sort.bubbleSort((List<E>) array, Sort.ASCENDING);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start); // summation of time.
		}
		avgTimeAscending = currTime / testNum;

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			Long start = System.currentTimeMillis(); // start timer.
			Sort.bubbleSort((List<E>) array, Sort.DESCENDING);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start); // summation of time.
		}
		avgTimeDescending = currTime / testNum;

		avgTime = (avgTimeAscending + avgTimeDescending) / 1000; // converting from ms to s.
		return avgTime;
	}

	/**
	 * doBubbleSort
	 * 
	 * Performs BubbleSort on SinglyLinkedList.
	 * 
	 * @param linked SinglyLinkedList to be sorted.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * 
	 * @returns avgTime Average time for ten runs of BubbleSort.
	 */

	private <E extends Comparable<E>> double doBubbleSort(SinglyLinkedList<Signal> linked)
			throws NullArgumentException, InvalidArgumentException {

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			Long start = System.currentTimeMillis(); // start timer.
			Sort.bubbleSort((List<E>) linked, Sort.ASCENDING);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start); // summation of time.
		}
		avgTimeAscending = currTime / testNum;

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			Long start = System.currentTimeMillis(); // start timer.
			Sort.bubbleSort((List<E>) linked, Sort.DESCENDING);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start); // summation of time.
		}
		avgTimeDescending = currTime / testNum;

		avgTime = (avgTimeAscending + avgTimeDescending) / 1000; // converting from ms to s.
		return avgTime;

	}

	/**
	 * doBubbleSort
	 * 
	 * Performs bubbleSort on DoublyLinkedList.
	 * 
	 * @param doublylinked DoublyLinkedList to be sorted.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * 
	 * @returns avgTime Average time for ten runs of BubbleSort.
	 */

	private <E extends Comparable<E>> double doBubbleSort(DoublyLinkedList<Signal> doublylinked)
			throws NullArgumentException, InvalidArgumentException {

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			Long start = System.currentTimeMillis(); // start timer.
			Sort.bubbleSort((List<E>) doublylinked, Sort.ASCENDING);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start); // summation of time.
		}
		avgTimeAscending = currTime / testNum;

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			Long start = System.currentTimeMillis(); // start timer.
			Sort.bubbleSort((List<E>) doublylinked, Sort.DESCENDING);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start); // summation of time.
		}
		avgTimeDescending = currTime / testNum;

		avgTime = (avgTimeAscending + avgTimeDescending) / 1000; // converting from ms to s.
		return avgTime;

	}

	/**
	 * getArrayListBubbleSortTime
	 * 
	 * Gets the time of BubbleSort for ArrayList.
	 * 
	 * @param none
	 * 
	 * @return ArrayListBubbleSortTime
	 */

	public double getArrayListBubbleSortTime() {
		return ArrayListBubbleSortTime;
	}

	/**
	 * getLinkedListBubbleSortTime
	 * 
	 * Gets the time of BubbleSort for SinglyLinkedList.
	 * 
	 * @param none
	 * 
	 * @return LinkedListBubbleSortTime
	 */

	public double getLinkedListBubbleSortTime() {
		return LinkedListBubbleSortTime;
	}

	/**
	 * getDoublyLinkedListBubbleSortTime
	 * 
	 * Gets the time of BubbleSort for DoublyLinkedList.
	 * 
	 * @param none
	 * 
	 * @return DoublyLinkedListBubbleSortTime
	 */

	public double getDoublyLinkedListBubbleSortTime() {
		return DoublyLinkedListBubbleSortTime;
	}
}
