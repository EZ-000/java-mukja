class 배열의곱셈 {
	public int[][] solution(int[][] arr1, int[][] arr2) {

		int[][] answer = new int[arr1.length][arr2[0].length]; // 곱셈 결과 만들어질 배열. 배열1의 가로 * 배열2의 세로

		for(int i=0; i<arr1.length; i++){   // 가로만큼
			for(int j=0; j<arr2[0].length; j++){    // 세로만큼
				answer[i][j] = 0;   // 초기화
				for(int k=0; k<arr1[i].length; k++){
					answer[i][j] += arr1[i][k] * arr2[k][j];    // 순회하며 곱한 값 더해주기
				}
			}
		}

		return answer;
	}
}
