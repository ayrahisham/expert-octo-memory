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

public class mutualIndexOfCoincidence
{
	static Scanner infile;
	static Scanner input = new Scanner (System.in);
	
	public static void main (String [] args)
	{
		System.out.print("\033[H\033[2J");
		
		String filename1 = args [0];
		String filename2 = args [1];
		int totalA = 0; // length of text1
		int frequency = 0; // freq. from A to Z 
		int totalB = 0; // length of text2
		
		if ((checkInputfile (filename1)) && (checkInputfile (filename2)))
		{
			System.out.println ("\nCurrently viewing: " + filename1 + " and " + filename2);
			System.out.print ("Would you like to change files? [Y/N]: ");
			char change = input.next().charAt(0);
		
			input.nextLine ();
			if (change == 'Y' || change == 'y')
			{
				System.out.print ("New filename 1: ");
				String newfilename1 = input.nextLine ();
				System.out.print ("New filename 2: ");
				String newfilename2 = input.nextLine ();
				if ((checkInputfile (newfilename1)) && (checkInputfile (newfilename2)))
				{
					filename1 = newfilename1;
					filename2 = newfilename2;
				}
				else
				{
					System.out.println (filename1 + " and " + filename2 + " will remain to be used");
				}
			}
			
			System.out.println ("\nReading content in " + filename1 + " and " + filename2 + "...");
			try
			{
				BufferedReader br1; 
				BufferedReader br2;
				String letters = "abcdefghijklmnopqrstuvwxyz";
				int countA; // count of occurence of each letter in 1st file (e.g. A, B, C etc.)
				int countB; // count of occurence of each letter in 2nd file (e.g. A, B, C etc.)
				int intletter = 0;
				Character charletter;
				Character plaintext;
				
				for (int i = 0; i < letters.length (); i++) // search the text for A to Z
				{
					countA = 0;
					countB = 0;
					charletter = new Character (letters.charAt (i)); // start from A
					
					// iterate thru first file
					br1 = new BufferedReader (new FileReader (filename1));
					while ((intletter = br1.read()) != -1) 
					{
						plaintext = new Character ((char) intletter);
						if (Character.isLetter (plaintext))
						{
							if ((plaintext.equals (charletter)) || (plaintext.equals (Character.toUpperCase (charletter))))
							{
								countA += 1; // increment of count
							}
						}		
					}
					
					// iterate thru second file
					br2 = new BufferedReader (new FileReader (filename2));
					while ((intletter = br2.read()) != -1) 
					{
						plaintext = new Character ((char) intletter);
						if (Character.isLetter (plaintext))
						{
							if ((plaintext.equals (charletter)) || (plaintext.equals (Character.toUpperCase (charletter))))
							{
								countB += 1; // increment of count
							}
						}		
					}
					
					System.out.println ("(*) Occurences for " + charletter + "/" +
					Character.toUpperCase (charletter) + " : " + countA * countB);
					frequency += (countA * countB);
					totalA += countA;
					totalB += countB;
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
			
			double mic = frequency * 1.0 / (totalA * totalB); // multiply 1.0 to make it double
			System.out.format ("%s%.3f%s", "\nMutual Index of Coincidence : \t", mic, "\n");
			
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
