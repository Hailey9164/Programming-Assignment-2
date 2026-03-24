/**************************************************************/
/* Hailey Campbell                                            */
/* Login ID: 018392504                                        */
/* CS 3310, Spring 2026                                       */
/* Programming Assignment 2                                   */
/* AnagramFinder class: builds anagram groups                 */
/**************************************************************/

import java.util.*;

public class AnagramFinder {

    /**********************************************************/
    /* Method: buildGroups                                    */
    /* Purpose: Group words by sorted-letter signature        */
    /* Parameters:                                            */
    /*   List<String> words: list of input words              */
    /* Returns: Map<String, List<String>>: anagram groups     */
    /**********************************************************/
    public Map<String, List<String>> buildGroups(
        List<String> words
    ) {
        // Map to hold sorted-letter keys and corresponding anagram lists
        Map<String, List<String>> map = new HashMap<>();

        for (String original : words) {
            String normalized = normalize(original);
            String key = sortedLetters(normalized);

            // Create group if needed
            map.computeIfAbsent(key, k -> new ArrayList<>());

            // Only add if this normalized form is not already present
            boolean duplicate = false;
            for (String existing : map.get(key)) {
                if (normalize(existing).equals(normalized)) {
                    duplicate = true;
                    break;
                }
            }

            // Add original word to the group if it's not a duplicate
            if (!duplicate) {
                map.get(key).add(original);
            }
        }
        return map;
    }

    /**********************************************************/
    /* Method: sortedLetters                                  */
    /* Purpose: Return sorted characters of a word            */
    /* Parameters:                                            */
    /*   String word: word to sort                            */
    /* Returns: String: sorted version                        */
    /**********************************************************/
    private String sortedLetters(String word) {
        // Convert the word to a character array, sort it, and return the sorted string
        char[] arr = word.toCharArray();    //store the characters of the word in an array
        Arrays.sort(arr);
        return new String(arr);
    }

    /**********************************************************/
    /* Method: normalize                                      */
    /* Purpose: Remove non-letter characters and lowercase    */
    /* Parameters:                                            */
    /*   String word: word to normalize                       */    
    /* Returns: String: normalized version                    */
    /**********************************************************/
    private String normalize(String word) {
        // StringBuilder to build the normalized version of the word
        StringBuilder sb = new StringBuilder();

        // Iterate through characters, keeping only letters
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(c);
            }
        }

        // Convert to lowercase and return the normalized string
        return sb.toString().toLowerCase();
    }
}
