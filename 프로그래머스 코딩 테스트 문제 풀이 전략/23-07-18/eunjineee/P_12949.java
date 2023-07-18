public class Solution {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        //
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                // answer에서 0을 먼저 넣어야 아래에서 더하는 형식 사용할 수 있음 : 자바라서 처음에 빈리스트로 만든건지?!
                answer[i][j] = 0;
                for (int k = 0; k < arr1[i].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
