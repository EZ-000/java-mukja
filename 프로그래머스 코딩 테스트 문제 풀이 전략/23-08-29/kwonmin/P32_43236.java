// 문제에 따라 이진 탐색 범위는 도착 지점까지 거리인 1부터 distance까지입니다.
//	우리는 문제 조건을 만족하는 값 중 가장 큰 값을 구해야 하므로 끝부분이 포함되지 않는 범위 표기법인 [start, end)를 사용해야 합니다.
//	따라서 이진 탐색 범위는 다음과 같이 [1, distance + 1)로 선언합니다.
// 좀 헷갈림...

// 이진탐색 -> 범위에 대한 완전탐색 같은 느낌

import java.util.Arrays;


public class Stones {

	private boolean isValid(int mid, int[] rocks, int n){
		int removed = 0;
		int last = 0;
		for (int rock : rocks) {
			if (rock - last < mid) {
				removed++;
				continue;
			}

			last = rock;
		}
		return removed <= n;
	}

	public int solution(int distance, int[] rocks, int n) {

		rocks = Arrays.copyOf(rocks, rocks.length+1);
		rocks[rocks.length-1] = distance; // 마지막 칸에 distance 추가
		Arrays.sort(rocks);

		int start = 1;
		int end = distance + 1;

		while (start + 1 < end) {
			int mid = (start + end) / 2;
			if (isValid(mid, rocks, n)) start = mid;
			else end = mid;


		}


		return start;
	}
}
