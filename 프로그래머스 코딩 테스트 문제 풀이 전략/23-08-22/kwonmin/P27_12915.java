// 프로그래머스 12915 문자열 내 마음대로 정렬하기

import java.util.Arrays;

public class SortCustom {
	public String[] solution(String[] strings, int n) {
		Arrays.sort(strings, (s1, s2) -> { // 람다함수. 헷갈리지만 코드 줄이려면 어쩔 수 없는 것 같기도
			if (s1.charAt(n) != s2.charAt(n)){  // 문자가 다를때만
				return s1.charAt(n) - s2.charAt(n); // 해당 인덱스로 정렬
			}
			return s1.compareTo(s2); // 해당 인덱스의 문자가 같으면, 사전순 정렬
		});
		return strings;
	}
}
