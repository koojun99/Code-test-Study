import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Room>> rooms = new ArrayList<>();
        long answer = 0;

        for (int i = 0; i <= n; i++) {
            rooms.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long dist = sc.nextLong();

            rooms.get(a).add(new Room(b, dist));
            rooms.get(b).add(new Room(a, dist));
        }

        answer = bfs(rooms, 1);

        System.out.println(answer);
    }

    static class Room {
        int to;
        long dist;

        Room (int to, long dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    private static long bfs(List<List<Room>> rooms, int start) {
        long maxDist = 0;
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        long[] dist = new long[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for (Room room : rooms.get(curr)) {
                if (!visited[room.to]) {
                    visited[room.to] = true;
                    dist[room.to] = dist[curr] + room.dist;
                    queue.offer(room.to);
                }
            }
        }

        for (long d : dist) {
            maxDist = Math.max(maxDist, d);
        }
        return maxDist;
    }
}