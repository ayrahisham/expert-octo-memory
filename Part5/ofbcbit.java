// Nur Suhaira Bte Badrul Hisham
// 5841549
// Assignment 1 Part 5 (Section 3)

import java.util.Scanner;
import java.security.SecureRandom;
import java.util.Arrays;
import java.lang.String;
import java.nio.ByteBuffer;

public class ofbcbit
{
	static Scanner input = new Scanner (System.in);
	final static int BYTE = 8;
	static int BIT = 4;
	final static char padding = '0';
	static long ciphertext = 0L; 
	static long plaintext = 0L;
	static long outputfromtea = 0L;
	static String strplain = "";
	
	public static void main (String [] args)
	{
		System.out.print("\033[H\033[2J");
		
		System.out.println ("Welcome to Output Feedback Mode using TEA algorithm");
		
		plaintext = inputPlaintext ();
		BIT = calCbit ((int) plaintext);
		System.out.println ("BIT: " + BIT);
		long IV = convertToLong (generateParam (BYTE)); // 64 bit or 8 bytes
		int  [] key = byteArr2intArr (generateParam (BYTE*2)); // 128 bit or 16 bytes
		long X;  // outputfromtea ^ plaintext (64 bit)
		long Y; // 4 bit extract storage
		System.out.println ("Implementing " + BIT + "-bit OFB TEA Algorithm");
		
		System.out.println ("\nGenerated completed...");
		System.out.println ("IV                  : \t" + Long.toBinaryString (IV));
		System.out.println ("Key                 : \t" + key);
		String cipher = String.format ("%64s", Long.toBinaryString (ciphertext)).replace (' ', '0');
		System.out.println ("Ciphertext          : \t" + Long.toBinaryString (ciphertext));
		Tea tea = new Tea ();
		
		System.out.println ("\nEncrypting in process...");
		int i = 1; // round index
		
		
		//String plainLength = Long.toString (plaintext);
		int k = BIT;
		while (k <= BYTE*BYTE) //64 bits total (4 bit by 4 bit)
		{
			System.out.println ("\nRound " + i + "...");
			outputfromtea = tea.encrypt (IV, key); // encrypted IV
			
			System.out.println ("Output from tea     : \t" + Long.toBinaryString (outputfromtea));
			strplain = String.format ("%64s", Long.toBinaryString (plaintext)).replace (' ', '0');
			System.out.println ("Plaintext           : \t" + strplain);
			X = outputfromtea ^ plaintext;
			System.out.println ("X                   : \t" + Long.toBinaryString (X));
			//Y = extractSub (X, BIT); 
			//System.out.println ("Y                   : \t" + Long.toBinaryString (Y));
			ciphertext = (ciphertext << BIT) | (X >> 64-BIT); // left shift by 4 bit to make space for 4 new bits on the right by shifting right X by 60 bits
			System.out.println ("Ciphertext          : \t" + Long.toBinaryString (ciphertext));
			plaintext = (plaintext << BIT); // shift left for plain
			strplain = String.format ("%64s", Long.toBinaryString (plaintext)).replace (' ', '0');
			
			if (checkPlaintext (strplain, padding)) // if plaintext is not fully shifted (cleared for encryption)
			{
				System.out.println ("\nEncryption completed...");
				System.out.println ("Rounds             : " + i);
				System.out.println ("Encrypted plaintext: " + ciphertext);
				cipher = String.format ("%64s", Long.toBinaryString (ciphertext)).replace (' ', '0');
				System.out.println ("Encrypted plaintext (in binary): " + cipher);
			}
			else
			{
				System.out.println ("\nPreparing for next round...");	
				System.out.println ("Plaintext (updated) : \t" + strplain);
				IV = (IV << BIT); // shift left for IV
				System.out.println ("IV     (shift left) : \t" + Long.toBinaryString (IV));
				outputfromtea = (outputfromtea >> 64-BIT);
				System.out.println ("K-bit Output        : \t" + Long.toBinaryString (outputfromtea));
				IV = IV | outputfromtea; // updated IV
				System.out.println ("IV        (updated) : \t" + Long.toBinaryString (IV));
			}	
			
			i++;
			k+=BIT;
		}
	}
	
	public static boolean checkPlaintext (String plaintext, char targetValue) 
	{
		for (int s = 0; s < plaintext.length(); s++)
		{
			if (plaintext.charAt (s) != targetValue)
			return false;
		}
		
		return true;
	}
	
	public static long inputPlaintext ()
	{
		int stdno;
		
		System.out.print ("\nKey in student number: ");
		stdno = input.nextInt ();
    		
		return Long.valueOf (stdno);
    	}
    	
    	public static int calCbit (int stdno)
	{
		int sum = 0;
		
		while (stdno > 0)
		{
			sum += stdno % 10; // getting each digit
			stdno /= 10; // discarding last digit
		}
		
		return sum % 8;
    	}
	
	public static byte [] generateParam (int value)
	{
		SecureRandom sr = new SecureRandom ();
		byte [] IV = new byte [value]; 
		sr.nextBytes (IV);
		
		return IV;
	}
	
	public static int[] byteArr2intArr (byte[] src) 
	{
		int dstLength = src.length >>> 2;
		int[]dst = new int [dstLength];
		
		for (int i=0; i<dstLength; i++) 
		{
		    int j = i << 2;
		    int x = 0;
		    x += (src[j++] & 0xff) << 0;
		    x += (src[j++] & 0xff) << 8;
		    x += (src[j++] & 0xff) << 16;
		    x += (src[j++] & 0xff) << 24;
		    dst[i] = x;
		}
		
		return dst;
    	}
    	
    	public static long convertToLong (byte[] array) 
    	{
    		ByteBuffer buffer = ByteBuffer.wrap(array);
    		return buffer.getLong();

  	}
	
	public static long extractSub (long l, int nrBits)
	{
		long rightShifted = l >>> 0;
    		long mask = (1L << nrBits) - 1L;
    		
    		return rightShifted & mask;
	}
}
