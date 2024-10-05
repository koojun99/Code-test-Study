import java.util.*;

class Solution {
    // 점을 나타내는 클래스 - x, y 좌표의 한 쌍 = 하나의 점
    private static class Point {
        public final long x, y;
        
        private Point (long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    
    // 교점을 구하는 메서드
    private Point getIntersection (long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1*c2 - b2*c1) / (a1*b2 - a2*b1);
        double y = (double) (a2*c1 - a1*c2) / (a1*b2 - a2*b1);
        
        if (x % 1 != 0 || y % 1 != 0) return null;
        
        return new Point((long) x, (long) y);
    }
    
    // 격자판의 시작점을 정하는 메서드 - 교점들 중 각 끝을 구해야 함(min, max)
    private Point getMinPoint (List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        
        for (Point point : points) {
            if (point.x < x) x = point.x;
            if (point.y < y) y = point.y;
        }
        
        return new Point(x, y);
    }
    
    private Point getMaxPoint (List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        
        for (Point point : points) {
            if (point.x > x) x = point.x;
            if (point.y > y) y = point.y;
        }
        
        return new Point(x, y);
    }
    
    
    public String[] solution(int[][] line) {
        
        //교점들 담을 리스트
        List<Point> points = new ArrayList<>();
        
        //교점들 구하기
        for (int i = 0; i < line.length; i++) {
            for (int j = i+1; j < line.length; j++) {
                Point intersection = getIntersection(line[i][0], line[i][1], line[i][2],
                                                    line[j][0], line[j][1], line[j][2]);
                //교점이 없는 경우를 고려(평행)
                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }
        
        Point maxPoint = getMaxPoint(points);
        Point minPoint = getMinPoint(points);
        
        // 그리드 크기 지정
        int width = (int)(maxPoint.x - minPoint.x + 1);
        int height = (int)(maxPoint.y - minPoint.y + 1);
        
        // 그리드 초기화
        char[][] grid = new char[height][width];
        for (char[] row : grid) {
            Arrays.fill(row, '.');
        }
        
        // 교점에 별 찍기
        for (Point point : points) {
            int x = (int)(point.x - minPoint.x);
            int y = (int)(maxPoint.y - point.y);
            grid[y][x] = '*';
        }
        
        // 그리드를 문자열로 만들기
        String[] answer = new String[grid.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = new String(grid[i]);
        }
        return answer;
    }
}

