// 42746 가장 큰 수

// 정렬하는 게 참 신박하다.. 라는 생각
// Sort에 조건 거는 게 흠. 파이썬도 람다로 하면 되나?
// 진짜 Stream은 신인가...? 할 수 있는 거랑 못하는 걸 아직 분류를 못하겠음
// 교재에선 뚝딱해서 참 쉽죠? 이러는데... 쉽지않음

import java.util.Arrays;
import java.util.stream.Collectors;


public class BiggestNumber {
	public String solution(int[] numbers) {
		return Arrays.stream(numbers)
			.mapToObj(String::valueOf) // mapToObj로 다른 형태로 변환 -> ValueOf로 String화 시킴
			.sorted((s1, s2) -> {
				int a1 = Integer.parseInt(s1+s2); // 하나만 더하는거라 String을 그냥 더하는 느낌인데 속도 상 문제없을까 싶음
				int a2 = Integer.parseInt(s2+s1);
				return a2-a1;
			})
			.collect((Collectors.joining(""))) // 파이썬의 join느낌으로 합치기
			.replaceAll("^0+", "0"); // 정규표현식으로 0일 경우 방지하기. 예외처리해도 될 듯.
	}
}
