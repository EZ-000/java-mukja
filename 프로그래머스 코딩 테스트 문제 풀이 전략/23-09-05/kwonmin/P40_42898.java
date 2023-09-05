import java.util.Arrays;

// 효율성 안되는 코드...
// 왤까
public class SchoolRoad {

	private final int[][] visited = new int[101][101];

	private int dfs(int x, int y, int m, int n, boolean[][] isPuddles){
		if(x == m && y == n) return 1;
		if(visited[x][y] != -1) return visited[x][y];
		visited[x][y] = 0;
		int nx = x + 1;
		int ny = y + 1;

		if (nx <= m && isPuddles[nx][y]){
			visited[x][y] += dfs(nx, y, m, n, isPuddles);
		}
		if (ny <= n && isPuddles[x][ny]){
			visited[x][y] += dfs(x, ny, m, n, isPuddles);
		}

		return visited[x][y] % 1000000007;

	}

	public int solution(int m, int n, int[][] puddles) {
		for (int[] ints : visited) {
			Arrays.fill(ints, -1);
		}
		boolean[][] isPuddle = new boolean[m+1][n+1];
		for (int[] puddle : puddles) {
			isPuddle[puddle[0]][puddle[1]] = false;
		}

		return dfs(1,1,m,n,isPuddle);
	}
}
