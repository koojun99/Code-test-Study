import java.util.*;

class Solution {
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void getPrimes(int number, int[] numbers, boolean[] isUsed, Set<Integer> primes) {
        if (isPrime(number)) {
            primes.add(number);
        }

        for (int i = 0; i < numbers.length; i++) {
            if (isUsed[i]) continue;

            int nextNumber = number * 10 + numbers[i];

            isUsed[i] = true;
            getPrimes(nextNumber, numbers, isUsed, primes);
            isUsed[i] = false;
        }
    }
    public int solution(String nums) {
        Set<Integer> primes = new HashSet<>();
        int[] numbers = nums.chars().map(c -> c - '0').toArray();
        getPrimes(0, numbers, new boolean[numbers.length], primes);
        return primes.size();
    }
}