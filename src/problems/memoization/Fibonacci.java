package problems.memoization;

import java.util.HashMap;
import java.util.Map;

/*
    Write a function `fib(n)` that takes in a number as an argument.
    The function should return the n-th number of the Fibonacci sequence
            1, 2, 3, 4, 5, 6, 7,  8,  9
    fib(n): 1, 1, 2, 3, 5, 8, 13, 21, 34, . .
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(6));
        System.out.println(fib(7));
        System.out.println(fib(8));
        System.out.println(fib(50));
    }

    public static int fib(int n) {
        return fib(n, new HashMap<>());
    }

    //Recursive
    public static int fib(int n, Map<Integer, Integer> memo) {
        //Check for existence in memo
        if (memo.containsKey(n)) return memo.get(n);
        if (n <= 2) return 1;
        //Store new calculated value in memo for future queries
        memo.put(n, fib(n - 1, memo) + fib(n - 2, memo));
        return memo.get(n);
    }


}
