import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] children = new int[N];

        for (int i = 0; i < N; i++) {
            children[i] = sc.nextInt();
        }

        // LIS 길이 계산
        int lisLength = findLISLength(children);

        // 최소로 이동해야 하는 아이들 수
        int minMoves = N - lisLength;
        System.out.println(minMoves);
    }

    private static int findLISLength(int[] arr) {
        ArrayList<Integer> lis = new ArrayList<>();

        for (int num : arr) {
            int pos = lowerBound(lis, num); // num이 들어갈 위치를 찾음
            if (pos == lis.size()) {
                lis.add(num); // 새 요소 추가
            } else {
                lis.set(pos, num); // 기존 요소 대체 (최적화)
            }
        }

        return lis.size();
    }

    private static int lowerBound(ArrayList<Integer> lis, int target) {
        int left = 0, right = lis.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (lis.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}


