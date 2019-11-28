// Nur Suhaira Bte Badrul Hisham
// 5841549
// Assignment 1 Part 6

public class streamCipher
{
	static Character chartext = ' ';
	static Character letter = ' ';
	static final int SIZE = 40;
	static String ciphertext = "";
	
	public static void main (String [] args)
	{
		System.out.print("\033[H\033[2J");
		
		String type = args [0];
		String text = args [1];
		int key = Integer.parseInt (args [2]);
		
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		int [] keystream = new int [SIZE]; // assume max length of letters in a word/sentence is 40
		int temp = key; // temp storage for value of key/any calculated operation
		int keyCount = 1; // start with 1
		int ks = 0; // keystream index
		
		System.out.println ("Establishing key stream values with key : " + key + "...");
		for (int m = 0; m < SIZE; m++)
		{
			temp = (int) (Math.pow (temp, 2) + keyCount) % 26;
			keystream [m] = temp;
			++keyCount;
		}
		
		if (type.equalsIgnoreCase ("encrypt"))
		{
			System.out.println ("\nEncrypting " + text.toUpperCase () + " with key : " + key + "...");
			
			for (int i = 0; i < text.length (); i++)
			{
				chartext = new Character (text.charAt (i));
				chartext = Character.toUpperCase (chartext);
				for (int j = 0; j < letters.length (); j++) // search the text against A to Z
				{
					letter = new Character (letters.charAt (j));
					if (chartext.equals (letter)) // if message char == letter char; grab the index
					{
						temp = (j + keystream [ks]) % 26;
						if (temp < 0) // if temp is negative
						{
							temp += 26; // add with mod value
						}
						ciphertext = ciphertext.concat (String.valueOf (letters.charAt (temp)));
						++ks; // next keystream index
					}	
				}			
			}
		
			System.out.println ("Ciphertext generated for " + text.toUpperCase () + " : " + ciphertext);
		}
		else if (type.equalsIgnoreCase ("decrypt"))
		{
			System.out.println ("\nDecrypting " + text.toUpperCase () + " with key : " + key + "...");
			for (int i = 0; i < text.length (); i++)
			{
				chartext = new Character (text.charAt (i));
				chartext = Character.toUpperCase (chartext);
				for (int j = 0; j < letters.length (); j++) // search the text against A to Z
				{
					letter = new Character (letters.charAt (j));
					if (chartext.equals (letter)) // if message char == letter char; grab the index
					{
						temp = (j - keystream [ks]) % 26;
						if (temp < 0) // if temp is negative
						{
							temp += 26; // add with mod value
						}
						
						ciphertext = ciphertext.concat (String.valueOf (letters.charAt (temp)));
						++ks; // next keystream index
					}	
				}			
			}
		
			System.out.println ("Plaintext generated for " + text.toUpperCase () + " : " + ciphertext);
		}
	}	
}
