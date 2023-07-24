public class Abnormal {

	public static String solution(String s) {
		StringBuilder sb = new StringBuilder();
		boolean isUpper = true;

		for (char c : s.toCharArray()) {
			if(c == ' '){   // 책에서는 isAlpabetic인가 쓰는데, 문제에선 공백만 나온다고 해서 굳이 안해도 될 듯
				sb.append(c);
				isUpper = true;
			}
			else{
				if(isUpper) sb.append(Character.toUpperCase(c));
				else sb.append(Character.toLowerCase(c));
				isUpper = !isUpper;
			}
		}

		return sb.toString();
	}


	public static void main(String[] args) {
		System.out.println(solution("try hello world"));
	}
}
