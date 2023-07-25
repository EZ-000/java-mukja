// 절반까지만 순회하면서
// 압축 가능 여부 판별하면 될 것 같은데
// 결국 자르는거 -> substring 사용
// 딱 절반까지만 순회하면서
// 자바라서 저렇게 하는건가??
// 책이 왜저렇게 귀찮게 하는 지를 잘 모르겠음 사실

//--------- 오답 노트 -----------
//카운트를 0부터 해도 길이 상 상관없을거라고 생각했는데
//이게 같은 게 두자릿수가 될 때 문제가 생기기 때문에
//cnt를 0으로 시작하는 게 아니라 1로 시작하도록 수정함

// 교재랑 비교해보면, 교재에서는 자르는 것 조차 하나의 모듈로 만들었는데
// 어차피 순회하는데 그럴 필요가 있나 싶었음.
// 그리고 교재에서는 그냥 잘라서 넣고, 빌더로 길이를 잴 때 확인을 하는데
// 이 로직은 자르면서 이전거랑 비교하는 게 차이점.
// 그래서 교재보다는 Solution 내부의 내용이 더 길어지긴 하는 듯.

// 이전거랑 비교를 해야하는데, 초기에 아무것도 없으면 확인하는 로직을 추가해야 하는데
// 좀 번거롭다는 생각이 들었음. 그래서 그냥 임의의 문자(여기서는 한글 안나오니까 ㄱ 추가)를 넣어서
// isEmpty 같은 걸 사용하지 않고 풀 수 있도록 설정했음

import java.util.ArrayList;
import java.util.List;


public class StringZip {

	private int getSize(List<String> lst){
		StringBuilder sb = new StringBuilder();
		for (String s : lst) {
			sb.append(s);
		}
		return sb.toString().length();
	}

	public int solution(String s) {
		int answer = s.length();


		for (int i = 1; i <= s.length()/2; i++) {
			int cnt = 1;
			List<String> repeat = new ArrayList<>();
			repeat.add("ㄱ");    // 임의의 문자 하나 넣어두기
			for (int j = 0; j < s.length(); j+=i) { // 이러면, 자르는 범위가 설정이 됨
				int endIndex = Math.min(j+i, s.length());
				String st = s.substring(j, endIndex);
				if(st.equals(repeat.get(repeat.size()-1))){
					cnt++;
				}
				else{
					if(cnt > 1){
						repeat.add(String.valueOf(cnt));
						cnt = 1;
					}
					repeat.add(st);
				}
			}
			if(cnt > 1){
				repeat.add(String.valueOf(cnt));
			}
			answer = Math.min(answer, getSize(repeat)-1);

		}

		return answer;
	}

}
