// 2차원 배열로 계산을 하고, 1차원 배열로 출력하는 과정이 불필요하진 않은지 고민
// 문제를 어렵다고만 생각했는데, 제한사항이 없어 모든 직선끼리 교점을 구하고, 교점 크기에 따라 결과값을 만들어 주는 과정으로 충분했음
// 쫄지말기~~!

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // x,y를 좌표로 표현해주는 클래스 먼저 작성
    private static class Point {
        public final long x, y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    // 교점 구하는 단순한 코드 (겁먹고 너무 어렵게 생각한듯..! )
    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2){
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 -a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 -a2 * b1);

        if (x % 1 != 0 || y % 1 != 0) return null;

        return new Point((long) x, (long) y);
    }

    private Point getMinimumPoint(List<Point> points){
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point p : points){
            if (p.x < x) x = p.x;
            if (p.y < y) y = p.y;
        }

        return new Point(x, y);
    }
    private Point getMaximumPoint(List<Point> points){
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point p : points){
            if (p.x > x) x = p.x;
            if (p.y > y) y = p.y;
        }

        return new Point(x, y);
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        //모든 직선을 돌면서 정수 값만 넣어서 교점 확인하기
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if (intersection != null) {
                    // 교점 확인되면 points에 저장
                    points.add(intersection);
                }
            }
        }
        //교점들 다 찾고나서, 최대 최소 포인트 찾기
        Point minimum = getMinimumPoint(points);
        Point maximum = getMaximumPoint(points);
        //결과의 너비, 높이를 정해줌
        int width = (int) (maximum.x - minimum.x + 1);
        int height = (int) (maximum.y - minimum.y + 1);

        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        for (Point p : points) {
            int x = (int) (p.x - minimum.x);
            int y = (int) (maximum.y - p.y);9
            arr[y][x] = '*';
        }

        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            //arr[i]를 배열에서 스트링으로 변환해서 출력
            result[i] = new String(arr[i]);
        }
        return result;
    }
}
