package PGS_BOOK.CH05;

// 코드를 다 이해하고 나서야 문제를 이해했다
// 결과 값을 뭘 원하는지 왜 말 안해주는거야~~
// n == 1에서 끝날 수 있는 이유가 from, to만 원하기 때문
// 재귀는 어려워~!~!


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_16_12946 {
    private static  List<int[]> hanoi(int n, int from, int to){
        if (n == 1){
            return Arrays.asList(new int[]{from, to});
        }

        int empty = 6 - from - to;

        List<int[]> result = new ArrayList<>();
        result.addAll(hanoi(n-1, from, empty));
        result.addAll(hanoi(1, from, to));
        result.addAll(hanoi(n-1, empty, to));
        return result;
    }

    public static int[][] book_solution(int i){
        return hanoi(i,1, 3).toArray(new int[0][]);
    }

    // list를 함께 가지고 다니는 방법
    private static void hanoi2(int n, int from, int to, List<int[]> process){
        if (n == 1){
            process.add(new int[] {from, to});
            return;
        }

        int empty = 6 - from - to;

        hanoi2(n-1, from, empty, process);
        hanoi2(1, from, to, process);
        hanoi2(n-1, empty, to, process);
    }

    public static int[][] book_solution2(int n){
        List<int[]> process2 = new ArrayList<>();
        hanoi2(n, 1, 3, process2);
        return process2.toArray(new int[0][]);
    }


    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(book_solution(2)));
        System.out.println(Arrays.deepToString(book_solution2(2)));
    }
}
