/**
 * The main result generation class for the project. Calls tests and writes results to final output file.
 * 
 * @author Visnu Pandian
 * @version 1.0
 * @since 04-06-2023
 */

package project3.algorithms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import project1.exceptions.InvalidArgumentException;
import project1.exceptions.NullArgumentException;
import project3.tests.search.IterativeBinarySearchTester;
import project3.tests.search.LinearSearchTester;
import project3.tests.search.RecursiveBinarySearchTester;
import project3.tests.sort.BubbleSortTester;
import project3.tests.sort.InsertionSortTester;
import project3.tests.sort.QuickSortTester;
import project3.tests.sort.SelectionSortTester;

public class Result<T> {

	// Initializing instances to perform tests.

	// Instances for sorting tests.
	BubbleSortTester<T> bubbleSorter = new BubbleSortTester<T>();
	InsertionSortTester<T> insertionSorter = new InsertionSortTester<T>();
	QuickSortTester<T> quickSorter = new QuickSortTester<T>();
	SelectionSortTester<T> selectionSorter = new SelectionSortTester<T>();

	// Instances for searching tests.
	LinearSearchTester<T> linearSearcher = new LinearSearchTester<T>();
	IterativeBinarySearchTester<T> iterativeBinarySearcher = new IterativeBinarySearchTester<T>();
	RecursiveBinarySearchTester<T> recursiveBinarySearcher = new RecursiveBinarySearchTester<T>();

	// Path of output file. Edit to change location of final output file.
	private final static String newFile = "C:/Users/vsp00/eclipse-workspace/CS 111 Lab 2023/src/palfa_results.csv";

	/**
	 * getResult
	 * 
	 * Writes test results to output file.
	 * 
	 * @param fileName Path of output file.
	 * 
	 * @throws IOException
	 * 
	 * @return resultFile Path of output file.
	 */

	public File getResult(String fileName) throws IOException {

		File resultFile = new File(fileName); // creating output file.

		// Initializing instances to write to file.
		FileWriter writer = new FileWriter(resultFile);
		BufferedWriter out = new BufferedWriter(writer);

		// Header line.
		out.write("Algorithm,DataStructure,MeanExecutionTime\n");

		// BubbleSort results.
		out.write("BubbleSort,ArrayList," + bubbleSorter.getArrayListBubbleSortTime() + "\n");
		out.write("BubbleSort,SinglyLinkedList," + bubbleSorter.getLinkedListBubbleSortTime() + "\n");
		out.write("BubbleSort,DoublyLinkedList," + bubbleSorter.getDoublyLinkedListBubbleSortTime() + "\n");

		// InsertionSort results.
		out.write("InsertionSort,ArrayList," + insertionSorter.getArrayListInsertionSortTime() + "\n");
		out.write("InsertionSort,SinglyLinkedList," + insertionSorter.getLinkedListInsertionSortTime() + "\n");
		out.write("InsertionSort,DoublyLinkedList," + insertionSorter.getDoublyLinkedListInsertionSortTime() + "\n");

		// QuickSort results.
		out.write("QuickSort,ArrayList," + quickSorter.getArrayListQuickSortTime() + "\n");
		out.write("QuickSort,SinglyLinkedList," + quickSorter.getLinkedListQuickSortTime() + "\n");
		out.write("QuickSort,DoublyLinkedList," + quickSorter.getDoublyLinkedListQuickSortTime() + "\n");

		// SelectionSort results.
		out.write("SelectionSort,ArrayList," + selectionSorter.getArrayListSelectionSortTime() + "\n");
		out.write("SelectionSort,SinglyLinkedList," + selectionSorter.getLinkedListSelectionSortTime() + "\n");
		out.write("SelectionSort,DoublyLinkedList," + selectionSorter.getDoublyLinkedListSelectionSortTime() + "\n");

		// LinearSearch results.
		out.write("LinearSearch,ArrayList," + linearSearcher.getArrayListLinearSearchTime() + "\n");
		out.write("LinearSearch,SinglyLinkedList," + linearSearcher.getLinkedListLinearSearchTime() + "\n");
		out.write("LinearSearch,DoublyLinkedList," + linearSearcher.getDoublyLinkedListLinearSearchTime() + "\n");

		// IterativeBinarySearch results.
		out.write("IterativeBinarySearch,ArrayList," + iterativeBinarySearcher.getArrayListIterativeBinarySearchTime()
				+ "\n");
		out.write("IterativeBinarySearch,SinglyLinkedList," + iterativeBinarySearcher.getLinkedListIterativeBinarySearchTime()
				+ "\n");
		out.write("IterativeBinarySearch,DoublyLinkedList,"
				+ iterativeBinarySearcher.getDoublyLinkedListIterativeBinarySearchTime() + "\n");

		// RecursiveBinarySearch results.
		out.write("RecursiveBinarySearch,ArrayList," + recursiveBinarySearcher.getArrayListRecursiveBinarySearchTime()
				+ "\n");
		out.write("RecursiveBinarySearch,SinglyLinkedList," + recursiveBinarySearcher.getLinkedListRecursiveBinarySearchTime()
				+ "\n");
		out.write("RecursiveBinarySearch,DoublyLinkedList,"
				+ recursiveBinarySearcher.getDoublyLinkedListRecursiveBinarySearchTime() + "\n");

		out.close();
		return resultFile; // Returning output file.
	}

	/**
	 * doSimulation
	 * 
	 * Performs tests on data structures.
	 * 
	 * @param validFile Path of clean file.
	 * 
	 * @throws NullArgumentException
	 * @throws InvalidArgumentException
	 * @throws IOException
	 * 
	 * @return void
	 */

	public void doSimulation(File validFile) throws NullArgumentException, InvalidArgumentException, IOException {

		// Sorting tests.
		bubbleSorter.collectionBubbleSort(validFile);
		insertionSorter.collectionInsertionSort(validFile);
		quickSorter.collectionQuickSort(validFile);
		selectionSorter.collectionSelectionSort(validFile);

		// Searching tests.
		linearSearcher.collectionLinearSearch(validFile);
		iterativeBinarySearcher.collectionIterativeBinarySearch(validFile);
		recursiveBinarySearcher.collectionRecursiveBinarySearch(validFile);
	}

	/**
	 * getNewFile
	 * 
	 * Returns the path of output file.
	 * 
	 * @param none
	 * 
	 * @return newFile Path of output file.
	 */

	public String getNewfile() {
		return newFile;
	}
}
