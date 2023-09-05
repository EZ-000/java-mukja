import java.util.Arrays;

// 위에서 내려가는 게 아니라, 아래서 올라오는 방식
// 맨 아래에서 비교하면서 올라오기 때문에, 결국 [0][0]에 최대값이 들어오게 된다.

public class IntTriangle {

	private final int[][] visited = new int[501][501];  // 최대 크기로 초기화

	private int dp(int x, int y, int[][] triangle){
		if (y == triangle.length) return 0; // 마지막 초과할 시 0 리턴
		if (visited[x][y] != -1) return visited[x][y];

		return visited[x][y] = triangle[x][y] + Math.max(dp(x+1, y, triangle), dp(x+1, y+1, triangle));

	}

	public int solution(int[][] triangle) {
		for (int[] ints : visited) {
			Arrays.fill(ints, -1);
		}
		return dp(0,0,triangle);
	}
}
