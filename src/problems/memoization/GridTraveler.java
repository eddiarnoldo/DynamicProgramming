package problems.memoization;

import java.util.HashMap;
import java.util.Map;

/**
 * You're a traveler on a 2D grid. You begin in the top left corner
 * and your goal is to travel to the bottom-right corner.
 *
 * You may only move down or right
 *
 * In how many ways can you travel to the goal on a grid with dimensions
 * m * n ?
 */

public class GridTraveler {
    public static void main(String[] args) {
        System.out.println(gridTraveler(1,1)); //1
        System.out.println(gridTraveler(2,3)); //3
        System.out.println(gridTraveler(3,2)); //3
        System.out.println(gridTraveler(3,3)); //6
        System.out.println(gridTraveler(18,18)); // 2333606220
    }

    public static int gridTraveler(int m, int n) {
        return gridTraveler(m, n, new HashMap<>());
    }

    public static int gridTraveler(int m, int n, Map<String, Integer> memo) {
        String key = m + "," + n;
        String altKey = n + "," + m;
        if (memo.containsKey(key)) return memo.get(key);
        if (memo.containsKey(altKey)) return memo.get(altKey); //I think this is needed.
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        memo.put(key, gridTraveler(m -1, n, memo) + gridTraveler(m, n-1, memo));
        return memo.get(key);
    }
}
