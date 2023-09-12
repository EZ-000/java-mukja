// prices 를 순회하면서 가격을 검사하는데
// 이 가격이 기존 들어가 있던 가격보다 낮으면
// 기존에 있는 값을 꺼내고, 인덱스의 차만큼 집어넣는다.
// stack에는 인덱스만 관리.

import java.util.Stack;


public class StockPrice {

	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < prices.length; i++) {
			while(!stack.isEmpty() && prices[stack.peek()] < prices[i]){
				int idx = stack.pop();
				answer[idx] = i - idx - 1;
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			int idx = stack.pop();
			answer[idx] = prices.length - idx - 1;
		}

		return answer;
	}

}
