import java.util.ArrayList;
import java.util.List;


public class MDic {
	private static final char[] CHARS = {'A','E','I','O','U'};

	private void generate(String word, List<String> wordList) {
		wordList.add(word);

		if (word.length() == 5) {
			return;
		}
		for (char aChar : CHARS) {
			generate(word+aChar, wordList);
		}
	}

	public int solution(String word){
		List<String> wordList = new ArrayList<>();
		generate("", wordList);
		return wordList.indexOf(word);
	}

}

// 근데 교재의 방법은 뭐랄까
// 어? 어차피 이정도 범위면 시간 복잡도 널널하겠지?
// 그럼 다 만들어버리자
// 같은 느낌이라 좀 마음에 들지 않음
// word를 넣고, 해당 단어가 만들어지면 끝내도 되지 않나?
// 범위가 적어서, 두 코드 모두 큰 차이는 없긴 한데

class MdicSolve {
	private static final char[] CHARS = {'A','E','I','O','U'};

	private int generate(String word, String original, List<String> wordList) {
		wordList.add(word);

		if(word.equals(original)){
			return wordList.size()-1;
		}

		if (word.length() == 5) {
			return 0;
		}
		for (char aChar : CHARS) {
			int a = generate(word+aChar, original, wordList);
			if(a != 0){
				return a;
			}
		}
		return 0;
	}

	public int solution(String word){
		List<String> wordList = new ArrayList<>();
		return generate("", word, wordList);
	}

}
