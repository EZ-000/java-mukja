import java.util.HashMap;
import java.util.Map;


// 단 한 명 있음. 완주 못한 사람이.
public class Lose {
	public String solution(String[] participant, String[] completion) {
		Map<String, Integer> p_map = new HashMap<>();

		for (String sunsu : participant) {
			p_map.putIfAbsent(sunsu, 0);
			p_map.put(sunsu, p_map.get(sunsu)+1);
		}
		
		for (String wanju : completion) {
			p_map.put(wanju, p_map.get(wanju)-1);
		}

		for (String s : p_map.keySet()) {
			if(p_map.get(s) != 0){
				return s;
			}
		}
		// 그냥 빼는걸로 했지만, 책에서는 이 부분에서 0인지 확인하고 0이 됐으면 remove하는 형식으로 구현
		// 그래서 remove 하는 형식이라면, 남은 키값이 하나이기 때문에 바로 리턴이 가능.
		for (String wanju : completion) {
			p_map.put(wanju, p_map.get(wanju)-1);
			if(p_map.get(wanju) == 0) p_map.remove(wanju);
		}
		return p_map.keySet().iterator().next();

		// 이런 형식.
	}
}
