package problems.memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a function that takes in a targetSum and an array of numbers as arguments.
 * <p>
 * The function should return an array containing any combination of elements that add
 * up to exactly the targetSum. If there is no combination that adds up to the targetSum,
 * then return null.
 * <p>
 * If there are multiple combinations possible, you may return any single one.
 */
public class HowSum {
    /**
     * Brute force
     * Time complexity = O(n^m * m) -------- "* m" is because of the copy of the array
     * Space complexity = O(m)
     * <p>
     * Memoized:
     * Time complexity: O(n*m*m) --- O(n*m^2)
     * Space complexity = O(m*m) --- O(m^2)  because of the memo, at most we will have a key for each 1 producing target sum and an array of max length m
     */

    public static void main(String[] args) {
        System.out.println(howSum(7, new int[]{2, 3}));
        System.out.println(howSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(howSum(7, new int[]{2, 4}));
        System.out.println(howSum(8, new int[]{2, 3, 5}));
        System.out.println(howSum(3000, new int[]{7, 14}));

    }


    public static List<Integer> howSum(int targetSum, int[] numbers) {
        return howSum(targetSum, numbers, new HashMap<>());
    }

    public static List<Integer> howSum(int targetSum, int[] numbers, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        for (int number : numbers) {
            int remainder = targetSum - number;
            List<Integer> remainderResult = howSum(remainder, numbers, memo);
            if (remainderResult != null) {
                //Need to copy the just added number into the array to return the response;
                //if we hit base case this is [] so we return that plus the number we used e.g [] + [2]
                remainderResult.add(number);
                memo.put(targetSum, remainderResult);

                return remainderResult;
            }
        }
        //If we get here we just return null;
        memo.put(targetSum, null);
        return null;
    }
}
