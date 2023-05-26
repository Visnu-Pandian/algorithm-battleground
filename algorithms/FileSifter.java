/**
 * The main file interaction class for the project. Generates clean files, determines file size and creates data structures to be tested.
 * 
 * @author Visnu Pandian
 * @version 1.0
 * @since 04-06-2023
 */

package project3.algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import project2.lists.ArrayList;
import project2.lists.DoublyLinkedList;
import project2.lists.SinglyLinkedList;

public class FileSifter<T> {

	// Path of clean file. Edit to change location of clean file.
	final static String newFile = "C:/Users/vsp00/eclipse-workspace/CS 111 Lab 2023/src/palfa_validated.txt";
	int size;

	/**
	 * scanFile
	 * 
	 * Validates signals and generates clean file.
	 * 
	 * @param fileName Path of raw data file.
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * 
	 * @return validatedFilePath Path of clean file.
	 */

	public File scanFile(String fileName) throws FileNotFoundException, IOException {

		// Initializing instances to read and write to/from file.
		FileReader reader = new FileReader(fileName);
		BufferedReader in = new BufferedReader(reader);
		FileWriter writer = new FileWriter(newFile);
		BufferedWriter out = new BufferedWriter(writer);

		// Initializing variables.
		int skipCount = 0;
		int passCount = 0;

		// Reading one line in advance to skip the headers.
		in.readLine();

		Long start = System.currentTimeMillis(); // Starting timer for initial file parse.

		// Reading file and writing clean signals to new file.
		while (in.ready()) {
			String line = in.readLine();
			try {
				@SuppressWarnings("unused")
				Signal signal = new Signal(line); // Creating signals to check for error in formatting.
				out.write(line + "\n"); // Writing clean values to clean file.
				passCount += 1;
			} catch (NumberFormatException e) {
				skipCount++;
				// Outputting lines which are not formatted correctly with their location.
				System.out.println("Unable to parse line at position " + (passCount + skipCount) + ": " + line);
			}
		}
		Long end = System.currentTimeMillis(); // Ending timer for initial file parse.

		// Closing reader and writer.
		in.close();
		out.close();

		// Outputting information regarding file parse.
		System.out.println("\nNew file: " + newFile + " has been created with validated values.");
		System.out.println("\n" + passCount + " signals were validated and " + skipCount + " signals were skipped.\n");
		System.out.println("Average time for each validation: " + (double) (end - start) / (passCount * 1000) + "s\n");
		File validatedFilePath = new File(newFile);
		return validatedFilePath; // Returning clean file.
	}

	/**
	 * fileSize
	 * 
	 * Determines number of signals in file.
	 * 
	 * @param filePath Path of clean file.
	 * 
	 * @throws IOException
	 * 
	 * @return size Number of signals in validated file.
	 */

	public int fileSize(File filePath) throws IOException {

		// Initializing instances to read from file.
		FileReader reader = new FileReader(filePath);
		BufferedReader in = new BufferedReader(reader);

		// Resetting size.
		size = 0;
		// Iterating through file.
		while (in.ready()) {
			in.readLine();
			size++; // Incrementing size.
		}
		in.close();
		return size; // Returning size of file.
	}

	/**
	 * toArrayList
	 * 
	 * Converts file into generic ArrayList data structure.
	 * 
	 * @param filePath Path of clean file.
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * 
	 * @return List Generic ArrayList.
	 */

	public ArrayList<Signal> toArrayList(File filePath) throws FileNotFoundException, IOException {
		ArrayList<Signal> List = new ArrayList<Signal>();

		// Initializing instances to read from file.
		FileReader reader = new FileReader(filePath);
		BufferedReader in = new BufferedReader(reader);

		// Iterating through file.
		while (in.ready()) {
			// Adding signals to generic ArrayList.
			String line = in.readLine();
			Signal signal = new Signal(line);
			List.add(signal);
		}
		in.close();

		return List; // returning generic ArrayList.

	}

	/**
	 * toLinkedList
	 * 
	 * Converts file into generic SinglyLinkedList data structure.
	 * 
	 * @param filePath Path of clean file.
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * 
	 * @return List Generic SinglyLinkedList.
	 */

	public SinglyLinkedList<Signal> toLinkedList(File filePath) throws FileNotFoundException, IOException {
		SinglyLinkedList<Signal> List = new SinglyLinkedList<Signal>();

		// Initializing instances to read from file.
		FileReader reader = new FileReader(filePath);
		BufferedReader in = new BufferedReader(reader);

		// Iterating through file.
		while (in.ready()) {
			// Adding signals to generic SinglyLinkedList.
			String line = in.readLine();
			Signal signal = new Signal(line);
			List.add(signal);
		}
		in.close();

		return List; // returning generic SinglyLinkedList.
	}

	/**
	 * toDoublyLinkedList
	 * 
	 * Converts file into generic DoublyLinkedList data structure.
	 * 
	 * @param filePath Path of clean file.
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * 
	 * @return List Generic DoublyLinkedList.
	 */

	public DoublyLinkedList<Signal> toDoublyLinkedList(File filePath) throws FileNotFoundException, IOException {
		DoublyLinkedList<Signal> List = new DoublyLinkedList<Signal>();

		// Initializing instances to read from file.
		FileReader reader = new FileReader(filePath);
		BufferedReader in = new BufferedReader(reader);

		// Iterating through file.
		while (in.ready()) {
			// Adding signals to generic DoublyLinkedList.
			String line = in.readLine();
			Signal signal = new Signal(line);
			List.add(signal);
		}
		in.close();

		return List; // returning generic DoublyLinkedList.

	}
}
