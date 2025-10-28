import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] sorted = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sorted[i] = nums[i];
        }

        // 중복 제거 및 정렬
        Set<Integer> set = new HashSet<>();
        for (int num : sorted) {
            set.add(num);
        }

        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);

        // 값 → 압축값 매핑
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sortedList.size(); i++) {
            map.put(sortedList.get(i), i);
        }

        // 결과 출력 (입력 순서 유지)
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(map.get(num)).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}