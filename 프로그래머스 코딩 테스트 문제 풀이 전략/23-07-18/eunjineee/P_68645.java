//파이썬으로 풀었던 문제
//차이점 : v를 세서 배열 갯수를 정한다는 점
//dd를 구성하고, 배열을 돌리는 과정 자체가 동일했는데 자바로 구성하는 방식이 달라 배울점이 많았음
public class Solution {
    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};

    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int v = 1;
        int x = 0;
        int y = 0;
        int d = 0;

        while (true){
            triangle[x][y] = v++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            //끝부분을 만나면 방향을 수정하고, nx,ny를 다시 지정해주는 과정
            if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[nx][ny] != 0){
                d = (d+1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                // 아래 if는 바뀐 nx,ny를 미리 검사해서 종료시키는 과정
                if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[nx][ny] != 0) break;
            }
            x = nx;
            y = ny;
        }

        // 결과를 한줄로 표현하는 과정
        int[] result = new int[v-1];
        int index = 0;
        for (int i = 0; i < n; i ++){
            for (int j = 0; j <= i; j++){
                result[index++] = triangle[i][j];
            }
        }
        return result;
    }
}
