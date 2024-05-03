package problems.memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Write a function that takes in a targetSum and an array of numbers as arguments
 * <p>
 * The function should return an array containing the shortest combination
 * of numbers that add up to exactly the targetSum
 * <p>
 * If there is a tie on the shortest sum combination, you may return any one of the
 * shortest.
 */
public class BestSum {

    /**
     * Brute force
     * Time complexity = O(n^m * m) -------- "* m" is because of the copy of the array
     * Space complexity = O(m^2) since every recursive call needs it's own bestAnswer array
     * <p>
     * Memoized:
     * Time complexity:  (m * n * m) extra *m is because of the copy over of the array to compare best answers
     * Space complexity: (m^2)
     */
    public static void main(String[] args) {
        System.out.println(bestSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(bestSum(8, new int[]{2, 3, 5}));
        System.out.println(bestSum(9, new int[]{1, 4, 5}));
        System.out.println(bestSum(100, new int[]{1, 2, 5, 25}));
    }

    private static List<Integer> bestSum(int targetSum, int[] numbers) {
        return bestSum(targetSum, numbers, new HashMap<>());
    }

    private static List<Integer> bestSum(int targetSum, int[] numbers, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum < 0) return null;
        if (targetSum == 0) return new ArrayList<>();

        List<Integer> bestAnswer = null;
        for (int number : numbers) {
            int remainder = targetSum - number;
            List<Integer> remainderResult = bestSum(remainder, numbers, memo);

            if (remainderResult != null) {
                List<Integer> newCombination = new ArrayList<>(remainderResult);
                newCombination.add(number);
                if (bestAnswer == null || newCombination.size() < bestAnswer.size()) {
                    bestAnswer = newCombination;
                }
            }

        }

        memo.put(targetSum, bestAnswer);
        return bestAnswer;
    }


}
