package problems.memoization;
//Todo add explanation

import java.util.HashMap;
/**
 * BruteForce 
 * O(n^m * m) time
 * O(m^2) space
 * 
 * Memoized
 * O(n * m ^ 2) time
 * O(m^2) space
 */

public class CountConstruct {
    public static void main(String[] args) {
        System.out.println(countConstruct("purple", new String[] { "purp", "p", "ur", "le", "purpl" }));
        System.out.println(countConstruct("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" }));
        System.out.println(countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "sk", "boar"}));
        System.out.println(countConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"})); 
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{
                "e",
                "ee",
                "eee",
                "eeee",
                "eeeee",
                "eeeeee"
        }));
    }

    private static int countConstruct(String target, String[] options) {
        return countConstruct(target, options, new HashMap<>());
    }

    private static int countConstruct(String target, String[] options, HashMap<String, Integer> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target.equals("")) return 1;

        int result = 0;
        for (String prefix : options) {
            // Continue if target does not start with prefix
            if (!target.startsWith(prefix))
                continue;

            String newTarget = target.substring(prefix.length());
            int newTargetResult = countConstruct(newTarget, options, memo);
            result += newTargetResult;
            memo.put(newTarget, newTargetResult);
        }

        memo.put(target, result);
        return memo.get(target);
    }
}
