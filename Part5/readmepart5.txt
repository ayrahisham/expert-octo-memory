// Nur Suhaira Bte Badrul Hisham
// 5841549
// Assignment 1 ReadMe Part 5

Compilation:
============
1. In NurSuhaira_5841549_A1/Part5:
	javac Tea.java
	javac ofb4bit.java
	javac ofbcbit.java 

Before Execution:
=================
1. Make sure all java files stated above are compiled with no error.
2. In command prompt:
	[ofb4bit.java/ofbcbit.java]
		java ofb4bit
			e.g. enter student number: 5841549
		java ofbcbit
			e.g. enter student number: 5841548 (different due to mod 8 being 4 for my own student number)
			// different student number to show different time needed for encryption
	
During Execution:
=================
1. A display message of parameters:
a. IV generated (64 bit)
b. Key generated (128 bit)
c. Empty ciphertext
d. Output from TEA algorithm (64 bit)
e. Plaintext padded to 64 bit
f. Value of X (64 bit) // Output from TEA XOR Plaintext
g. Ciphertext with every new Y value (first 4 bits of X) // added to the right of ciphertext in every cycle
h. Parameters prepared before next cycle:
	i. Updated IV
	ii. Updated plaintext
	iii. Updated output from TEA
i. Once cycle completed // plaintext becomes all '0':
	i. No. of rounds shown
	ii. Encrypted plaintext displayed in (long) and in (binary)
	
Execute Environment
===================
Operating system: Ubuntu
Using terminal.
