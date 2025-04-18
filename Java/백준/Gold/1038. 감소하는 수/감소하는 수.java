import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long answer = 0;
        List<Long> descendingNums = new ArrayList<>();
        descendingNums.add(0L);
        getDescendingNum(descendingNums,0L, 10);

        Collections.sort(descendingNums);
        if (n < descendingNums.size()) {
            System.out.println(descendingNums.get(n));
        } else {
            System.out.println(-1);
        }
    }

    private static void getDescendingNum(List<Long> list, long num, int lastDigit) {
        // 빈 num=0도 “0” 하나로 치고 싶으면 여기서 추가
        if (num != 0) list.add(num);
        // 앞으로 붙일 숫자는 [0..lastDigit-1]
        for (int d = 0; d < lastDigit; d++) {
            getDescendingNum(list, num*10 + d, d);
        }
    }
}
