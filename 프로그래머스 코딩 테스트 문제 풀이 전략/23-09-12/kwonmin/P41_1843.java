// 마이너스를 만날 때마다 모드가 바뀌는 느낌
// 최대 최소 최대 최소 ...
// 그래서 max 와 min 을 통해서
// 최대 최소를 만들어서 계산한다 라는 논리

import java.util.Arrays;


public class PlusMinus {

	private final int[][] max_mem = new int[202][202]; // 최대길이만큼 미리 만들어놓기... 근데 굳이굳이? 라는 생각이. 딱 길이만큼 만드는게 메모리적으로 유용하지 않을까. 외부로 빼고싶어서 그런걸까?
	private final int[][] min_mem = new int[202][202];

	private int max(int start, int end, String[] arr) {
		if (max_mem[start][end] != Integer.MIN_VALUE) { // 이미 값이 채워져있으면 더 탐색할 필요가 없음.
			return max_mem[start][end];
		}
		if (end - start == 1) return Integer.parseInt(arr[start]); // 마지막에 등장하는 숫자의 경우, 확인할 필요가 없음

		int max = Integer.MIN_VALUE; // 갱신할 값 넣을 변수
		for (int i = start + 1; i < end; i+=2) { // 두칸씩 띄우기 > 숫자, 부호 순이기 때문
			int l = max(start, i, arr); // 지금까지의 최댓값
			int v;
			if (arr[i].equals("+")) { // 부호가 플러스일 경우
				int r = max(i+1, end, arr); // 지금까지의 최대값 더하기
				v = l + r;
			}
			else {  // 부호가 마이너스일 경우
				int r = min(i+1, end, arr); // 지금까지의 최솟값 빼기
				v = l - r;
			}
			if (v > max) max = v;   // 최대값이 갱신될 경우 갱신하기
		}
		return max_mem[start][end] = max;
		
	}

	private int min(int start, int end, String[] arr) {
		if (min_mem[start][end] != Integer.MAX_VALUE) {
			return min_mem[start][end];
		}
		if (end - start == 1) return Integer.parseInt(arr[start]); // 마지막에 오는 숫자일 경우

		int min = Integer.MAX_VALUE;
		for (int i = start+1; i < end; i+=2) {
			int l = min(start, i, arr);
			int v;
			if (arr[i].equals("+")) {
				int r = min(i+1, end, arr);
				v = l + r;
			}
			else {
				int r = max(i+1, end, arr);
				v = l - r;
			}
			if (v < min) min = v;
		}
		return min_mem[start][end] = min;

	}

	public int solution(String arr[]) {
		for (int[] row: max_mem){
			Arrays.fill(row, Integer.MIN_VALUE);
		}
		for (int[] row: min_mem){
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		return max(0, arr.length, arr);
	}
}
