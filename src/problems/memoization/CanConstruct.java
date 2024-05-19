package problems.memoization;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a function canConstruct(target, wordBank) that accepts a target string and an array of strings.
 *
 * The function should return a boolean indicating whether or not the target can be constructed by concatenating elements
 * of the wordBank array.
 *
 * You may reuse elements of the wordBank as many times as needed.
 */
public class CanConstruct {


    /**
     * m = target.length
     * n = wordBank.length
     *
     *
     *  Time complexity analysis:
     *  O(n^m) m becomes the height of the tree, n will be if worst case on each level of the tree the branching factor is all the words
     *      * multiply * n on each level
     *
     *   We add an extra M because of the substring because we need to traverse the length of the word to create the substring
     *
     *   O(n^m * m)
     *
     *   Space complexity analysis:
     *   On each stack call we need to slice a new word which will be max length of m and the other m is because at most we will have a callstack of the
     *   length of the target word which is m
     *
     *   m*m
     *
     *   O(m^2)
     *
     * Brute force
     * Time complexity: 0(n^m * m)
     * Space complexity: O(m^2)
     *
     * Memoized:
     * Time complexity: O((n^m) * m) => O(n*m^2)
     * Space complexity: O(m^2)
     *
     */
    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"})); // true
        System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "sk", "boar"})); //false
        System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"})); //true
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{
                "e",
                "ee",
                "eee",
                "eeee",
                "eeeee",
                "eeeeee"
        }));// false
    }

    public static boolean canConstruct(String targetText, String[] options) {
        return canConstruct(targetText, options, new HashMap<>());
    }

    public static boolean canConstruct(String targetText, String[] options, Map<String, Boolean> memo) {
        if (memo.containsKey(targetText)) return memo.get(targetText);
        if (targetText.isEmpty())  return true;

        for (String prefix: options) {
            if (!targetText.startsWith(prefix)) continue;
            String newTarget = targetText.substring(prefix.length());
            boolean canConstruct = canConstruct(newTarget, options, memo);
            memo.put(newTarget, canConstruct);
            if (canConstruct) return true;
        }

        memo.put(targetText, false);
        return false;
    }
}
