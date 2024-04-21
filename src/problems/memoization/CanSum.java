package problems.memoization;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a function `canSum(targetSum, numbers)` that takes in a targetSum
 * and an array of numbers as arguments.
 * <p>
 * The function should return a boolean indicating whether or not it is possible
 * to generate the targetSum using the numbers from the array.
 * <p>
 * You may use an element of the array as manu times as needed
 * <p>
 * you may assume that all input numbers are nonnegative
 */
public class CanSum {
    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{2, 3})); //true
        System.out.println(canSum(7, new int[]{5, 3, 4, 7})); //true
        System.out.println(canSum(7, new int[]{2, 4})); //false
        System.out.println(canSum(7, new int[]{2, 3, 5})); //true
        System.out.println(canSum(300, new int[]{7, 14})); //true
    }

    public static boolean canSum(int targetSum, int[] numbers) {
        return canSum(targetSum, numbers, new HashMap<>());
    }

    public static boolean canSum(int targetSum, int[] numbers, Map<Integer, Boolean> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;

        for (int number : numbers) {
            int remainder = targetSum - number;

            boolean branchResult = canSum(remainder, numbers, memo);
            memo.put(remainder, branchResult);
            if (branchResult) return true;

        }
        //We want to return false here since by this point we already tried all possibilities
        memo.put(targetSum, false);
        return false;
    }
}
