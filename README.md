 Hailey Campbell                                            
Login ID: 018392504                                        
CS 3310, Spring 2026                                       
Programming Assignment 2                                   
Description: This program identifies all sets of anagrams within a user‑supplied word list. The input file contains one word per line, and the program processes these words in a case‑insensitive manner while preserving their original spelling and punctuation for output. To efficiently detect anagrams—even in large dictionary files—the program uses a presorting technique: each word is normalized, converted to lowercase, stripped of non‑letter characters for comparison, and then its letters are sorted to produce a canonical “signature.” Words that share the same signature belong to the same anagram group.


1. FILES INCLUDED

Prog2.java
    - main driver for the anagram program
WordReader.java
    - reads words from a file
AnagramFinder.java
    - builds anagram groups
README.txt
    - This file
WRITEUP.txt
    - Question answers


2. COMPILATION INSTRUCTIONS

All  files must be in the same directory.
To compile the program, open a terminal in that directory and run:

javac *.java


3. EXECUTION INSTRUCTIONS

Running the Program
The program requires one command‑line argument:
The name of the file containing the list of words.
Run the program using:

java Prog2 <filename>


Examples
Using a local file:

java ProgAnagrams words.txt


Using a full path:

java ProgAnagrams C:\Users\Hailey\Documents\words.txt


4. INPUT FILE FORMAT
• 	One word per line
• 	Words may contain letters, apostrophes, or other punctuation
• 	Case does not matter
• 	Example:
Elvis
lives
silent
listen
internist's
internists


5. OUTPUT FORMAT
The program prints only sets of two or more words that are true anagrams of each other.
Example output:

Detected Anagram Sets:
[Elvis, lives]
[silent, listen]


Words that differ only by punctuation (e.g.,  vs ) are not treated as anagrams.

6. OUTPUT FILE 
The program writes all detected anagram sets to:

    anagrams_output.txt

This file is created in the same directory where the program is run.


7. NOTES ON IMPLEMENTATION 
• 	Apostrophes and non‑letter characters are removed only for comparison, not for display.
• 	The program uses presorting (sorting the letters of each word) to efficiently detect anagrams.
• 	All non‑main classes hide their internal data and expose behavior only through methods.
• 	Methods are kept short and readable, following assignment style guidelines.
