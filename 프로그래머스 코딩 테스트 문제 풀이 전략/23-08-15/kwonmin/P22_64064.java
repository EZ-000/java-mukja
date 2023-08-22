// 정규표현식이랬는데, 좀 어렵네... 아무 문자를 나타내는 . 으로 바꿔서 찾기
// matches 를 기억해둬야 할 듯. 정규표현식을 인자로 받는 메서드
// stream 사용. 확실히 stream을 쓰면 코드가 깔끔해짐. 자바 특유의 자료형 새로 선언해둘 필요도 없고

import java.util.*;


public class AbnormalUser {

	private void count(int index, Set<String> banned, String[][] bans, Set<Set<String>> banSet){

		if (index == bans.length) {
			banSet.add(new HashSet<>(banned));
			return;
		}
		for (String id : bans[index]) {
			if (banned.contains(id)) continue;
			banned.add(id);
			count(index + 1, banned, bans, banSet);
			banned.remove(id);
		}
	}

	public int solution(String[] user_id, String[] banned_id) {
		String[][] bans = Arrays.stream(banned_id)
		                        .map(banned -> banned.replace('*', '.')) // 순회하면서 *을 다른 모든 문자를 뜻하는 정규표현식 . 으로 변경
		                        .map(banned -> Arrays.stream(user_id) // 변경한 것을 가지고 새로운 stream 진행
		                                             .filter(id -> id.matches(banned)) // 이번엔 user_id를 순회하며 매치되는 걸 filter
		                                             .toArray(String[]::new))
		                        .toArray(String[][]::new); // banned_id 와 user_id로 2차원 배열 만들기
		Set<Set<String>> banSet = new HashSet<>();
		count(0, new HashSet<>(), bans, banSet);
		return banSet.size();
	}


	// List로 DFS 진행하기 (Set은 메모리가 무거움)

	// 결과 : 문제를 잘못 이해함 ㅇㅇ;;
	// List로 할 경우 같은 유저를 여러 번 밴 할 가능성이 생김
	// 각기 다른 밴 리스트가 필요하기 때문에, 메모리 문제가 있더라도 Set이 더 효율적일 듯.
	// 검증하는 로직 넣는 게 더 무거움

	private void count2(int index, List<String> banned, String[][] bans, List<List<String>> banList){
		// 일반적인 DFS
		// Set으로 중복을 제외시키긴 했는데
		// List로 해도 똑같지 않을까? 라는 생각
		// ArrayList = 삭제에 비효율적. LinkedList 사용
		if (index == bans.length) {
			banList.add(new LinkedList<>(banned));
			return;
		}
		for (String id : bans[index]) {
			if (banned.contains(id)) continue;
			banned.add(id);
			count2(index + 1, banned, bans, banList);
			banned.remove(banned.size()-1);
		}
	}

	public int solution2(String[] user_id, String[] banned_id) {
		String[][] bans = Arrays.stream(banned_id)
		                        .map(banned -> banned.replace('*', '.')) // 순회하면서 *을 다른 모든 문자를 뜻하는 정규표현식 . 으로 변경
		                        .map(banned -> Arrays.stream(user_id) // 변경한 것을 가지고 새로운 stream 진행
		                                             .filter(id -> id.matches(banned)) // 이번엔 user_id를 순회하며 매치되는 걸 filter
		                                             .toArray(String[]::new))
		                        .toArray(String[][]::new); // banned_id 와 user_id로 2차원 배열 만들기
		List<List<String>> banList = new LinkedList<>();
		count2(0, new LinkedList<>(), bans, banList);
		return banList.size();
	}
}
