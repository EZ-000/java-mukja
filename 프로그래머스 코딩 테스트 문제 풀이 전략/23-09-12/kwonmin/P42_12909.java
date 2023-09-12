public class Brackets {
	boolean solution(String s) {
		int cnt = 0;
		for (char c : s.toCharArray()) {
			if(c=='('){
				cnt++;
			}else {
				cnt--;
				if(cnt<0) return false;
			}
		}

		return cnt == 0;
	}
}
