import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, Boolean> records = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String employee = sc.next();
            String command = sc.next();

            if (command.equals("enter")) {
                records.put(employee, true);
            } else { // leave
                records.put(employee, false);
            }
        }

        // 현재 회사에 남아 있는 직원만 추출
        List<String> remain = new ArrayList<>();
        for (String emp : records.keySet()) {
            if (records.get(emp)) {
                remain.add(emp);
            }
        }

        // 내림차순 정렬
        remain.sort(Collections.reverseOrder());

        // 출력
        for (String emp : remain) {
            System.out.println(emp);
        }
    }
}