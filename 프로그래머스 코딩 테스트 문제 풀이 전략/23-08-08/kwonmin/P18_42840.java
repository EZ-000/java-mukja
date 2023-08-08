// 동점자가 여러 명일 경우, 여러 명이 담긴 배열을 return해야 하는 데
// 이 부분이 살짝 까다로운 듯
// 교재에서는 stream을 쓰는데, 개인적으로 스트림 공부도 해야 할 듯.
// 띵수가 스트림을 참 좋아했음

import java.util.stream.IntStream;


public class MoiTest {

	private static final int[][] RULES = {
		{1, 2, 3, 4, 5},
		{2, 1, 2, 3, 2, 4, 2, 5},
		{3, 3, 1, 1, 2, 2, 4, 4, 5, 5},
	};

	private int getAnswer(int person, int problem) {
		int[] rule = RULES[person];
		int index = problem % rule.length;
		return rule[index];
	}

	public int[] solution(int[] answers) {
		int[] supoja = new int[3];
		int max_score = 0;

		for (int i = 0; i < answers.length; i++) {
			int answer = answers[i];

			for (int j = 0; j < 3; j++) {
				if(answer == getAnswer(j, i)){
					max_score = Math.max(max_score, ++supoja[j]);
				}
			}
		}

		int finalMax_score = max_score;
		return IntStream.range(0, 3).filter(i -> supoja[i] == finalMax_score).map(i -> i+1).toArray();
		// range로 0,1,2만 들어가게(i값).
		// filter로 조건 걺. 여기서는 max score와 동일한 값 찾기.
		// 동일할 경우, 맵으로 index+1 값을 넣어줌.
		// 이렇게 넣은 걸 toArray로 배열화시킴.

	}
}
