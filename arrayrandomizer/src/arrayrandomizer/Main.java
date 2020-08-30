package arrayrandomizer;

import static java.lang.System.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException
	{
		File f = new File("file.txt");
		Scanner scan = new Scanner(f);
		ArrayList<String> ar = new ArrayList<String>();
		
		while(scan.hasNextLine())
		{
			String s = scan.nextLine();
			ar.add(s);
			
		}
		
	/*	ArrayList<Integer[]> blurgh = new ArrayList<Integer[]>();
		for(int i = 0; i < ar.size(); i++)
		{
			Integer[] temp = convert(ar.get(i));
			blurgh.add(temp);
		}*/
		/*
		 * 
Arr1 size = 10
Arr2 size = 50
Arr3 size = 10
Arr4 size = 30
Arr5 size = 100

		 */
		
		//the above code was to conver the string into an array
		//bubble selection insertion merge quick shell heap
	//	AllSorts as = new AllSorts();
		//gotta make sure they are sorted
		int count = 0;
		AllSorts as = new AllSorts();
		
		do {
			ArrayList<Integer[]> ars = new ArrayList<Integer[]>();
			for(int i = 0; i < ar.size(); i++)
			{
				Integer[] temp = convert(ar.get(i));
				ars.add(temp);
			}
			
			if (count == 7)
			{
				break;
			}
			
			for(int i = 0; i < ars.size(); i++)
			{	
				int n = ars.get(i).length;
				
				if(count == 0)
				{
					if(i == 0)
					{
						out.println("BUBBLESORT");
					}
					out.println("Original :: " + Arrays.toString(ars.get(i))); 
					as.bubbleSort(ars.get(i));
					out.println("Sorted :: " + Arrays.toString(ars.get(i)));
					out.println("Best Case :: " + n);
					out.println("Worst Case :: " + Math.pow(n, 2));
					as.resetCount();
					out.println();
				}
				
				if(count == 1)
				{
					if(i == 0)
					{
						out.println("SELECTIONSORT");
					}
					out.println("Original :: " + Arrays.toString(ars.get(i))); 
					as.selectionSort(ars.get(i));
					out.println("Sorted :: " + Arrays.toString(ars.get(i)));
					out.println("Best Case :: " + Math.pow(n, 2));
					out.println("Worst Case :: " + Math.pow(n, 2));
					as.resetCount();
					out.println();
				}
				
				if(count == 2)
				{
					if(i == 0)
					{
						out.println("INSERTIONSORT");
					}
					out.println("Original :: " + Arrays.toString(ars.get(i))); 
					as.insertionSort(ars.get(i));
					out.println("Sorted :: " + Arrays.toString(ars.get(i)));
					out.println("Best Case :: " + n);
					out.println("Worst Case :: " + Math.pow(n, 2));
					as.resetCount();
					out.println();
				}
				
				if(count == 3)
				{
					if(i == 0)
					{
						out.println("MERGESORT");
					}
					out.println("Original :: " + Arrays.toString(ars.get(i))); 
					as.mergeSort(ars.get(i), 0, ars.get(i).length-1);
					out.println("Sorted :: " + Arrays.toString(ars.get(i)));
					out.println("Best Case :: " + n * Math.log(n));
					out.println("Worst Case :: " + n * Math.log(n));
					as.resetCount();
					out.println();	
				}
				
				if(count == 4)
				{
					if(i == 0)
					{
						out.println("QUICKSORT");
					}
					out.println("Original :: " + Arrays.toString(ars.get(i))); 
					as.quickSort(ars.get(i), 0, ars.get(i).length-1);
					out.println("Sorted :: " + Arrays.toString(ars.get(i)));
					out.println("Best Case :: " + n * Math.log(n));
					out.println("Worst Case :: " + Math.pow(n, 2));
					as.resetCount();
					out.println();
				}
				
				if(count == 5)
				{
					if(i == 0)
					{
						out.println("SHELLSORT");
					}
					out.println("Original :: " + Arrays.toString(ars.get(i))); 
					as.shellSort(ars.get(i));
					out.println("Sorted :: " + Arrays.toString(ars.get(i)));
					out.println("Best Case :: " + n * Math.log(n));
					out.println("Worst Case :: " + Math.pow(n, 2));
					as.resetCount();
					out.println();
				}
				
				if(count == 6)
				{
					if(i == 0)
					{
						out.println("HEAPSORT");
					}
					out.println("Original :: " + Arrays.toString(ars.get(i))); 
					as.heapSort(ars.get(i));
					out.println("Sorted :: " + Arrays.toString(ars.get(i)));
					out.println("Best Case :: " + n * Math.log(n));
					out.println("Worst Case :: " + Math.pow(n, 2));
					as.resetCount();
					out.println();
				}
			}
		
			count++;
		}while(1 > 0);
	}
	
	
	public static Integer[] convert(String comp) //converts from string to array
	
	{
		Integer[] temp;
		ArrayList<Integer> ints = new ArrayList<Integer>();
		
		String s = comp.replace(",", "").replace("[", "").replace("]", "");
		Scanner scan = new Scanner(s);
		
		while(scan.hasNextLine())
		{
			String temper = scan.nextLine();
			Scanner scanner = new Scanner(temper);
			
			while(scanner.hasNextInt())
			{
				ints.add(scanner.nextInt());
			}
		}
		
		temp = new Integer[ints.size()];
		
		for(int i = 0; i < ints.size(); i++)
		{
			temp[i] = ints.get(i);
		}
		
		return temp;
	}
	
}
