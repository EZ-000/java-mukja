// 이렇게 냅다 범위를 이진탐색할 줄은 몰랐는데
// 라이브러리도 한번 써보는게 어떨까 싶기도
// 근데 여기는 계산하는 과정이 필요해서, 곤란함

public class Ipgook {

	private boolean isValid(long mid, int n, int[] times){
		long cnt = 0; // end 범위가 int를 초과하기 때문에 long
		for (int time : times) {
			cnt += mid / time;
		}
		return cnt >= n;
	}

	public long solution(int n, int[] times) {
		long start = 1;
		long end = 1000000000000000000L; // 최대값. 1,000,000,000 * 1,000,000,000

		while (end > start) {
			long mid = (start + end) / 2;
			if (isValid(mid, n, times)) end = mid; // n보다 클 경우, max 값 줄이기
			else start = mid + 1;  // n보다 작을 경우, min 값 줄이기
		}

		return start;
	}
}
