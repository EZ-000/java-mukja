public class StringSortReverse {
	public String solution(String s) {

		return s.chars() // chars -> IntStream으로 반환됨
		        .boxed()// Integer로 변환
		        .sorted((v1, v2) -> v2 - v1) // 내림차순 정렬
				.collect(StringBuilder::new, // 이 부분이 좀 어려움... StringBuilder로 문자열화 시키는 건 알겠는데
					StringBuilder::appendCodePoint, // 이거랑
					StringBuilder::append) // 이건 설명이 좀 부족한듯.
				.toString();
	}
}
