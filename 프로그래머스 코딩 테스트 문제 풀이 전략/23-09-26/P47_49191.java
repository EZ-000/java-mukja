import java.util.ArrayDeque;
import java.util.Deque;

public class Ranking {

	private int win_bfs(int x, boolean[][] nodes){
		boolean[] visited = new boolean[nodes.length];
		Deque<Integer> que = new ArrayDeque<>();
		que.add(x);
		visited[x] = true;
		int cnt = 0;
		while(!que.isEmpty()){
			int a = que.pollFirst();
			for (int i = 1; i < nodes.length; i++) {
				if(nodes[a][i] && !visited[i]){
					que.add(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
		System.out.println("cnt = " + cnt);

		return cnt;
	}

	private int lose_bfs(int x, boolean[][] nodes){
		boolean[] visited = new boolean[nodes.length];
		Deque<Integer> que = new ArrayDeque<>();
		que.add(x);
		visited[x] = true;
		int cnt = 0;
		while(!que.isEmpty()){
			int a = que.pollFirst();
			for (int i = 1; i < nodes.length; i++) {
				if(nodes[a][i] && !visited[i]){
					que.add(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
		System.out.println("cnt = " + cnt);

		return cnt;
	}

	public int solution(int n, int[][] results) {
		int answer = 0;
		boolean[][] wins = new boolean[n+1][n+1];
		boolean[][] loses = new boolean[n+1][n+1];
		for (int[] result : results) {
			int a = result[0];
			int b = result[1];
			wins[a][b] = true;
			loses[b][a] = true;
		}
		for (int i = 1; i < n+1; i++) {
			if(win_bfs(i, wins)+lose_bfs(i,loses) == n-1) answer++;
		}


		return answer;
	}
}