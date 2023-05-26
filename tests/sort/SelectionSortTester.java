/**
 * Performs SelectionSort tests on generic lists and returns data.
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

public class SelectionSortTester<T> {

	FileSifter<T> sifter = new FileSifter<T>();

	// Initializing all variables.
	static final int testNum = 5; // only 5 since both ascending and descending have separate loops.
	double avgTimeAscending;
	double avgTimeDescending;
	double avgTime;
	double currTime;

	private double ArrayListSelectionSortTime;
	private double LinkedListSelectionSortTime;
	private double DoublyLinkedListSelectionSortTime;

	/**
	 * collectionSelectionSort
	 * 
	 * Performs SelectionSort on all three data structures.
	 * 
	 * @param filePath Path of clean data file.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * @throws IOException
	 * 
	 * @returns void
	 */

	public void collectionSelectionSort(File filePath)
			throws NullArgumentException, InvalidArgumentException, IOException {

		// Creating arrayList from clean file.
		ArrayList<Signal> array = sifter.toArrayList(filePath);
		ArrayListSelectionSortTime = doSelectionSort(array); // performing SelectionSort.
		System.out.println("\nSelection Sort time (arraylist): " + getArrayListSelectionSortTime() + " s");

		// Creating linkedList from clean file.
		SinglyLinkedList<Signal> linked = sifter.toLinkedList(filePath);
		LinkedListSelectionSortTime = doSelectionSort(linked); // performing SelectionSort.
		System.out.println("Selection Sort time (linkedlist): " + getLinkedListSelectionSortTime() + " s");

		// Creating DoublyLinkedList from clean file.
		DoublyLinkedList<Signal> doublylinked = sifter.toDoublyLinkedList(filePath);
		DoublyLinkedListSelectionSortTime = doSelectionSort(doublylinked); // performing SelectionSort.
		System.out.println("Selection Sort time (doublylinkedlist): " + getDoublyLinkedListSelectionSortTime() + " s");

	}

	/**
	 * doSelectionSort
	 * 
	 * Performs SelectionSort on ArrayList.
	 * 
	 * @param array ArrayList to be sorted.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * 
	 * @returns avgTime Average time for ten runs of SelectionSort.
	 */

	private <E extends Comparable<E>> double doSelectionSort(ArrayList<Signal> array)
			throws NullArgumentException, InvalidArgumentException {

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			Long start = System.currentTimeMillis(); // start timer.
			Sort.selectionSort((List<E>) array, Sort.ASCENDING);
			Long end = System.currentTimeMillis();
			currTime += (end - start);
		}
		avgTimeAscending = currTime / testNum;

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			Long start = System.currentTimeMillis(); // start timer.
			Sort.selectionSort((List<E>) array, Sort.DESCENDING);
			Long end = System.currentTimeMillis();
			currTime += (end - start);
		}
		avgTimeDescending = currTime / testNum;

		avgTime = (avgTimeAscending + avgTimeDescending) / 1000; // converting from ms to s.
		return avgTime;
	}

	/**
	 * doSelectionSort
	 * 
	 * Performs SelectionSort on SinglyLinkedList.
	 * 
	 * @param linked SinglyLinkedList to be sorted.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * 
	 * @returns avgTime Average time for ten runs of SelectionSort.
	 */

	private <E extends Comparable<E>> double doSelectionSort(SinglyLinkedList<Signal> linked)
			throws NullArgumentException, InvalidArgumentException {

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			Long start = System.currentTimeMillis(); // start timer.
			Sort.selectionSort((List<E>) linked, Sort.ASCENDING);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start);
		}
		avgTimeAscending = currTime / testNum;

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			Long start = System.currentTimeMillis(); // start timer.
			Sort.selectionSort((List<E>) linked, Sort.DESCENDING);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start);
		}
		avgTimeDescending = currTime / testNum;

		avgTime = (avgTimeAscending + avgTimeDescending) / 1000; // converting from ms to s.
		return avgTime;
	}

	/**
	 * doSelectionSort
	 * 
	 * Performs SelectionSort on DoublyLinkedList.
	 * 
	 * @param doublylinked DoublyLinkedList to be sorted.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * 
	 * @returns avgTime Average time for ten runs of SelectionSort.
	 */

	private <E extends Comparable<E>> double doSelectionSort(DoublyLinkedList<Signal> doublylinked)
			throws NullArgumentException, InvalidArgumentException {

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			Long start = System.currentTimeMillis(); // start timer.
			Sort.selectionSort((List<E>) doublylinked, Sort.ASCENDING);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start);
		}
		avgTimeAscending = currTime / testNum;

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			Long start = System.currentTimeMillis(); // start timer.
			Sort.selectionSort((List<E>) doublylinked, Sort.DESCENDING);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start);
		}
		avgTimeDescending = currTime / testNum;

		avgTime = (avgTimeAscending + avgTimeDescending) / 1000; // converting from ms to s.
		return avgTime;

	}

	/**
	 * getArrayListSelectionSortTime
	 * 
	 * Gets the time of SelectionSort for ArrayList.
	 * 
	 * @param none
	 * 
	 * @return ArrayListSelectionSortTime
	 */

	public double getArrayListSelectionSortTime() {
		return ArrayListSelectionSortTime;
	}

	/**
	 * getLinkedListSelectionSortTime
	 * 
	 * Gets the time of SelectionSort for SinglyLinkedList.
	 * 
	 * @param none
	 * 
	 * @return LinkedListSelectionSortTime
	 */

	public double getLinkedListSelectionSortTime() {
		return LinkedListSelectionSortTime;
	}

	/**
	 * getDoublyLinkedListSelectionSortTime
	 * 
	 * Gets the time of SelectionSort for DoublyLinkedList.
	 * 
	 * @param none
	 * 
	 * @return DoublyLinkedListSelectionSortTime
	 */

	public double getDoublyLinkedListSelectionSortTime() {
		return DoublyLinkedListSelectionSortTime;
	}
}
