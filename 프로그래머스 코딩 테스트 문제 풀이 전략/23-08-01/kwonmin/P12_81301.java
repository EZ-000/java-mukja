// 범위도 안크고, 정직하게 제공되는 듯?
// 전부 replace 해도 풀리는 놀라운 문제네...
// 더 이쁘게 푸는 법 생각해보자

import java.util.HashMap;
import java.util.Map;

// 손수 노가다하기
public class NumAndWord {
	public int solution(String s) {
		String a = s.replace("zero", "0");
		String b = a.replace("one", "1");
		String c = b.replace("two", "2");
		String d = c.replace("three", "3");
		String e = d.replace("four", "4");
		String f = e.replace("five", "5");
		String g = f.replace("six", "6");
		String h = g.replace("seven", "7");
		String i = h.replace("eight", "8");
		String j = i.replace("nine", "9");
		return Integer.parseInt(j);
	}
}

// Map 구조 사용하기
class NumAndWord2 {
	private Map<String, String> strToInt = new HashMap<>(){{
		put("zero","0");
		put("one","1");
		put("two","2");
		put("three","3");
		put("four","4");
		put("five","5");
		put("six","6");
		put("seven","7");
		put("eight","8");
		put("nine","9");
	}};

	public int solution(String s) {
		for (String s1 : strToInt.keySet()) {
			s = s.replace(s1, strToInt.get(s1));
		}

		return Integer.parseInt(s);

	}
}

// 교재 풀이
class NumAndWord3 {

	private final String[] strToInt = {"zero", "one", "two", "three", "four",
		"five", "six", "seven", "eight", "nine"};

	public int solution(String s) {
		for (int i = 0; i < 10; i++) {
			s = s.replace(strToInt[i], Integer.toString(i));
		}

		return Integer.parseInt(s);

	}
}