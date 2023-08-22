import java.util.HashSet;
import java.util.Set;


public class TwoSelectSum {
	public int[] solution(int[] numbers) {
		int[] answer = {};
		Set<Integer> nums = new HashSet<>();
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i+1; j < numbers.length; j++) {
				nums.add(numbers[i]+numbers[j]);
			}
		}

		return nums.stream().mapToInt(Integer::intValue).sorted().toArray(); // 어려움... 진짜 stream 공부해야될듯
	}
}
