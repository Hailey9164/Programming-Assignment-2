/**************************************************************/
/* Hailey Campbell                                            */
/* Login ID: 018392504                                        */
/* CS 3310, Spring 2026                                       */
/* Programming Assignment 2                                   */
/* WordReader class: reads words from a file                  */
/**************************************************************/

import java.io.*;
import java.util.*;

public class WordReader {

    /**********************************************************/
    /* Method: readWords                                      */
    /* Purpose: Read all non-empty lines from a file          */
    /* Parameters:                                            */
    /*   String filename: name of file to read                */
    /* Returns: List<String>: list of words                   */
    /**********************************************************/
    public List<String> readWords(String filename) {
        // List to hold the words read from the file
        List<String> words = new ArrayList<>();

        // Use try-with-resources to ensure the file is closed properly
        try (BufferedReader br =
                new BufferedReader(
                    new FileReader(filename)
                )) {
                
            String line;    // Read each line from the file

            // Read lines until the end of the file
            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (!line.isEmpty()) {
                    words.add(line);
                }
            }

        // Handle potential IO exceptions
        } catch (IOException e) {
            System.err.println(
                "Error reading file: " + e.getMessage()
            );
            System.exit(2);
        }

        return words;
    }
}
