import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 문제 1. 교점에 별 만들기 - Level 2
        P1 p1 = new P1();
        int[][] p1t1 = new int[][] {
            {2, -1, 4},
            {-2, -1, 4},
            {0, -1, 1},
            {5, -8, -12},
            {5, 8, 12}
        };
        String[] p1r1 = p1.solution(p1t1);
//        System.out.println(Arrays.toString(p1r1));

        // 문제 2. 삼각 달팽이 - Level 2
        P2 p2 = new P2();
        int[] p2r1 = p2.solution1(4);
//        System.out.println(Arrays.toString(p2r1));

        int[] p2r2 = p2.solution2(4);
//        System.out.println(Arrays.toString(p2r2));

        // 문제 3. 거리두기 확인하기 - Level 2
        P3 p3 = new P3();
        String[][] p3t1 = new String[][] {
            {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
            {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
            {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
            {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        int[] p3r1 = p3.solution(p3t1);
//        System.out.println(Arrays.toString(p3r1));

        // 문제 4. 행렬의 곱셈 - Level 2
        P4 p4 = new P4();
        int[][] arr1 = new int[][] {
            {1, 4},
            {3, 2},
            {4, 1}
        };
        int[][] arr2 = new int[][] {
            {3, 3},
            {3, 3}
        };
        int[][] p4r1 = p4.solution(arr1, arr2);
//        System.out.println(Arrays.deepToString(p4r1));

        // 문제 5. 자연수 뒤집어 배열로 만들기 - Level 1
        P5 p5 = new P5();
        int[] p5r1 = p5.solution1(12345);
//        System.out.println(Arrays.toString(p5r1));
        int[] p5r2 = p5.solution2(12345);
//        System.out.println(Arrays.toString(p5r2));
        int[] p5r3 = p5.solution2(12345);
//        System.out.println(Arrays.toString(p5r3));
    }
}