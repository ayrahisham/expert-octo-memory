// Nur Suhaira Bte Badrul Hisham
// 5841549
// Assignment 1 Part 4 Qn 5

import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class verifyMdes
{
	static Scanner input = new Scanner (System.in);
	static int plaintext = 0; // default value
	static String key1 = "";
	static String key2 = "";
	static String strkey = "";
	static int key = 0;
	
	public static void main (String [] args)
	{
		System.out.print("\033[H\033[2J");
		
		System.out.println ("[Welcome to Block Cipher Mini DES Verification Table]");
		
		System.out.println ("\nBinary");
		System.out.println ("======");
		System.out.print ("Key\t");
		
		for (int p = 0; p < 16; p++)
		{
			plaintext = p;		
			String strplain = String.format ("%4s", Integer.toBinaryString (plaintext)).replace (' ', '0');
			System.out.print (strplain + " ");
		}	
		
		System.out.println ();
		
		for (int i = 0; i < 4; i++)
		{
			key = i;
			String strkey = String.format ("%2s", Integer.toBinaryString (key)).replace (' ', '0');
			
			key1 = strkey.substring (0, 1); // first value of key
	    		key2 = strkey.substring (1); // second value of key
	    		
	    		key1 = key1 + key1 + key1; // K1 = K1K1K1
	    		key2 = key2 + key2 + key2; // K2 = K2K2K2
	    		System.out.print (strkey + "\t");	
			for (int j = 0; j < 16; j++)
			{
				plaintext = j;		
				String strplain = String.format ("%4s", Integer.toBinaryString (plaintext)).replace (' ', '0');
				
				if ((!strplain.equals ("0000")) && (!strplain.equals ("1111")))
				{
					plaintext = leftRotate4bit (plaintext);
				}
		
				strplain = String.format ("%4s", Integer.toBinaryString (plaintext)).replace (' ', '0');
				strplain = strplain.substring (0, 4);
			
				if (key1 != null) // k1 exists
				{	
					strplain = function (key2, strplain);
				}
		
				if (key2 != null) // k2 exists
				{	
					strplain = function (key1, strplain);
				}
		
				String left = strplain.substring (0, 2); // A2
				String right = strplain.substring (2, 4); // B2
				String temp;
				temp = left;
				left = right;
				right = temp;
				strplain = left + right;
			
				plaintext = Integer.parseInt (strplain, 2);
				plaintext = rightRotate4bit (plaintext);
				strplain = String.format ("%4s", Integer.toBinaryString (plaintext)).replace (' ', '0');
				strplain = strplain.substring (0, 4);
			
				System.out.print (strplain + " ");
			}
				
			System.out.println (); // next row
		}
		
		System.out.println ("\nInteger");
		System.out.println ("=======");
		System.out.print ("Key\t");
		
		for (int p = 0; p < 16; p++)
		{
			plaintext = p;		
			String strplain = String.format ("%4s", Integer.toBinaryString (plaintext)).replace (' ', '0');
			System.out.print (Integer.parseInt (strplain, 2) + " ");
		}	
		
		System.out.println ();
		
		for (int i = 0; i < 4; i++)
		{
			key = i;
			String strkey = String.format ("%2s", Integer.toBinaryString (key)).replace (' ', '0');
			
			key1 = strkey.substring (0, 1); // first value of key
	    		key2 = strkey.substring (1); // second value of key
	    		
	    		key1 = key1 + key1 + key1; // K1 = K1K1K1
	    		key2 = key2 + key2 + key2; // K2 = K2K2K2
	    		System.out.print (Integer.parseInt (strkey, 2) + "\t");	
			for (int j = 0; j < 16; j++)
			{
				plaintext = j;		
				String strplain = String.format ("%4s", Integer.toBinaryString (plaintext)).replace (' ', '0');
				
				if ((!strplain.equals ("0000")) && (!strplain.equals ("1111")))
				{
					plaintext = leftRotate4bit (plaintext);
				}
		
				strplain = String.format ("%4s", Integer.toBinaryString (plaintext)).replace (' ', '0');
				strplain = strplain.substring (0, 4);
			
				if (key1 != null) // k1 exists
				{	
					strplain = function (key2, strplain);
				}
		
				if (key2 != null) // k2 exists
				{	
					strplain = function (key1, strplain);
				}
		
				String left = strplain.substring (0, 2); // A2
				String right = strplain.substring (2, 4); // B2
				String temp;
				temp = left;
				left = right;
				right = temp;
				strplain = left + right;
			
				plaintext = Integer.parseInt (strplain, 2);
				plaintext = rightRotate4bit (plaintext);
				strplain = String.format ("%4s", Integer.toBinaryString (plaintext)).replace (' ', '0');
				strplain = strplain.substring (0, 4);
			
				System.out.print (Integer.parseInt (strplain, 2) + " ");
			}
				
			System.out.println (); // next row
		}
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
	
    	public static String function (String key, String plaintext)
    	{
		String left = plaintext.substring (0, 2); // A0
		String right = plaintext.substring (2, 4); // B0
		
		String newright = right.substring (0, 1);
		right += newright;
		
		int x = Integer.parseInt (right, 2);
		int y = Integer.parseInt (key1 ,2);
		int xor = (x ^ y);
		String strxor = String.format ("%3s", Integer.toBinaryString (xor)).replace (' ', '0');
		
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
			
		int z = Integer.parseInt (strj1j2, 2); // convert j1j2 to int and store in z
		right = right.substring (0, 2); // extract first 2 bits before expansion
		String newleft = right; // A1 = B0 (before right is updated)
		
		int intleft = Integer.parseInt (left, 2);
		int intright = (intleft ^ z); // A0 ^ Z = B1 then convert to string back
		right = String.format ("%2s", Integer.toBinaryString (intright)).replace (' ', '0');
		plaintext = newleft + right; // concat both left and right together
		
    		return plaintext;
    	}
}
