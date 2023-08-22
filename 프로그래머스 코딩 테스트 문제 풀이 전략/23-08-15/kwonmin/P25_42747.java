// 자바스럽게 풀기...
// for 문 조건 설정이 자유로운 건 장점인듯

import java.util.Arrays;

public class HIndex {

	public int solution(int[] citations) {
		Arrays.sort(citations);

		for (int i = citations.length; i >= 1 ; i--) {
			if (citations[citations.length-i] >= i) return i;
		}

		return 0;
	}
}
