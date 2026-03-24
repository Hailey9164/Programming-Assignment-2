/**************************************************************/
/* Hailey Campbell                                            */
/* Login ID: 018392504                                        */
/* CS 3310, Spring 2026                                       */
/* Programming Assignment 2                                   */
/* Prog2 class: main driver for the anagram program           */
/**************************************************************/

import java.io.*;
import java.util.*;

public class Prog2 {

    /**********************************************************/
    /* Method: main                                           */
    /* Purpose: Reads filename, loads words, finds anagrams,  */
    /*           and prints results.                          */
    /* Parameters:                                            */
    /*   String[] args: command-line arguments                */
    /* Returns: none                                          */
    /**********************************************************/
    public static void main(String[] args) {
        // Check for exactly one argument (the filename)
        if (args.length != 1) {
            System.err.println(
                "Usage: java ProgAnagrams <filename>"
            );
            System.exit(1);
        }

        // Get the filename from command-line arguments
        String filename = args[0];  

        // Read words from the file
        WordReader reader = new WordReader();
        // Build anagram groups
        List<String> words = reader.readWords(filename);

        // Find anagram groups
        AnagramFinder finder = new AnagramFinder();
        Map<String, List<String>> groups =
            finder.buildGroups(words);
        // Print the anagram groups
        printGroups(groups, "anagram_groups.txt");
    }

    /**********************************************************/
    /* Method: printGroups                                    */
    /* Purpose: Print all anagram groups of size ≥ 2          */
    /* Parameters:                                            */
    /*   Map<String, List<String>> groups: anagram map        */
    /* Returns: none                                          */
    /**********************************************************/
    private static void printGroups(
        Map<String, List<String>> groups,
        String outputFile
    ) {
        try (PrintWriter out = new PrintWriter(outputFile)) {

            out.println("Detected Anagram Sets:");
            out.println("--------------------------------");

            for (List<String> group : groups.values()) {
                if (group.size() > 1) {
                    out.println(group);
                }
            }
        }

        catch (IOException e) {
        System.err.println(
            "Error writing to file: " + e.getMessage()
        );
        }
    }
}