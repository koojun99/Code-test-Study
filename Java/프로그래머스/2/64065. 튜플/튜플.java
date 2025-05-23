import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<List<Integer>> sets = new ArrayList<>();
        s = s.substring(2, s.length() - 2);
        String[] inputs = s.split("\\},\\{");

        for (String input : inputs) {
            String[] nums = input.split(",");
            List<Integer> set = new ArrayList<>();
            for (String num : nums) {
                set.add(Integer.parseInt(num));
            }
            sets.add(set);
        }

        sets.sort(Comparator.comparingInt(List::size));
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (List<Integer> set : sets) {
            for (int num : set) {
                if (!seen.contains(num)) {
                    result.add(num);
                    seen.add(num);
                    break;
                }
            }
        }

        return result.stream().mapToInt(i -> i).toArray(); // ✅ 수정된 부분
    }
}