// Nur Suhaira Bte Badrul Hisham
// 5841549
// Assignment 1 ReadMe Part 3

Compilation:
============
1. In NurSuhaira_5841549_A1/Part3:
	javac Ldes.java
	javac verifyLdes.java

Before Execution:
=================
1. Make sure all java files stated above are compiled with no error.
2. In command prompt:
	[Ldes.java/verifyLdes.java]
		java Ldes
			a. enter method type (encrypt/decrypt) e.g. encrypt
			b. enter a number from 0 to 15 e.g. 15
			c. enter a key from 0 to 3 e.g. 3
		java verifyLdes
			// display table verification of values when plaintext are encrypted
			// and when ciphertext are decrypted 
			// able to derive which key is used for encryption/decryption
			// to generate and form equations for equality (super increasing knapsack)
	
During Execution:
=================
1. A display message of parameters:
a. Plaintext in binary
b. Plaintext in binary (after left rotation)
c. Key in binary
d. f (x, y) = z
	i. x bit being expanded
	ii. y bit using key 1/key 2
	iii. xor of x and y bits
	v. linear processing (e.g. i bit xor 1 = j bit) and left rotation -> z
e. Left xor with z = right
f. Right replace with left
g. New plaintext generated
h. 2 rounds of f(x, y) = z
i. Swapping of left and right
j. Right rotation (ciphertext)
	i. Display of ciphertext in binary
	ii. Display of ciphertext in integer
** similarly process for decryption except key 2 is used first before key 1
	
Execute Environment
===================
Operating system: Ubuntu
Using terminal.
