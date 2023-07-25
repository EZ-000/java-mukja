// 생각해보니, 0이랑 1 갯수만 세도 된다.
// 그래서 둘 중 뭐 셀 지 선택해서 문제를 푸는 것도 가능할 듯

// 교재랑 로직 상 차이는 없는데
// 확실히 초기화하는 게 아직 낯설어서
// 하나하나 만들어내는 느낌이 듦...
// 이 부분만 좀 보완하면 될 듯

public class BinaryRepeat {
	private int removeZero(String s){
		int zero = 0;
		for (char c : s.toCharArray()) {
			if(c == '0'){
				zero++;
			}
		}
		return zero;
	}

	public int[] solution(String s) {
		int[] answer = new int[2];
		int level = 0;
		int cnt = 0;
		while(!s.equals("1")){
			level++;
			int zero = removeZero(s);
			cnt += zero;
			int new_one = s.length() - zero;
			s = Integer.toString(new_one, 2);
		}

		answer[0] = level;
		answer[1] = cnt;
		return answer;
	}
}
