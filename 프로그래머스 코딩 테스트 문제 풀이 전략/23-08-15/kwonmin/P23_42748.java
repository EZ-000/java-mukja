// 배열 자를 줄만 알면 풀 수 있는 쉬운 문제 라고 생각 함...
// 굳이 모듈화를 해야하나? 라는 생각이 듦

// 풀고 나니, 교재랑은 큰 차이가 없는 느낌
// copyOfRange 몰라서 좀 찾아봄

import java.util.Arrays;


public class K_Number {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for (int i = 0; i < commands.length; i++) {
			int[] command = commands[i];
			int[] arr = Arrays.copyOfRange(array, command[0]-1, command[1]);
			Arrays.sort(arr);
			answer[i] = arr[command[2]-1];

		}
		return answer;
	}

}
