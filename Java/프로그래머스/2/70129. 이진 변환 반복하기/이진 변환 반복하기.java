class Solution {
        public int[] solution(String s) {
        int repeat = 0;
        int zeroCount = 0;

        while(!s.equals("1")) {
            int zeros= countZeros(s);
            zeroCount += zeros;
            repeat += 1;
            int ones = s.length() - zeros;
            s = Integer.toString(ones, 2);
        }

        return new int[] {repeat, zeroCount};
    }

    private int countZeros(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                count++;
            }
        }
        return count;
    }
}