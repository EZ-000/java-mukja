// 파이썬보다 묘하게 쉬운 느낌
// reverse가 StringBuilder에만 있는 게 조금 아쉽다

public class ReverseTernary {
	public int solution(int n) {
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toString(n, 3));
		int answer = Integer.valueOf(sb.reverse().toString(), 3);
		return answer;
	}
}
