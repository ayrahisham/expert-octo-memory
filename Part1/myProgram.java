// Nur Suhaira Bte Badrul Hisham
// 5841549
// Assignment 1 Part 1

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.NoSuchElementException;

public class myProgram
{
	static Formatter outfile;
	static Scanner infile;
	static Scanner input = new Scanner (System.in);
	static int option;
	static String filename = ""; // input file
	static String cfilename = ""; // output file
	static int a = 0;
	static int b = 0;
	static String lettersUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static String lettersLower = "abcdefghijklmnopqrstuvwxyz";
	
	public static void main (String [] args)
	{
		System.out.print("\033[H\033[2J");
		
		// generate a new or exising file
		option = displayFileMenu ();
		
		// process new or exisitng file based on user choice
		filename = processFile (option);
		
		do
		{
			// prompt menu to process on chosen file e.g. encrypt, decrypt etc.
			option = displayMenu (filename);
			switch (option)
			{
				
				case 1: System.out.println ("Enter your secret key (a, b): ");
					a = enterKeyA ();
					b = enterKeyB ();
					break;
				case 2: encrypt (filename, a, b);
					break;
				case 3: decrypt (filename, a, b);
					break;
				case 4: print (filename);
					break;
				case 5: System.out.println ("Thank you for using Affine Cipher...");
						System.exit (1);
			}
			
		} while (option > 0 && option < 5);
	}
	
	public static int displayFileMenu ()
	{
		int choice = 1; // default option
		
		System.out.println ("Welcome to [Affine Cipher - Encryption/Decryption]\n");
		
		do
		{
			System.out.println ("Please select your option: [1 - 3]");
			System.out.println ("\t1) Create new text file\n\t2) Use existing file\n\t3) Quit program");
			System.out.print ("Your choice: ");
			choice = input.nextInt ();
			input.nextLine ();
			
		} while (choice < 1 || choice > 3);
		
		return choice;
	}
	
	public static boolean generateOutfile (String filename)
	{
		// create output file
		try
		{
			outfile = new Formatter (filename);
		}
		catch (IOException e)
		{
			System.err.println ("Error in IO");
			return false;
		}
		catch (SecurityException s)
		{
			System.err.println ("Write permission denied");
			return false;
		}
		
		System.out.println ("Enter content of file: <press enter to end>");
		String para = input.nextLine ();
		outfile.format ("%s%n", para);
		
		if (outfile != null)
		{
			outfile.close ();
			System.out.println (filename + " has been generated.");
		}
		
		return true;
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
	
	public static String processFile (int option)
	{
		String filename = "";
		boolean ok;
		
		do
		{
			ok = true;
			switch (option)
			{
				case 1: System.out.print ("\nEnter new filename: ");
					filename = input.nextLine ();
					if (!generateOutfile (filename))
					{
						ok = false;
					}
					break;
				case 2:	System.out.print ("\nEnter existing filename: ");
					filename = input.nextLine ();
					if (!checkInputfile (filename))
					{
						ok = false;
					}
					break;
				case 3: System.out.println ("Thank you for using Affine Cipher...");
					System.exit (1);
			
			}
		} while (ok == false);
		
		return filename;
	}
	
	public static int displayMenu (String filename)
	{
		int choice = 1; // default option
		
		System.out.println ("\n///////////////////////////////////////////////////\n");
		
		System.out.println ("Processing current filename: " + filename);
		
		do
		{
			System.out.println ("Please select your option: [1 - 5]");
			System.out.println ("\t1) Enter secret key\n\t2) Encryption\n\t3) Decryption\n\t4) Print content\n\t5) Quit program");
			System.out.print ("Your choice: ");
			choice = input.nextInt ();
			input.nextLine ();
			
		} while (choice < 1 || choice > 5);
		
		return choice;
	}
	
	public static int enterKeyA ()
	{
		System.out.print ("Key a: ");
		a = input.nextInt ();
		return a;
	}
	
	public static int enterKeyB ()
	{
		System.out.print ("Key b: ");
		b = input.nextInt ();
		return b;
	}
	
	public static void encrypt (String filename, int a, int b)
	{
		if (a == 0)
		{
			System.out.println ("\nKey 'a' cannot be 0. Please re-nter: ");
			System.out.print ("Key a: ");
			a = input.nextInt ();
		}
		else if (a == 1)
		{
			if (b == 0)
			{
				System.out.println ("\nKey 'b' cannot be 0 when key 'a' = 1. Please re-nter: ");
				System.out.print ("Key b: ");
				b = input.nextInt ();
			}	
		}
		
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
		
		System.out.print ("\nEnter output filename: ");
		cfilename = input.nextLine ();
		
		System.out.println ("\nCurrent - Key a: " + a + "\tKey b: " + b);
		System.out.print ("Would you like to change key? [Y/N]: ");
		change = input.next().charAt(0);
		
		input.nextLine ();
		if (change == 'Y' || change == 'y')
		{
			a = enterKeyA ();
			b = enterKeyB ();
			System.out.println ("Changed - Key a: " + a + "\tKey b: " + b);
		}
		
		System.out.println ("\nViewing content before encryption:");
		print (filename);
		
		System.out.println ("\nEncrypting content in " + filename + "...");
		try (BufferedReader br = new BufferedReader (new FileReader (filename))) 
		{
			try
			{
				outfile = new Formatter (cfilename);
			}
			catch (IOException e)
			{
				System.err.println ("Error in IO");
			}
			catch (SecurityException s)
			{
				System.err.println ("Write permission denied");
			}
			
			int intM = 0; // plaintext in int
			char charM = ' '; // plaintext in char
			int intC = 0; // ciphertext in int
			char charC = ' '; // ciphertext in char
			while ((intM = br.read()) != -1) 
			{
				charM = (char) intM;
				if (Character.isLetter (charM))
				{
					if (Character.isUpperCase (charM))
					{
						for (int i = 0; i < lettersUpper.length (); i++)
						{
							if (charM == lettersUpper.charAt (i))
							{
								intM = i; // getting the index of letters that match the char
							}
						}
						
						intC = (a * intM + b) % 26; // 26 uppercase letters
						charC = lettersUpper.charAt (intC);
						System.out.print (charC);
						outfile.format ("%c", charC);
					}
					else if (Character.isLowerCase (charM))
					{
						if (Character.isLowerCase (charM))
						{
							for (int i = 0; i < lettersLower.length (); i++)
							{
								if (charM == lettersLower.charAt (i))
								{
									intM = i; // getting the index of letters that match the char
								}
							}
						
							intC = (a * intM + b) % 26; // 26 lowercase letters
							charC = lettersLower.charAt (intC);
							System.out.print (charC);
							outfile.format ("%c", charC);
						}
					}
				}
				else
				{
					System.out.print (charM);
					outfile.format ("%c", charM);
				}
				
			}
			
			if (outfile != null)
			{
				outfile.close ();
				System.out.println ("\n" + cfilename + " has been generated.");
			}
		}
		catch (IOException e)
		{
			System.err.println ("Error in IO");
		}
	}
	
	public static int modInverse (int a, int m) 
	{ 
		a = a % m; 
		
		for (int x = 1; x < m; x++) 
		{
		   if ((a * x) % m == 1) 
		   {
		   	return x;
		   }
		}
		 
		return 1; 
	} 
	
	public static void decrypt (String filename, int a, int b)
	{
		if (a == 0)
		{
			System.out.println ("\nKey 'a' cannot be 0. Please re-nter: ");
			System.out.print ("Key a: ");
			a = input.nextInt ();
		}
		else if (a == 1)
		{
			if (b == 0)
			{
				System.out.println ("\nKey 'b' cannot be 0 when key 'a' = 1. Please re-nter: ");
				System.out.print ("Key b: ");
				b = input.nextInt ();
			}	
		}
		
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
		
		System.out.print ("\nEnter output filename: ");
		cfilename = input.nextLine ();
		
		System.out.println ("\nCurrent - Key a: " + a + "\tKey b: " + b);
		System.out.print ("Would you like to change key? [Y/N]: ");
		change = input.next().charAt(0);
		
		input.nextLine ();
		if (change == 'Y' || change == 'y')
		{
			a = enterKeyA ();
			b = enterKeyB ();
			System.out.println ("Changed - Key a: " + a + "\tKey b: " + b);
		}
		
		System.out.println ("\nViewing content before decryption:");
		print (filename);
		
		System.out.println ("\nDecrypting content in " + filename + "...");
		try (BufferedReader br = new BufferedReader (new FileReader (filename))) 
		{
			try
			{
				outfile = new Formatter (cfilename);
			}
			catch (IOException e)
			{
				System.err.println ("Error in IO");
			}
			catch (SecurityException s)
			{
				System.err.println ("Write permission denied");
			}
			
			int intM = 0; // plaintext in int
			char charM = ' '; // plaintext in char
			int intC = 0; // ciphertext in int
			char charC = ' '; // ciphertext in char
			a = modInverse (a, 52); // inverse of a
			while ((intC = br.read()) != -1) 
			{
				charC = (char) intC;
				
				if (Character.isLetter (charC))
				{
					if (Character.isUpperCase (charC))
					{
						for (int i = 0; i < lettersUpper.length (); i++)
						{
							if (charC == lettersUpper.charAt (i))
							{
								intC = i; // getting the index of letters that match the char
							}
						}
						intC = intC - b;
						if (intC < 0) // check that intC is not negative
						{
							intC += 26; // if yes, add with mod value which is 52
						}
						intM = (intC * a) % 26; // 52 uppercase and lowercase letters
						charM = lettersUpper.charAt (intM);
						System.out.print (charM);
						outfile.format ("%c", charM);
					}
					else if (Character.isLowerCase (charC))
					{
						for (int i = 0; i < lettersLower.length (); i++)
						{
							if (charC == lettersLower.charAt (i))
							{
								intC = i; // getting the index of letters that match the char
							}
						}
						intC = intC - b;
						if (intC < 0) // check that intC is not negative
						{
							intC += 26; // if yes, add with mod value which is 52
						}
						intM = (intC * a) % 26; // 52 uppercase and lowercase letters
						charM = lettersLower.charAt (intM);
						System.out.print (charM);
						outfile.format ("%c", charM);
					}
				}
				else
				{
					System.out.print (charC);
					outfile.format ("%c", charC);
				}
				
			}
			
			if (outfile != null)
			{
				outfile.close ();
				System.out.println ("\n" + cfilename + " has been generated.");
			}
		}
		catch (IOException e)
		{
			System.err.println ("Error in IO");
		}
	}
	
	public static void print (String filename)
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
		
		System.out.println ("\nReading content in " + filename + ":");
		try (BufferedReader br = new BufferedReader (new FileReader (filename))) 
		{
			String line = null;
			
			while ((line = br.readLine()) != null) 
			{
				System.out.println (line);
			}
		}
		catch (IOException e)
		{
			System.err.println ("Error in IO");
		}
		System.out.println ("\n");
	}
}
