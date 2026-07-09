package leetcode.T49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * Example 1:
 * <p>
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * <p>
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * Explanation:
 * <p>
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 * Example 2:
 * <p>
 * Input: strs = [""]
 * <p>
 * Output: [[""]]
 * <p>
 * Example 3:
 * <p>
 * Input: strs = ["a"]
 * <p>
 * Output: [["a"]]
 */
public class AnagramGroup {
    public List<List<String>> groupAnagram(final String[] str) {
        HashMap<String, List<String>> anagram = new HashMap<>();

        for (final String word : str) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            final String key = String.valueOf(chars);

            if (!anagram.containsKey(key)) {
                anagram.put(key, new ArrayList<>());
            }

            anagram.get(key).add(word);
        }
        return new ArrayList<>(anagram.values());
    }
}
