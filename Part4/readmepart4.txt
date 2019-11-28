// Nur Suhaira Bte Badrul Hisham
// 5841549
// Assignment 1 ReadMe Part 4

Compilation:
============
1. In NurSuhaira_5841549_A1/Part4:
	javac Mdes.java
	javac verifyMdes.java
	javac ecb.java
	javac cbc.java

Before Execution:
=================
1. Make sure all java files stated above are compiled with no error.
2. In command prompt:
	[Mdes.java/verifyMdes.java]
		java Mdes
			a. enter method type (encrypt/decrypt) e.g. encrypt
			b. enter a number from 0 to 15 e.g. 15
			c. enter a key from 0 to 3 e.g. 3
		java verifyMdes
			// display table verification of values when plaintext are encrypted
			// and when ciphertext are decrypted 
			// able to derive which key is used for encryption/decryption
	[ecb.java/cbc.java]
		java ecb 10 ECB encrypt f4a5a32
			// display blocks of cipher being encrypted (in 4 bits each)
			// key, mode, method, hex string
		java ecb 01 ECB decrypt b6f7a11
			// display blocks of cipher being decrypted (in 4 bits each)
			// key, mode, method, hex string
		java cbc 11 CBC a encrypt 2a45def
			// display blocks of cipher being encrypted (in 4 bits each)
			// key, mode, iv, method, hex string
		java cbc 00 CBC 4 decrypt b412ab2
			// display blocks of cipher being decrypted (in 4 bits each)
			// key, mode, iv, method, hex string
	
During Execution:
=================
[Mdes.java]
1. A display message of parameters:
a. Plaintext in binary
b. Plaintext in binary (after left rotation)
c. Key in binary
d. f (x, y) = z
	i. x bit being expanded
	ii. y bit using key 1/key 2
	iii. xor of x and y bits
	v. sbox processing (refer to table in qn)
e. Right replace with left
f. New plaintext generated
g. 2 rounds of f(x, y) = z
h. Swapping of left and right
i. Right rotation (ciphertext)
	i. Display of ciphertext in binary
	ii. Display of ciphertext in integer
** similarly process for decryption except key 2 is used first before key 1
[ecb.java]
** similarly process as Mdes.java (additional a hex string text broken into 4 bits)
[cbc.java]
** similarly process as Mdes.java (additional an iv feed into the first block cipher to xor, then the ciphertext from previous xor with second block cipher etc.)

Execute Environment
===================
Operating system: Ubuntu
Using terminal.
