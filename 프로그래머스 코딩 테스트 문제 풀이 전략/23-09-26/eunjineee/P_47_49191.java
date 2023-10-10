package PGS_BOOK.CH11.CH11_02;

public class P_47_49191 {
    private int countForward(int u, boolean[][] graph, boolean[] isVisited){
        int count = 1;
        for(int v = 0; v < graph[u].length; v++){
            if (!graph[u][v] || isVisited[v]) continue;
            isVisited[v] = true;
            count += countForward(v,graph,isVisited);
        }
        return count;
    }

    private int countBackward(int u, boolean[][] graph, boolean[] isVisited){
        int count = 1;
        for(int v = 0; v < graph.length; v++){
            if (!graph[v][u] || isVisited[v]) continue;
            isVisited[v] = true;
            count += countBackward(v,graph,isVisited);
        }
        return count;
    }

    public int book_solution(int n, int[][] results) {
        boolean[][] graph = new boolean[n][n];
        for (int[] edge : results){
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            graph[u][v] = true;
        }
        int count = 0;
        for (int u = 0; u < n; u++){
            int wins = countForward(u, graph, new boolean[n]) -1;
            int loses = countBackward(u, graph, new boolean[n]) -1;
            if (wins + loses + 1 == n){
                count++;
            }
        }

        return count;
    }


    // 좀 어려웠던 문제
    // 이기고, 지는 것을 한번에 확인해서 결정
    public int solution2(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n+1][n+1];

        for(int i = 0; i < results.length; i++)
            graph[results[i][0]][results[i][1]] = 1; //이김
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                for(int z = 0; z <= n; z++) {
                    if (graph[j][i] == 1 && graph[i][z] == 1)
                        graph[j][z] = 1;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            int game = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == 1 || graph[j][i] == 1)
                    game++;
            }
            if (game == n-1)
                answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        P_47_49191 solutionInstance = new P_47_49191();
        int[][] int_arr = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        System.out.println(solutionInstance.solution2(5, int_arr));
    }
}
