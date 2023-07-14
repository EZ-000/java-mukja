// 방향 정해놓고 뱅글뱅글뱅글 하는거
// 근데 이차원 배열을 어떻게 만들 지.
// 범위 설정만 잘하면 될 거 같기도 하고?

public class Solution {

	private static final int[] dx = {1, 0, -1};
	private static final int[] dy = {0, 1, -1};

	public int[] solution(int n) {
		if (n==1){  // 1인 경우만 예외로 반환하기
			int[] answer = {1};
			return answer;
		}
		int[][] field = new int[n][n]; // 이차원 배열 생성하기
		int value = 1;  // 초기에 들어갈 밸류값 초기화
		int x = 0;      // x 위치를 나타낼 변수 초기화
		int y = 0;      // y 위치를 나타낼 변수 초기화
		int dr = 0;     // 방향 설정할 direction(0부터 시작)
		while(true){
			field[x][y] = value++;  // ++를 뒤에 붙이면, 원래 값이 들어간 이후 값 변경됨
			int nx = x + dx[dr];
			int ny = y + dy[dr];
			if(nx == n || nx == -1 || ny == n || ny == -1 || field[nx][ny] != 0){
				dr = (dr+1)%3;
				nx = x + dx[dr];
				ny = y + dy[dr];
				if(field[nx][ny] != 0){     // 방향을 바꿨는데 채워져있으면 더 진행 못하니까 끝내기
					break;
				}
			}
			x = nx;
			y = ny;

		}

		int[] answer = new int[value-1]; // 마지막에도 value가 1 증가된 상태이기 때문에 value-1의 크기를 가진 배열 생성
		int index = 0;
		for (int i = 0; i < n; i++) {   // 배열 순회하며 정답에 값 채우기
			for (int j = 0; j <= i; j++) {
				answer[index++] = field[i][j];
			}
		}

		return answer;
	}


}
