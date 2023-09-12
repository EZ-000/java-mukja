// 두 가지 문제가 있음
// 1. 왼쪽으로 한 칸 돌리기 = 시간복잡도 생각하면 Deque쓰는 게 맞지 않을까 라는 생각을 함
// 왼쪽으로 돌리는 건, Python에서는 rotate가 있는데 Java에는 아마 없는 듯 해서 구현을 해야 해야 할 듯
// -> 1번 숙제. Deque를 왼쪽으로 돌리는 rotate 함수 만들기

// 2. 괄호가 맞는 지 판별하기
// 순회하며, ArrayList에 여는 괄호들을 넣어둔다.
// 닫는 괄호를 만나면, ArrayList[-1]을 확인한다.
// 짝이 맞으면, pop해서 없앤다.
// 안맞으면 거기서 false 리턴
// 마지막까지 순회했을 때, ArrayList의 사이즈를 확인해서 1보다 크면 false, 1이면 true


import java.util.*;


class Solve1 {

	private final Map<Character, Character> brackets = new HashMap<>() {{
		put(']','[');
		put('}','{');
		put(')','(');
	}};

	private Deque<Character> rotate(Deque<Character> que){

		Character a = que.removeFirst();
		que.add(a);

		return que;
	}

	private int checkPairs(Deque<Character> que){
		Deque<Character> bracketList = new ArrayDeque<>();
		bracketList.add('A');
		for (Character c : que) {
			if(c == '{' || c == '[' || c == '('){
				bracketList.add(c);
			}
			else{
				Character x = bracketList.pollLast();
				if(!x.equals(brackets.get(c))){
					return 0;
				}
			}
		}
		if(bracketList.size() > 1){
			return 0;
		}

		return 1;
	}

	public int solution(String s) {
		int answer = 0;

		Deque<Character> bracketQue = new ArrayDeque<>();
		for (char c : s.toCharArray()) {
			bracketQue.add(c);
		}
		for (int i = 0; i < s.length(); i++) {
			answer += checkPairs(bracketQue);
			bracketQue = rotate(bracketQue);
		}

		return answer;
	}

}

public class BracketSpin{

	public static void main(String[] args) {
		Solve1 sol = new Solve1();
		System.out.println(sol.solution("[](){}"));
	}
}
