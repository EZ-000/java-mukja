// 소요시간은 도로 길이만큼
// 도로길이만큼 차가 오를 수 있음
// 순서대로 움직임. 좀 중요함.
// 그래서, 그냥 큐에 넣으면서 전체 무게 체크하면서
// 가능하면 큐에 넣고, 불가능하면 큐에 안넣고
// 초당으로 계속 while로 움직여도 괜찮을까?

import java.util.ArrayDeque;
import java.util.Deque;


public class P42583 {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Deque<Integer> que = new ArrayDeque<>();
		int total = 0;
		for (int i = 0; i < bridge_length; i++) {
			que.add(0);
		}
		int now = 0;
		while (now < truck_weights.length){
			total -= que.pollFirst();
			if(total+truck_weights[now] <= weight){
				que.add(truck_weights[now]);
				total+=truck_weights[now];
				now += 1;
			}
			else{
				que.add(0);
			}

			answer++;
		}

		while (total > 0){
			total -= que.pollFirst();
			answer++;
		}



		return answer;
	}
}
