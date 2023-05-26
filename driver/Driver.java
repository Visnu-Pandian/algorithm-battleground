/**
 * The main driver for the project. Reads the given text file, performs tests on it and writes data into an output file.
 * 
 * @author Visnu Pandian
 * @version 1.0
 * @since 04-06-2023
 */

package project3.driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import project1.exceptions.InvalidArgumentException;
import project1.exceptions.NullArgumentException;
import project3.algorithms.FileSifter;
import project3.algorithms.Result;

public class Driver {

	// Custom error message prompting user to enter file path.
	final static String CMD_ABSENT_MSG = "No cmd line argument entered.\nPlease enter name of file to read data from: ";

	public static <T> void main(String[] args)
			throws FileNotFoundException, IOException, NullArgumentException, InvalidArgumentException {

		// Initializing instances of required classes.
		FileSifter<T> sifter = new FileSifter<T>();
		Result<T> result = new Result<T>();
		Scanner input = new Scanner(System.in);

		// Initializing variables.
		File validFile = null;
		String inputFile = "";

		// Getting path of file from main args.
		if (args.length > 0)
			inputFile = args[0];
		else {
			// Asking for path if not present in args.
			System.out.println(CMD_ABSENT_MSG);
			inputFile = input.nextLine();
		}
		input.close();
		System.out.println("Opening file: " + inputFile + "\n");

		// Validating data to generate clean file.
		try {
			validFile = sifter.scanFile(inputFile);
		} catch (FileNotFoundException e) {
			// If file path provided by user does not exist.
			System.out.println("\nFile: " + inputFile + " was not found. Terminating program.");
		}

		System.out.println("\nTest results: ");

		// Performing tests on clean file.
		result.doSimulation(validFile);

		// Writing test results to new file.
		result.getResult(result.getNewfile());
	}
}
