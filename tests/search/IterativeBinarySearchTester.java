package project3.tests.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import project1.algorithms.Search;
import project1.exceptions.InvalidArgumentException;
import project1.exceptions.NullArgumentException;
import project2.lists.ArrayList;
import project2.lists.DoublyLinkedList;
import project2.lists.SinglyLinkedList;
import project3.algorithms.FileSifter;
import project3.algorithms.Signal;
import project3.tests.sort.QuickSortTester;

public class IterativeBinarySearchTester<T> {

	FileSifter<T> sifter = new FileSifter<T>();
	// Initializing all variables.
	static final int testNum = 10;
	double avgTime;
	double currTime;

	int size;
	Random rand = new Random();

	private double ArrayListIterativeBinarySearchTime;
	private double LinkedListIterativeBinarySearchTime;
	private double DoublyLinkedListIterativeBinarySearchTime;

	/**
	 * collectionIterativeBinarySearch
	 * 
	 * Performs IterativeBinarySearch on all three data structures.
	 * 
	 * @param filePath Path of clean data file.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * @throws IOException
	 * 
	 * @returns void
	 */

	public <E extends Comparable<E>> void collectionIterativeBinarySearch(File filePath)
			throws FileNotFoundException, IOException, NullArgumentException, InvalidArgumentException {

		size = sifter.fileSize(filePath);

		// Creating arrayList from clean file.
		ArrayList<Signal> array = sifter.toArrayList(filePath);
		ArrayListIterativeBinarySearchTime = doIterativeBinarySearch(array); // performing IterativeBinarySearch.
		System.out.println("\nIterativeBinary Search time (array): " + getArrayListIterativeBinarySearchTime() + " s");

		// Creating linkedList from clean file.
		SinglyLinkedList<Signal> linked = sifter.toLinkedList(filePath);
		LinkedListIterativeBinarySearchTime = doIterativeBinarySearch(linked); // performing IterativeBinarySearch.
		System.out.println(
				"IterativeBinary Search time (linkedlist): " + getLinkedListIterativeBinarySearchTime() + " s");

		// Creating doublyLinkedList from clean file.
		DoublyLinkedList<Signal> doublylinked = sifter.toDoublyLinkedList(filePath);
		DoublyLinkedListIterativeBinarySearchTime = doIterativeBinarySearch(doublylinked); // performing
																							// IterativeBinarySearch.
		System.out.println("IterativeBinary Search time (doublylinkedlist): "
				+ getDoublyLinkedListIterativeBinarySearchTime() + " s");
	}

	/**
	 * doIterativeBinarySearch
	 * 
	 * Performs IterativeBinarySearch on ArrayList.
	 * 
	 * @param array ArrayList to be sorted.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * 
	 * @returns avgTime Average time for ten runs of IterativeBinarySearch.
	 */

	private <E extends Comparable<E>> double doIterativeBinarySearch(ArrayList<Signal> array)
			throws NullArgumentException, InvalidArgumentException {

		currTime = 0; // reset time to zero.
		QuickSortTester<T> insertionSortTester = new QuickSortTester<T>();

		for (int i = 0; i < testNum; i++) {
			int target = rand.nextInt(0, size);
			Signal targetSignal = array.get(target); // getting target to search.

			Long start = System.currentTimeMillis(); // start timer.
			insertionSortTester.doQuickSort(array); // sorting the list.
			Search.iterativeBinarySearch((E) targetSignal, (List<E>) array);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start); // summation of time.
		}
		avgTime = currTime / (testNum * 1000);
		return avgTime;
	}

	/**
	 * doIterativeBinarySearch
	 * 
	 * Performs IterativeBinarySearch on SinglyLinkedList.
	 * 
	 * @param array SinglyLinkedList to be sorted.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * 
	 * @returns avgTime Average time for ten runs of IterativeBinarySearch.
	 */

	private <E extends Comparable<E>> double doIterativeBinarySearch(SinglyLinkedList<Signal> linked)
			throws NullArgumentException, InvalidArgumentException {

		currTime = 0; // reset time to zero.
		QuickSortTester<T> insertionSortTester = new QuickSortTester<T>();

		for (int i = 0; i < testNum; i++) {
			int target = rand.nextInt(0, size);
			Signal targetSignal = linked.get(target); // getting target to search.

			Long start = System.currentTimeMillis(); // start timer.
			insertionSortTester.doQuickSort(linked); // sorting the list.
			Search.iterativeBinarySearch((E) targetSignal, (List<E>) linked);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start); // summation of time.
		}
		avgTime = currTime / (testNum * 1000);
		return avgTime;
	}

	/**
	 * doIterativeBinarySearch
	 * 
	 * Performs IterativeBinarySearch on DoublyLinkedList.
	 * 
	 * @param array DoublyLinkedList to be sorted.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * 
	 * @returns avgTime Average time for ten runs of IterativeBinarySearch.
	 */

	private <E extends Comparable<E>> double doIterativeBinarySearch(DoublyLinkedList<Signal> doublylinked)
			throws NullArgumentException, InvalidArgumentException {

		currTime = 0; // reset time to zero.
		QuickSortTester<T> insertionSortTester = new QuickSortTester<T>();

		for (int i = 0; i < testNum; i++) {
			int target = rand.nextInt(0, size);
			Signal targetSignal = doublylinked.get(target); // getting target to search.

			Long start = System.currentTimeMillis(); // start timer.
			insertionSortTester.doQuickSort(doublylinked); // sorting the list.
			Search.iterativeBinarySearch((E) targetSignal, (List<E>) doublylinked);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start); // summation of time.
		}
		avgTime = currTime / (testNum * 1000);
		return avgTime;
	}

	/**
	 * getArrayListIterativeBinarySearchTime
	 * 
	 * Gets the time of IterativeBinarySearch for ArrayList.
	 * 
	 * @param none
	 * 
	 * @return ArrayListIterativeBinarySearchTime
	 */

	public double getArrayListIterativeBinarySearchTime() {
		return ArrayListIterativeBinarySearchTime;
	}

	/**
	 * getLinkedListIterativeBinarySearchTime
	 * 
	 * Gets the time of IterativeBinarySearch for SinglyLinkedList.
	 * 
	 * @param none
	 * 
	 * @return LinkedListIterativeBinarySearchTime
	 */

	public double getLinkedListIterativeBinarySearchTime() {
		return LinkedListIterativeBinarySearchTime;
	}

	/**
	 * getDoublyLinkedListIterativeBinarySearchTime
	 * 
	 * Gets the time of IterativeBinarySearch for DoublyLinkedList.
	 * 
	 * @param none
	 * 
	 * @return DoublyLinkedListIterativeBinarySearchTime
	 */

	public double getDoublyLinkedListIterativeBinarySearchTime() {
		return DoublyLinkedListIterativeBinarySearchTime;
	}
}
