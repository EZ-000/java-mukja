import java.util.Arrays;

public class SchoolRoad {
	private int[][] visited;
	private final int DIVIDE = 1000000007;

	private int dfs(int x, int y, int m, int n, boolean[][] isPuddles){
		if(x > m || y > n || isPuddles[x][y]) return 0;
		if(x == m && y == n) return 1;
		if(visited[x][y] != -1) return visited[x][y];

		return visited[x][y] = (dfs(x+1, y, m, n, isPuddles) + dfs(x, y+1, m, n, isPuddles)) % DIVIDE;

	}

	public int solution(int m, int n, int[][] puddles) {
		visited = new int[m+1][n+1];
		for (int[] ints : visited) {
			Arrays.fill(ints, -1);
		}
		boolean[][] isPuddle = new boolean[m+1][n+1];
		for (int[] puddle : puddles) {
			isPuddle[puddle[0]][puddle[1]] = true;
		}

		return dfs(1,1,m,n,isPuddle);
	}
}