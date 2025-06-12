import java.util.*;

public class Main {
    static class Lecture {
        int start;
        int end;
        Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Lecture[] lectures = new Lecture[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            lectures[i] = new Lecture(start, end);
        }

        Arrays.sort(lectures, Comparator.comparing(lecture -> lecture.start));

        pq.offer(lectures[0].end);

        for (int i = 1; i < n; i++) {
            if (lectures[i].start >= pq.peek()) {
                pq.poll();
            }

            pq.offer(lectures[i].end);

        }

        System.out.println(pq.size());
    }
}