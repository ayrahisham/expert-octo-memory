// Nur Suhaira Bte Badrul Hisham
// 5841549
// Assignment 1 Part 2

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.NoSuchElementException;

public class indexOfCoincidence
{
	static Scanner infile;
	static Scanner input = new Scanner (System.in);
	
	public static void main (String [] args)
	{
		System.out.print("\033[H\033[2J");
		String filename = args [0];
		int total = 0; // length of text
		int frequency = 0; // freq. from A to Z 
		
		if (checkInputfile (filename))
		{
			System.out.println ("\nCurrently viewing: " + filename);
			System.out.print ("Would you like to change file? [Y/N]: ");
			char change = input.next().charAt(0);
		
			input.nextLine ();
			if (change == 'Y' || change == 'y')
			{
				System.out.print ("New filename: ");
				String newfilename = input.nextLine ();
				if (checkInputfile (newfilename))
				{
					filename = newfilename;
				}
				else
				{
					System.out.println (filename + " will remain to be used");
				}
			}
			
			System.out.println ("\nReading content in " + filename + "...");
			try
			{
				BufferedReader br; 
				String letters = "abcdefghijklmnopqrstuvwxyz";
				int count; // count of occurence of each letter (e.g. A, B, C etc.)
				int intletter = 0;
				Character charletter;
				Character plaintext;
				
				for (int i = 0; i < letters.length (); i++) // search the text for A to Z
				{
					count = 0;
					charletter = new Character (letters.charAt (i)); // start from A
					br = new BufferedReader (new FileReader (filename));
					while ((intletter = br.read()) != -1) 
					{
						plaintext = new Character ((char) intletter);
						if (Character.isLetter (plaintext))
						{
							if ((plaintext.equals (charletter)) || (plaintext.equals (Character.toUpperCase (charletter))))
							{
								count += 1; // increment of count
							}
						}		
					}
					
					System.out.println ("Number of Occurences for " + charletter + "/" +
					Character.toUpperCase (charletter) + " : " + count);
					frequency += (count * (count-1));
					total += count;
				}
			}
			catch (IOException e)
			{
				System.err.println ("Error in IO");
				System.exit (1);
			}
			catch (NoSuchElementException e)
			{
				System.err.println ("File is empty");
				System.exit (1);
			}
			
			double ic = frequency * 1.0 / (total * (total-1)); // multiply 1.0 to make it double
			System.out.format ("%s%.3f%s", "\nIndex of Coincidence : \t", ic, "\n");
			
		}
		else
		{
			System.out.println ("File does not exist");
			System.exit (1);
		}
	}
	
	public static boolean checkInputfile (String filename)
	{
		try
		{
			infile = new Scanner (Paths.get (filename));
		}
		catch (FileNotFoundException f)
		{
			System.err.println ("File does not exist");
			return false;
		}
		catch (IOException e)
		{
			System.err.println ("Error in IO");
			return false;
		}
		
		if (infile != null)
		{
			infile.close ();
			System.out.println (filename + " checked OK.");
		}
		
		return true;
	}	
}
