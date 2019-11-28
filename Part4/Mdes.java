// Nur Suhaira Bte Badrul Hisham
// 5841549
// Assignment 1 Part 4 Qn 4

import java.util.Scanner;
import java.lang.Math;

public class Mdes
{
	static Scanner input = new Scanner (System.in);
	static int plaintext = 0; // default value
	static String key1 = "";
	static String key2 = "";
	static String strkey = "";
	static int key = 0;
	static String method = "";
	
	public static void main (String [] args)
	{
		System.out.print("\033[H\033[2J");
		
		System.out.println ("[Welcome to Block Cipher Mini DES]");
		
		method = inputCrypt ();
		
		if (method.equalsIgnoreCase ("encrypt"))
		{
			plaintext = inputPlaintext ();
			String strplain = String.format ("%4s", Integer.toBinaryString (plaintext)).replace (' ', '0');
			System.out.println ("Plaintext                : \t" + strplain);
		
			System.out.println ("\nRotating left...");
			if ((!strplain.equals ("0000")) && (!strplain.equals ("1111")))
			{
				plaintext = leftRotate4bit (plaintext);
			}
		
			strplain = String.format ("%4s", Integer.toBinaryString (plaintext)).replace (' ', '0');
			strplain = strplain.substring (0, 4);
			System.out.println ("Plaintext (left rotation): \t" + strplain);
		
			key = inputKey ();
			String strkey = String.format ("%2s", Integer.toBinaryString (key)).replace (' ', '0');
	    		System.out.println ("Key                       : \t" + strkey);
	    		key1 = strkey.substring (0, 1); // first value of key
	    		key2 = strkey.substring (1); // second value of key
	    		
	    		key1 = key1 + key1 + key1; // K1 = K1K1K1
	    		key2 = key2 + key2 + key2; // K2 = K2K2K2
		
			if (key1 != null) // k1 exists
			{	
				System.out.println ("\n1st round");
				System.out.println ("=========");
				strplain = function (key1, strplain);
				System.out.println ("Plaintext (1st round)    : \t" + strplain);
			}
		
			if (key2 != null) // k1 exists
			{	
				System.out.println ("\n2nd round");
				System.out.println ("=========");
				strplain = function (key2, strplain);
				System.out.println ("Plaintext (2nd round)    : \t" + strplain);
			}
		
			System.out.println ("\nSwapping...");
			String left = strplain.substring (0, 2); // A2
			String right = strplain.substring (2, 4); // B2
			String temp;
			temp = left;
			left = right;
			right = temp;
			strplain = left + right;
			System.out.println ("Plaintext (swapping)       : \t" + strplain);
			
			System.out.println ("\nRotating right...");
			plaintext = Integer.parseInt (strplain, 2);
			plaintext = rightRotate4bit (plaintext);
			strplain = String.format ("%4s", Integer.toBinaryString (plaintext)).replace (' ', '0');
			strplain = strplain.substring (0, 4);
			
			System.out.println ("Ciphertext              : \t" + strplain);
			System.out.println ("Ciphertext (integer)    : \t" + Integer.parseInt (strplain, 2));
		}
		else if (method.equalsIgnoreCase ("decrypt"))
		{
			plaintext = inputPlaintext ();
			String strplain = String.format ("%4s", Integer.toBinaryString (plaintext)).replace (' ', '0');	
			System.out.println ("Ciphertext                : \t" + strplain);
		
			System.out.println ("\nRotating left...");
			if ((!strplain.equals ("0000")) && (!strplain.equals ("1111")))
			{
				plaintext = leftRotate4bit (plaintext);
			}
		
			strplain = String.format ("%4s", Integer.toBinaryString (plaintext)).replace (' ', '0');
			strplain = strplain.substring (0, 4);
			System.out.println ("Ciphertext (left rotation): \t" + strplain);
		
			key = inputKey ();
			String strkey = String.format ("%2s", Integer.toBinaryString (key)).replace (' ', '0');
	    		System.out.println ("Key                       : \t" + strkey);
	    		key1 = strkey.substring (0, 1); // first value of key
	    		key2 = strkey.substring (1); // second value of key
	    		
	    		key1 = key1 + key1 + key1; // K1 = K1K1K1
	    		key2 = key2 + key2 + key2; // K2 = K2K2K2
		
			if (key2 != null) // k2 exists
			{	
				System.out.println ("\n1st round");
				System.out.println ("=========");
				strplain = function (key2, strplain);
				System.out.println ("Ciphertext (1st round)    : \t" + strplain);
			}
		
			if (key1 != null) // k1 exists
			{	
				System.out.println ("\n2nd round");
				System.out.println ("=========");
				strplain = function (key1, strplain);
				System.out.println ("Ciphertext (2nd round)    : \t" + strplain);
			}
		
			System.out.println ("\nSwapping...");
			String left = strplain.substring (0, 2); // A2
			String right = strplain.substring (2, 4); // B2
			String temp;
			temp = left;
			left = right;
			right = temp;
			strplain = left + right;
			System.out.println ("Ciphertext (swapping)       : \t" + strplain);
			
			System.out.println ("\nRotating right...");
			plaintext = Integer.parseInt (strplain, 2);
			plaintext = rightRotate4bit (plaintext);
			strplain = String.format ("%4s", Integer.toBinaryString (plaintext)).replace (' ', '0');
			strplain = strplain.substring (0, 4);
			
			System.out.println ("Plaintext              : \t" + strplain);
			System.out.println ("Plaintext (integer)    : \t" + Integer.parseInt (strplain, 2));
		}
	}
	
	public static String inputCrypt ()
	{
		do
		{
			System.out.print ("\nPlease enter method (encrypt/decrypt) : ");
			method = input.nextLine ();
    		
    		} while ((!method.equalsIgnoreCase ("encrypt")) && (!method.equalsIgnoreCase ("decrypt")));
    		
		return method;
    	}
	
	public static int inputPlaintext ()
	{
		do
		{
			System.out.print ("\nPlease enter a number from 0 to 15 (inclusive): ");
			plaintext = input.nextInt ();
    		
    		} while (plaintext > 15);
    		
		return plaintext;
    	}
    	
    	public static int leftRotate4bit (int m) 
    	{ 
      		String strm = String.format ("%4s", Integer.toBinaryString (m)).replace (' ', '0');
      		String strToRotate = strm.substring (0, 1); // extract the first bit
      		strm = strm.substring (1) + strToRotate; // shift first bit left at the end of previous string
      		
    		return Integer.parseInt (strm, 2);
	} 
	
	public static int rightRotate4bit (int m) 
    	{ 
      		String strm = String.format ("%4s", Integer.toBinaryString (m)).replace (' ', '0');
      		String strToRotate = strm.substring (3); // extract the last bit
      		strm = strToRotate + strm.substring (0, 3); // shift last bit right in front of previous string
      		
    		return Integer.parseInt (strm, 2);
	} 
	
	public static int leftRotate2bit (int m) 
    	{ 
      		String strm = String.format ("%2s", Integer.toBinaryString (m)).replace (' ', '0');
      		
      		switch (strm)
      		{
      			case "00" : strm = "00";
      				    break;
      			case "01" : strm = "10";
      				    break;
      			case "10" : strm = "01";
      				    break;
      			case "11" : strm = "11";
      		}
      		
    		return Integer.parseInt (strm, 2);
	} 
	
	public static int inputKey ()
	{
		int intkey = 0; // default value
		
		do
		{
			// Input a key
			System.out.print ("\nPlease enter a key from 0 to 3 (inclusive): ");
			intkey = input.nextInt ();
    		
    		} while (intkey > 3);
    		
		return intkey;
    	}
    	
    	public static String function (String key, String plaintext)
    	{
    		System.out.println ("f(X, Y) = Z processing...");
		String left = plaintext.substring (0, 2); // A0
		String right = plaintext.substring (2, 4); // B0
		
		System.out.println ("Subkey 1                 : \t" + key);
		System.out.println ("X (2 bits)               : \t" + right);
		System.out.println ("Y (2 bits)               : \t" + key);
		String newright = right.substring (0, 1);
		right += newright;
		System.out.println ("\nX (3 bits)               : \t" + right);
		System.out.println ("Y (3 bits)               : \t" + key);
		
		int x = Integer.parseInt (right, 2);
		int y = Integer.parseInt (key1 ,2);
		int xor = (x ^ y);
		String strxor = String.format ("%3s", Integer.toBinaryString (xor)).replace (' ', '0');
		System.out.println ("X ^ Y                    : \t" + strxor);
		
		System.out.println ("\nProcessing S-Box...");
		String strj1j2 = " ";
		switch (strxor)
		{
			case "000" :	
			case "001" :
			case "010" :	
			case "100" :
			case "101" :	strj1j2 = "00";
					break;
			case "011" :	strj1j2 = "01";
					break;
			case "110" :	strj1j2 = "10";
					break;
			case "111" :	strj1j2 = "11";	
		}
		
		System.out.println ("J1J2                     : \t" + strj1j2);
		int j1j2 = Integer.parseInt (strj1j2, 2); // convert j1j2 into int from string
		j1j2 = leftRotate2bit (j1j2);
		strj1j2 = String.format ("%2s", Integer.toBinaryString (j1j2)).replace (' ', '0');
		System.out.println ("Z (left rotation)        : \t" + strj1j2);
			
		System.out.println ("f(X, Y) = Z completed...");
			
		System.out.println ("\nProcessing for next round...");
		int z = Integer.parseInt (strj1j2, 2); // convert j1j2 to int and store in z
		right = right.substring (0, 2); // extract first 2 bits before expansion
		String newleft = right; // A1 = B0 (before right is updated)
		System.out.println ("Left                     : \t" + newleft);
		int intleft = Integer.parseInt (left, 2);
		int intright = (intleft ^ z); // A0 ^ Z = B1 then convert to string back
		right = String.format ("%2s", Integer.toBinaryString (intright)).replace (' ', '0');
		System.out.println ("Right                    : \t" + right);
		plaintext = newleft + right; // concat both left and right together
		
    		return plaintext;
    	}
}
