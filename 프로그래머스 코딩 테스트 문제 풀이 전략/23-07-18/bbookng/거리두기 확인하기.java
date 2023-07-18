import java.util.*;

public class Solution {

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            char[][] place = new char[5][5];
            for (int j = 0; j < 5; j++) {
                place[j] = places[i][j].toCharArray();
            }
            answer[i] = check(place);
        }

        return answer;
    }

    private boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }

    private int check(char[][] place) {
        List<int[]> partitions = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i][j] == 'P') {
                    partitions.add(new int[]{i, j, 0});
                }
            }
        }

        for (int[] partition : partitions) {
            Queue<int[]> q = new LinkedList<>();
            boolean[][] visited = new boolean[5][5];
            q.offer(partition);
            visited[partition[0]][partition[1]] = true;

            while (!q.isEmpty()) {
                int[] current = q.poll();
                int x = current[0];
                int y = current[1];
                int d = current[2];

                for (int[] direction : DIRECTIONS) {
                    int nx = x + direction[0];
                    int ny = y + direction[1];
                    int nd = d + 1;

                    if (isWithinBounds(nx, ny) && !visited[nx][ny]) {
                        if (place[nx][ny] == 'P' && nd <= 2) {
                            return 0;
                        } else if (place[nx][ny] == 'O' && nd == 1) {
                            q.offer(new int[]{nx, ny, nd});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return 1;
    }
}
