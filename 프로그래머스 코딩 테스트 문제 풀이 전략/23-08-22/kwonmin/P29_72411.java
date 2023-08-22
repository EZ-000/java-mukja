import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MenuRenewal {
	public static List<String> solution(String[] orders, int[] course) {
		List<String> answer = new ArrayList<>();
		Set<Character> menu = new HashSet<>();
		List<Character> alp = new ArrayList<>();

		for (String order : orders) {
			for (char a : order.toCharArray()) {
				if (alp.contains(a)) {
					menu.add(a);
				} else {
					alp.add(a);
				}
			}
		}

		List<Character> menuList = new ArrayList<>(menu);
		Collections.sort(menuList);

		for (int i : course) {
			List<String> res = new ArrayList<>();
			int maxCnt = 2;

			for (String com : getCombinations(menuList, i)) {
				int cnt = 0;
				for (String order : orders) {
					boolean containsAll = true;
					for (char c : com.toCharArray()) {
						if (order.indexOf(c) == -1) {
							containsAll = false;
							break;
						}
					}
					if (containsAll) {
						cnt++;
					}
				}

				if (cnt > maxCnt) {
					maxCnt = cnt;
					res.clear();
					res.add(com);
				} else if (cnt == maxCnt) {
					res.add(com);
				}
			}

			answer.addAll(res);
		}

		Collections.sort(answer);

		return answer;
	}

	private static List<String> getCombinations(List<Character> menu, int length) {
		List<String> combinations = new ArrayList<>();
		generateCombinations(menu, length, 0, "", combinations);
		return combinations;
	}

	private static void generateCombinations(List<Character> menu, int length, int index, String current, List<String> combinations) {
		if (length == 0) {
			combinations.add(current);
			return;
		}
		for (int i = index; i < menu.size(); i++) {
			generateCombinations(menu, length - 1, i + 1, current + menu.get(i), combinations);
		}
	}
}
