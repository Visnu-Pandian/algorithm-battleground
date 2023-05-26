/**
 * Performs InsertionSort tests on generic lists and returns data.
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

public class InsertionSortTester<T> {

	FileSifter<T> sifter = new FileSifter<T>();

	// Initializing all variables.
	static final int testNum = 5; // only 5 since both ascending and descending have separate loops.
	double avgTimeAscending;
	double avgTimeDescending;
	double avgTime;
	double currTime;

	private double ArrayListInsertionSortTime;
	private double LinkedListInsertionSortTime;
	private double DoublyLinkedListInsertionSortTime;

	/**
	 * collectionInsertionSort
	 * 
	 * Performs InsertionSort on all three data structures.
	 * 
	 * @param filePath Path of clean data file.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * @throws IOException
	 * 
	 * @returns void
	 */

	public void collectionInsertionSort(File filePath)
			throws NullArgumentException, InvalidArgumentException, IOException {

		// Creating arrayList from clean file.
		ArrayList<Signal> array = sifter.toArrayList(filePath);
		ArrayListInsertionSortTime = doInsertionSort(array); // performing InsertionSort.
		System.out.println("\nInsertion Sort time (arraylist): " + getArrayListInsertionSortTime() + " s");

		// Creating linkedList from clean file.
		SinglyLinkedList<Signal> linked = sifter.toLinkedList(filePath);
		LinkedListInsertionSortTime = doInsertionSort(linked); // performing InsertionSort.
		System.out.println("Insertion Sort time (linkedlist): " + getLinkedListInsertionSortTime() + " s");

		// Creating DoublyLinkedList from clean file.
		DoublyLinkedList<Signal> doublylinked = sifter.toDoublyLinkedList(filePath);
		DoublyLinkedListInsertionSortTime = doInsertionSort(doublylinked); // performing InsertionSort.
		System.out.println("Insertion Sort time (doublylinkedlist): " + getDoublyLinkedListInsertionSortTime() + " s");

	}

	/**
	 * doInsertionSort
	 * 
	 * Performs InsertionSort on ArrayList.
	 * 
	 * @param array ArrayList to be sorted.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * 
	 * @returns avgTime Average time for ten runs of InsertionSort.
	 */

	private <E extends Comparable<E>> double doInsertionSort(ArrayList<Signal> array)
			throws NullArgumentException, InvalidArgumentException {

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			Long start = System.currentTimeMillis(); // start timer.
			Sort.insertionSort((List<E>) array, Sort.ASCENDING);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start);
		}
		avgTimeAscending = currTime / testNum;

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			Long start = System.currentTimeMillis(); // start timer.
			Sort.insertionSort((List<E>) array, Sort.DESCENDING);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start);
		}
		avgTimeDescending = currTime / testNum;

		avgTime = (avgTimeAscending + avgTimeDescending) / 1000; // converting from ms to s.
		return avgTime;
	}

	/**
	 * doInsertionSort
	 * 
	 * Performs InsertionSort on SinglyLinkedList.
	 * 
	 * @param linked SinglyLinkedList to be sorted.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * 
	 * @returns avgTime Average time for ten runs of InsertionSort.
	 */

	private <E extends Comparable<E>> double doInsertionSort(SinglyLinkedList<Signal> linked)
			throws NullArgumentException, InvalidArgumentException {

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			Long start = System.currentTimeMillis(); // start timer.
			Sort.insertionSort((List<E>) linked, Sort.ASCENDING);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start);
		}
		avgTimeAscending = currTime / testNum;

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			Long start = System.currentTimeMillis(); // start timer.
			Sort.insertionSort((List<E>) linked, Sort.DESCENDING);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start);
		}
		avgTimeDescending = currTime / testNum;

		avgTime = (avgTimeAscending + avgTimeDescending) / 1000; // converting from ms to s.
		return avgTime;
	}

	/**
	 * doInsertionSort
	 * 
	 * Performs InsertionSort on DoublyLinkedList.
	 * 
	 * @param doublylinked DoublyLinkedList to be sorted.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * 
	 * @returns avgTime Average time for ten runs of InsertionSort.
	 */

	private <E extends Comparable<E>> double doInsertionSort(DoublyLinkedList<Signal> doublylinked)
			throws NullArgumentException, InvalidArgumentException {

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			Long start = System.currentTimeMillis(); // start timer.
			Sort.insertionSort((List<E>) doublylinked, Sort.ASCENDING);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start);
		}
		avgTimeAscending = currTime / testNum;

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			Long start = System.currentTimeMillis(); // start timer.
			Sort.insertionSort((List<E>) doublylinked, Sort.DESCENDING);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start);
		}
		avgTimeDescending = currTime / testNum;

		avgTime = (avgTimeAscending + avgTimeDescending) / 1000; // converting from ms to s.
		return avgTime;

	}

	/**
	 * getArrayListInsertionSortTime
	 * 
	 * Gets the time of InsertionSort for ArrayList.
	 * 
	 * @param none
	 * 
	 * @return ArrayListInsertionSortTime
	 */

	public double getArrayListInsertionSortTime() {
		return ArrayListInsertionSortTime;
	}

	/**
	 * getLinkedListInsertionSortTime
	 * 
	 * Gets the time of InsertionSort for SinglyLinkedList.
	 * 
	 * @param none
	 * 
	 * @return LinkedListInsertionSortTime
	 */

	public double getLinkedListInsertionSortTime() {
		return LinkedListInsertionSortTime;
	}

	/**
	 * getDoublyLinkedListInsertionSortTime
	 * 
	 * Gets the time of InsertionSort for DoublyLinkedList.
	 * 
	 * @param none
	 * 
	 * @return DoublyLinkedListInsertionSortTime
	 */

	public double getDoublyLinkedListInsertionSortTime() {
		return DoublyLinkedListInsertionSortTime;
	}
}
