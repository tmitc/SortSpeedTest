/**
@author tmitc
@version 1.0
This SortSpeedTest program reads a text file of unsorted numbers,
(specifically a file containing prime numbers can be chaned to any integer number file),
calculates how fast it takes to both bubble and selection sort the same set of numbers,
and then prints the resulting sort times in ms.
User is given option to print the resulting sorted numbers.
*/

import java.util.Scanner;
import java.io.*;

public class SortSpeedTest
{
	public static void main(String[] args) throws IOException
	{
		//accumulator will hold (and confirm) the amount of prime numbers in file
		int numberCounter = 0;
		
		//Scanner object for keyboard input
		Scanner keyboard = new Scanner(System.in);
		
		//Dispay opening prompt
		System.out.println("-Sorting Algorithms Speed Test-\nEnter in any key to start the test");
		keyboard.nextLine();
		
		//Open file with prime numbers to read from as Scanner object
		File myFile = new File("Primes1.txt");
		Scanner inputFile = new Scanner(myFile);
		
		//confirm the quantity of numbers in the file
		while (inputFile.hasNextInt()) //used to make sure end of file has not reached
		{
			inputFile.nextLine();
			numberCounter++;
		}
		
		//create array to store numbers from file
		int[] array1 = new int[numberCounter];
		
		//set scanner position back to read from the beginging of file
		inputFile.close();
		inputFile = new Scanner(myFile);
		
		//will increment next position in array after each number
		numberCounter = 0;
		
		//save contents of file (all the prime numbers) to an array
		while (inputFile.hasNextInt()) //used to make sure end of file has not reached
		{
			array1[numberCounter] = inputFile.nextInt();
			numberCounter++;
		}
		
		//clone array1 into array2
		int[] array2 = new int[array1.length];
		
		for (int i = 0; i < array1.length; i++)
		{
			array2[i] = array1[i];
		}
		
		//inform the user of what is going on
		System.out.println("Bubble sorting " + array1.length + " prime numbers...");
		
	//Bubble sort Portion
		//start timer
		long beginTime = System.currentTimeMillis();

		bubbleSort(array1);
		
		//stop timer
		long endTime = System.currentTimeMillis();
		
		//calculate bubble sort runtime
		long runTimeBubbleSort = endTime - beginTime;
		
		//prints first and last 10 indexes of sorted array
		printTen(array1);
		
	//Selection sort portion
		
		//inform the user as to what is going on
		System.out.println("\nSelection sorting " + array1.length + " prime numbers...");
		
		//start timer
		beginTime = System.currentTimeMillis();
		
		selectionSort(array2);
		
		//stop timer
		endTime = System.currentTimeMillis();
		
		//calculate selection sort runtime
		long runTimeSelectionSort = endTime - beginTime;
		
		//prints first and last 10 indexes of sorted array
		printTen(array2);
		 
		//display results
		System.out.println("\nBubble sort runtime: " + runTimeBubbleSort + "ms");
		System.out.println("Selection sort runtime: " + runTimeSelectionSort + "ms");
	}
	
	/**
	The bubbleSort method takes an array of integers and bubble sorts the array.
	@param array1 - an array of unsorted integers.
	*/
	public static void bubbleSort(int[] array1)
	{
		int arraySortTemp;
		int indexMinus = 0;
		

		//bubble sort Array1		
		for (int j = 0; j < array1.length - 1; j++)
		{
			for (int i = 0; i < (array1.length - indexMinus - 1); i++)
			{
				if (array1[i] > array1[i+1])
				{
					arraySortTemp = array1[i];
					array1[i] = array1[i+1];
					array1[i+1] = arraySortTemp;
				}
			}
			indexMinus++;
		}
		return;
	}
	
	/**
	The selectionSort method takes an array of integers and selection sorts the array.
	@param array2 - an array of unsorted integers.
	*/
	public static void selectionSort(int[] array2)
	{
		//current index being compaired for swap in the selection sort
		int indexCurrent = array2.length - 1;
		
		int arraySortTemp;

		for (int j = 0; j < array2.length - 1; j++)
		{	
			for (int i = 0; i < (indexCurrent - 1); i++)
			{
				if (array2[indexCurrent] < array2[i])
				{
					arraySortTemp = array2[i];
					array2[i] = array2[indexCurrent];
					array2[indexCurrent] = arraySortTemp;
				}
			}
			indexCurrent--;
		}
		return;
	}
	
	
	/**
	The printTen method prints the first and last 10 indexes of an array
	@param sortedArray - an array of integers whose elements have been pre-sorted
	*/
	public static void printTen(int[] sortedArray)
	{
		String frst10 = "First 10",
		lst10 = "Last 10";
		
		System.out.printf("%-10s %-10s\n", frst10, lst10);
		for (int i = 0; i < 10; i++)
		{
			System.out.printf("%-10d %-10d\n", sortedArray[i], sortedArray[sortedArray.length - 1 - i]);
		}
		return;
	}
}