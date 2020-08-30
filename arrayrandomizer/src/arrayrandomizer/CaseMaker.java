package arrayrandomizer;

import java.io.*;
import java.util.Arrays;

public class CaseMaker {
	
	private static FileWriter fw;
	private static String temp;
	public static void main(String[] args) throws IOException
	{
		CaseMaker cm = new CaseMaker();
	}
	
	public CaseMaker() throws IOException
	{
		fw = new FileWriter("c:/temp/file.txt");
	}
	public void writeCases(int size, int max) throws IOException	
	{
		temp = Arrays.toString(makeCases(size, max));
		fw.write(temp);
		fw.write("\n");
	}
	
	private int[] makeCases(int size, int max)
	{
		int[] a = new int[size];
		
		for(int i = 0; i < size; i++)
		{
			a[i] = (int)(Math.random() * ((max+1) - 0) + 0);
		}
		
		return a;
	}
	
	public void closeCase() throws IOException
	{
		fw.close();
	}
	
	public String toString()
	{
		 return temp;
	}
}
