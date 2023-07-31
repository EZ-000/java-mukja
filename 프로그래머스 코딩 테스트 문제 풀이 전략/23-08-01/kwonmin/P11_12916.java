public class CountPandY {
	boolean solution(String s) {
		int p_cnt = 0;
		int	y_cnt = 0;
		for (char c : s.toCharArray()) {
			if(c == 'p' || c == 'P'){
				p_cnt++;
			} else if (c == 'y' || c == 'Y') {
				y_cnt++;
			}
		}

		return p_cnt == y_cnt;
	}
}
