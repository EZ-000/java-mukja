import java.util.ArrayList;
import java.util.List;

public class P16  {
    private List<int[]> hanoi1(int n, int from, int to) {
        if (n == 1) return List.of(new int[] {from, to});

        int empty = 6 - from - to;

        List<int[]> result = new ArrayList<>();
        result.addAll(hanoi1(n - 1, from, empty));
        result.addAll(hanoi1(1, from, to));
        result.addAll(hanoi1(n - 1, empty, to));
        return result;
    }

    public int[][] solution1(int n) {
        return hanoi1(n, 1, 3).toArray(new int[0][]);
    }

    private void hanoi2(int n, int from, int to, List<int[]> process) {
        if (n == 1) {
            process.add(new int[] {from, to});
            return;
        }

        int empty = 6 - from - to;

        hanoi2(n - 1, from, empty, process);
        hanoi2(1, from, to, process);
        hanoi2(n - 1, empty, to, process);
    }

    private int[][] solution2(int n) {
        List<int[]> process = new ArrayList<>();
        hanoi2(n, 1, 3, process);
        return process.toArray(new int[0][]);
    }
}
