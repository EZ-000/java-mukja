import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class AtoB {
	
	private Map<Character, Integer> createMap(String word){
		Map<Character, Integer> map = new HashMap<>();
		for (char c : word.toCharArray()) {
			map.putIfAbsent(c, 0); // 존재하지 않으면 넣는 메서드. 알아두기
			map.put(c, map.get(c)+1);
		}

		return map;
	}

	private static Map<String, Long> toMap(String word) { // 책에 나오는 stream 사용하는 버전. 좀 어려움...
		return Arrays.stream(word.split(""))
		             .collect(Collectors.groupingBy(
			             Function.identity(), Collectors.counting()));
	}
	
	public int solution(String before, String after) {
		return createMap(before).equals(createMap(after)) ? 1 : 0;
	}
}
