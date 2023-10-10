// 뭐랄까 좀 자바스러워서 좋은걸

import java.util.PriorityQueue;


public class DoublePriorityQueue {

	private static class DoublePriorityQue{
		private int size = 0;
		private PriorityQueue<Integer> minQue = new PriorityQueue<>();
		private PriorityQueue<Integer> maxQue = new PriorityQueue<>((a,b) -> b - a);

		public void add(int value){
			maxQue.add(value);
			minQue.add(value);
			size++;
		}

		public void removeMax(){
			if(size == 0) return;
			maxQue.poll();
			if(--size == 0){
				maxQue.clear();
				minQue.clear();
			}
		}
		public void removeMin(){
			if(size == 0) return;
			minQue.poll();
			if(--size == 0){
				minQue.clear();
				maxQue.clear();
			}
		}
		public int max() {
			if (size == 0) return 0;
			return maxQue.peek();
		}

		public int min(){
			if (size == 0) return 0;
			return minQue.peek();
		}

	}

	public int[] solution(String[] operations) {
		DoublePriorityQue que = new DoublePriorityQue();
		for (String operation : operations) {
			String[] tokens = operation.split(" ");
			String command = tokens[0];
			int value = Integer.parseInt(tokens[1]);
			switch (command){
			case "I": {
				que.add(value);
				break;
			}
			case "D": {

				if (value == 1) {
					que.removeMax();
				} else {
					que.removeMin();
				}
			}
			}
			System.out.println(que.size);

		}


		return new int[]{que.max(), que.min()};
	}
}
