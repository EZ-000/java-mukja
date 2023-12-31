package Programmers;

import java.util.HashSet;

public class Solution33 {
    public double getSlope(int x1, int x2, int y1, int y2) {
        return (double) (y2 - y1) / (x2 - x1);
    }
    public int solution(int[][] dots) {
        HashSet<Double> set = new HashSet<>();

        for (int i = 0; i < dots.length; i++) {
            for (int j = i+1; j < dots.length; j++) {
                double slope = getSlope(dots[i][0], dots[j][0], dots[i][1], dots[j][1]);
                if (set.contains(slope)) return 1;
                set.add(slope);
            }
        }

        return 0;
    }
}
