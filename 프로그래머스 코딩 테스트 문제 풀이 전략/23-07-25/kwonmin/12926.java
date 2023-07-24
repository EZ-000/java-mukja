// 결국 아스키코드를 다루는 건 크게 난이도 있는 건 아닌데
// 자바에서 문자열을 다루는 게 파이썬보다는 좀 귀찮기 때문에
// 그러한 과정을 유의하면서 문제를 풀어야 함
// 알파벳 갯수 총 26개 = 이거 기준으로 하면 안되나? 라는 생각

public class Ceaser {

	public char push(char c, int n){
		if(c == ' ') return c;

		int offset = Character.isUpperCase(c) ? 'A' : 'a'; // 대문자면 A, 소문자면 a를 반환하는 삼항연산자
		int position = (c - offset + n) % 26;
		return (char) (offset + position);

	}

	public String solution(String s, int n) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			sb.append(push(c, n));
		}
		return sb.toString();
	}
}
