// deque가 필요한가?
// 안쓰고 한번 해보기

import java.util.ArrayList;
import java.util.List;


public class Develop {

	public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < progresses.length; i++) {
			int rest = 100 - progresses[i];
			int days = (int)Math.ceil((double) rest/speeds[i]);
			int cnt = 1;
			for (int j = i+1; j < progresses.length; j++) {
				if(100-progresses[j] > speeds[j]*days) break;
				cnt++;
				i++;
			}
			answer.add(cnt);
		}
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

}

