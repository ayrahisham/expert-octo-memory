// Nur Suhaira Bte Badrul Hisham
// 5841549
// Assignment 1 Part 3 Qn 3

import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class verifyLdes
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
		
		System.out.println ("[Welcome to Block Cipher Linear DES Verification Table]");
		
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
		
		System.out.println ("\nEquations in terms of E(0000), E(1000), E(0100), E(0010), E(0001)");
		System.out.println ("===================================================================");
		
		System.out.println ("Items to put in knapsack: ");
		String [] para = new String [5];
		para [0] = "0000"; // 0
		para [1] = "1000"; // 8
		para [2] = "0100"; // 4
		para [3] = "0010"; // 2
		para [4] = "0001"; // 1
		for (int w = 0; w < 5; w++)
		{
			System.out.print (para[w] + "\t");
		}
		
		System.out.println ("\n");
		String [] values = new String [10];
		values [0] = "1010"; // 10
		values [1] = "1001"; // 9
		values [2] = "0110"; // 6
		values [3] = "0101"; // 5
		values [4] = "0011"; // 3
		values [5] = "0111"; // 7
		values [6] = "1011"; // 11
		values [7] = "1101"; // 13
		values [8] = "1110"; // 14
		values [9] = "1111"; // 15
		
		int value, sum, size = 3;
		String [] temp; 
		boolean ok;
		for (int i = 0; i < 9; i++) // cater for size = 3
		{
			value = Integer.parseInt (values [i], 2); // verify for each value
			System.out.println ("Total Weight of Knapsack: " + values [i]);
			
			temp = new String [size]; // all other values except last one need 3 para
			
			for (int j = 0; j < 5; j++)
			{
				sum = 0;
				sum += Integer.parseInt (para [j], 2); // since first value of para is always 0
				temp [0] = para [j];
				System.out.println ("Putting in knapsack: " + para[j]);
				for (int k = 1; k < 5; k++)
				{
					do
					{
						ok = true;
					 	if ((sum + Integer.parseInt (para [k], 2)) > value)
						{
							k += 1; // move on to next value
							ok = false;
						}
						if (sum > value)
						{
							sum -= Integer.parseInt (para [j], 2);
							System.out.println ("Taking out from knapsack: " + para[j] + "\n");
							break;
						}
					
					} while (ok == false);
					
					if (k < 4)
					{
						sum += Integer.parseInt (para [k], 2);
						temp [1] = para [k];
						System.out.println ("Putting in knapsack: " + para[k]);
					}
					
					for (int m = k+1; m < 5; m++)
					{
						if ((sum + Integer.parseInt (para [m], 2)) == value)
						{
							sum += Integer.parseInt (para [m], 2); // found 3 para that holds equality to value
							temp [2] = para [m];
							System.out.println ("Putting in knapsack: " + para[m]);
							break;
						}
						
						if ((m == 4) && (sum < value)) // if check last para < value, try another combination
						{
							sum -= Integer.parseInt (para [k], 2);
							System.out.println ("Taking out from knapsack: " + para[k] + "\n");
							break;
						}
						
					}
					
					if (sum == value)
					{
						break;
					}
					
					if ((k == 4) && (sum < value)) // if check last para < value, try another combination
					{
						sum -= Integer.parseInt (para [j], 2);
						System.out.println ("Taking out from knapsack: " + temp[0] + "\n");
						break;
					 }
				}
				
				if (sum == value)
				{
					break;
				}
			}
			
			System.out.println (i+1 + "->\tE(" + values [i] + ") = E(" + temp[0] + ") + E(" + temp[1] + ") + E(" + temp[2] + ")");
			System.out.println ("/////////////////////////////////////////////////////////////////////////////////\n");
		}
		
		size = 4;
		value = Integer.parseInt (values [9], 2); // for last value
		temp = new String [size]; // all other values except last one need 3 para
		System.out.println ("Total Weight of Knapsack: " + values [9]);
		for (int j = 0; j < 5; j++)
		{
			sum = 0;
			sum += Integer.parseInt (para [j], 2); // since first value of para is always 0
			temp [0] = para [j];
			System.out.println ("Putting in knapsack: " + para[j]);
			for (int k = 1; k < 5; k++)
			{
				if ((sum + Integer.parseInt (para [k], 2)) > value)
				{
					k += 1; // move on to next value
				
				}
				
				if (sum > value)
				{
					sum -= Integer.parseInt (para [j], 2);
					System.out.println ("Taking out from knapsack: " + para[j] + "\n");
					break;
				}	
					
				if (k < 4)
				{
					sum += Integer.parseInt (para [k], 2);
					temp [1] = para [k];
					System.out.println ("Putting in knapsack: " + para[k]);
				}
					
				for (int m = k+1; m < 5; m++)
				{
					if ((sum + Integer.parseInt (para [m], 2)) > value)
					{
						m += 1; // move on to next value
					}
					if (sum > value)
					{
						sum -= Integer.parseInt (para [k], 2);
						System.out.println ("Taking out from knapsack: " + para[k] + "\n");
						break;
					}	
				
					if (m < 4)
					{
						sum += Integer.parseInt (para [m], 2); // found 3 para that holds equality to value
						temp [2] = para [m];
						System.out.println ("Putting in knapsack: " + para[m]);
						break;
					}
						
					for (int n = m+1; n < 5; n++)
					{
						if ((sum + Integer.parseInt (para [n], 2)) == value)
						{
							sum += Integer.parseInt (para [n], 2); // found 4 para that holds equality to value
							temp [3] = para [n];
							System.out.println ("Putting in knapsack: " + para[n]);
							break;
						}
								
						if ((n == 4) && (sum < value)) // if check last para < value, try another combination
						{
							sum -= Integer.parseInt (para [m], 2);
							System.out.println ("Taking out from knapsack: " + para[m] + "\n");
							break;
						}
					}
					
					if (sum == value)
					{
						break;
					}
				}
					
				if ((k == 4) && (sum < value)) // if check last para < value, try another combination
				{
					sum -= Integer.parseInt (para [j], 2);
					System.out.println ("Taking out from knapsack: " + temp[0] + "\n");
					break;
				}
				
				if (sum == value)
				{
					break;
				}
			}
			
			if (sum == value)
			{
				break;
			}
		}
			
		System.out.println ("10 ->\tE(" + values [9] + ") = E(" + temp[0] + ") + E(" + temp[1] + ") + E(" + temp[2] + ") + E(" + 1000 + ")\n");
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
		
		String stri2 = strxor.substring (1, 2); // extract middle value for i2 of xor
		String stri3 = strxor.substring (2); // extract last value for i3 of xor
		int i2 = Integer.parseInt (stri2, 2);
		int j1 = (i2 ^ 1);
		int i3 = Integer.parseInt (stri3 ,2);
		int j2 = (i3 ^ 1);
		String strj1j2 = Integer.toBinaryString (j1) + Integer.toBinaryString (j2);
		int j1j2 = Integer.parseInt (strj1j2, 2); // convert j1j2 into int from string
		j1j2 = leftRotate2bit (j1j2);
		strj1j2 = String.format ("%2s", Integer.toBinaryString (j1j2)).replace (' ', '0');
			
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
