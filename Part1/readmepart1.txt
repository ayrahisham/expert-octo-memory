// Nur Suhaira Bte Badrul Hisham
// 5841549
// Assignment 1 ReadMe Part 1

Compilation:
============
1. In NurSuhaira_5841549_A1/Part1:
	javac myProgram.java 
	// to compile myProgram.java to generate myProgram.class

Before Execution:
=================
1. Make sure myProgram.java is compiled with no error.
2. In command prompt:
	java myProgram
	
During Execution:
=================
A main menu is display:
For menu option:
1. Create a new file: 
	a. Type a new text file name e.g. test.txt
	b. Type in content for the text file and press enter to end e.g. Hello World <enter>
	c. A successful display message will be prompted along with a submenu for processing
	of textfile. Current filename will be displayed for reference.
	d. Enter option 1 to enter secret key (a, b) e.g. (3, 9)
	e. Enter option 2 to encrypt current file e.g. test.txt
		i. Program will prompt if user would like to change file else enter 'n' or 'N'
		ii. Enter an output file to store encrypted version of current file e.g. test2.txt
		iii. Program will prompt if user would like to change secret key else enter 'n' or 'N'
		iv. Once enter, console will display content before and after encryption and output file will be generated.
		v. Check that test2.txt in the same current folder has the same encrypted content 
		generated as the displayed console	
	f. Submenu will be displayed again so enter option 3 to decrypt the encrypted file e.g test2.txt that was created
		i. Program will prompt if user would like to change file, enter 'y' or 'Y' 
		and enter the encrypted filename e.g. test2.txt (make sure program check for file entered is OK)
		ii. Enter an output file to store decrypted version of current file e.g. test3.txt
		iii. Program will prompt if user would like to change secret key else enter 'n' or 'N'
		(make sure secret key used is the same as when file was previously encrypted)
		iv. Once enter, console will display content before and after decryption and output file will be generated.
		v. Check that test3.txt in the same current folder has the same encrypted content generated as the displayed
		vi. Now check that the content in test3.txt is the same as the original test.txt
	g. User can choose to enter option 4 to print content of file (make sure filename is entered correctly)
	h. Quit program once done by entering option 5.

Execute Environment
===================
Operating system: Ubuntu
Using terminal.
