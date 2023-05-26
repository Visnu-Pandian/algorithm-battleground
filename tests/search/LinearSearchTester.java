/**
 * Performs LinearSearch tests on generic lists and returns data.
 * 
 * @author Visnu Pandian
 * @version 1.0
 * @since 04-02-2023
 */

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

public class LinearSearchTester<T> {

	FileSifter<T> sifter = new FileSifter<T>();
	// Initializing all variables.
	static final int testNum = 10;
	double avgTime;
	double currTime;

	int size;
	Random rand = new Random();

	private double ArrayListLinearSearchTime;
	private double LinkedListLinearSearchTime;
	private double DoublyLinkedListLinearSearchTime;

	/**
	 * collectionLinearSearch
	 * 
	 * Performs LinearSearch on all three data structures.
	 * 
	 * @param filePath Path of clean data file.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * @throws IOException
	 * 
	 * @returns void
	 */

	public <E extends Comparable<E>> void collectionLinearSearch(File filePath)
			throws FileNotFoundException, IOException, NullArgumentException {

		size = sifter.fileSize(filePath);

		// Creating arrayList from clean file.
		ArrayList<Signal> array = sifter.toArrayList(filePath);
		ArrayListLinearSearchTime = doLinearSearch(array); // performing LinearSearch.
		System.out.println("\nLinear Search time (array): " + getArrayListLinearSearchTime() + " s");

		// Creating linkedList from clean file.
		SinglyLinkedList<Signal> linked = sifter.toLinkedList(filePath);
		LinkedListLinearSearchTime = doLinearSearch(linked); // performing LinearSearch.
		System.out.println("Linear Search time (linkedlist): " + getLinkedListLinearSearchTime() + " s");

		// Creating DoublyLinkedList from clean file.
		DoublyLinkedList<Signal> doublylinked = sifter.toDoublyLinkedList(filePath);
		DoublyLinkedListLinearSearchTime = doLinearSearch(doublylinked); // performing LinearSearch.
		System.out.println("Linear Search time (doublylinkedlist): " + getDoublyLinkedListLinearSearchTime() + " s");
	}

	/**
	 * doLinearSearch
	 * 
	 * Performs LinearSearch on ArrayList.
	 * 
	 * @param array ArrayList to be sorted.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * 
	 * @returns avgTime Average time for ten runs of LinearSearch.
	 */

	private <E extends Comparable<E>> double doLinearSearch(ArrayList<Signal> array) throws NullArgumentException {

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			int target = rand.nextInt(0, size);
			Signal targetSignal = array.get(target); // getting target to search.

			Long start = System.currentTimeMillis(); // start timer.
			Search.linearSearch((E) targetSignal, (List<E>) array);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start); // summation of time.
		}
		avgTime = currTime / (testNum * 1000);
		return avgTime;
	}

	/**
	 * doLinearSearch
	 * 
	 * Performs LinearSearch on SinglyLinkedList.
	 * 
	 * @param array SinglyLinkedList to be sorted.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * 
	 * @returns avgTime Average time for ten runs of LinearSearch.
	 */

	private <E extends Comparable<E>> double doLinearSearch(SinglyLinkedList<Signal> linked) throws NullArgumentException {

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			int target = rand.nextInt(0, size);
			Signal targetSignal = linked.get(target); // getting target to search.

			Long start = System.currentTimeMillis(); // start timer.
			Search.linearSearch((E) targetSignal, (List<E>) linked);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start); // summation of time.
		}
		avgTime = currTime / (testNum * 1000);
		return avgTime;
	}

	/**
	 * doLinearSearch
	 * 
	 * Performs LinearSearch on DoublyLinkedList.
	 * 
	 * @param array DoublyLinkedList to be sorted.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * 
	 * @returns avgTime Average time for ten runs of LinearSearch.
	 */

	private <E extends Comparable<E>> double doLinearSearch(DoublyLinkedList<Signal> doublylinked)
			throws NullArgumentException {

		currTime = 0; // reset time to zero.
		for (int i = 0; i < testNum; i++) {
			int target = rand.nextInt(0, size);
			Signal targetSignal = doublylinked.get(target); // getting target to search.

			Long start = System.currentTimeMillis(); // start timer.
			Search.linearSearch((E) targetSignal, (List<E>) doublylinked);
			Long end = System.currentTimeMillis(); // end timer.
			currTime += (end - start); // summation of time.
		}
		avgTime = currTime / (testNum * 1000);
		return avgTime;
	}

	/**
	 * getArrayListLinearSearchTime
	 * 
	 * Gets the time of LinearSearch for ArrayList.
	 * 
	 * @param none
	 * 
	 * @return ArrayListLinearSearchTime
	 */

	public double getArrayListLinearSearchTime() {
		return ArrayListLinearSearchTime;
	}

	/**
	 * getLinkedListLinearSearchTime
	 * 
	 * Gets the time of LinearSearch for SinglyLinkedList.
	 * 
	 * @param none
	 * 
	 * @return LinkedListLinearSearchTime
	 */

	public double getLinkedListLinearSearchTime() {
		return LinkedListLinearSearchTime;
	}

	/**
	 * getDoublyLinkedListLinearSearchTime
	 * 
	 * Gets the time of LinearSearch for DoublyLinkedList.
	 * 
	 * @param none
	 * 
	 * @return DoublyLinkedListLinearSearchTime
	 */

	public double getDoublyLinkedListLinearSearchTime() {
		return DoublyLinkedListLinearSearchTime;
	}
}
