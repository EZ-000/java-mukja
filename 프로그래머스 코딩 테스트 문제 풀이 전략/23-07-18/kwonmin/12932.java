class 자연수뒤집어배열로만들기 {
	public int[] solution(long n) {
		// StringBuilder를 사용하는 방법
		String s = new StringBuilder(Long.toString(n)).reverse().toString(); // StringBuilder에서 제공하는 reverse 메서드 사용하기
		char[] chars = s.toCharArray(); // 순회하기 쉽도록 toCharArray 사용
		int[] answer = new int[chars.length];
		for (int i = 0; i < chars.length; i++) {    // 순회하며 answer 채우기
			answer[i] = chars[i] - '0';
		}

		return answer;
	}

	public int[] solution2(long n){
		// charAt으로 접근하는 방법
		String s = Long.toString(n);    // 문자열로 만들기
		int[] answer = new int[s.length()];
		for (int i = s.length()-1; i >= 0 ; i--) {
			answer[s.length()-i-1] = s.charAt(i) - '0'; // charAt의 시간복잡도는 O(1).N번의 시간만 필요함
		}

		return answer;
	}

}