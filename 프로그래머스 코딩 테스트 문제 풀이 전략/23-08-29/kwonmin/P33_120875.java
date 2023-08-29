// 문제 조건이 두 개의 점을 고른다 -> 나머지 두 개의 점과 기울기를 비교한다 인데
// 책에서는 1,2 1,3 1,4 의 가능성을 다 보기 때문에
// 테스트케이스가 추가되어 오답처리가 된다.
// 결국 0,1을 선택했을 때 나머지 2,3이 선택되도록 코드를 작성해야 한다.
// 0, 1을 골랐을 경우 : 3-0, 3-1
// 0, 2를 골랐을 경우 : 3-0, 3-2 해서 1, 3

public class PyeongHang {
	private double getSlope(int x1, int y1, int x2, int y2){
		return (double) (y2-y1) / (x2-x1);
	}

	public int solution(int[][] dots) {
		if(getSlope(dots[0][0], dots[0][1], dots[1][0], dots[1][1]) == getSlope(dots[2][0], dots[2][1], dots[3][0], dots[3][1])
			|| getSlope(dots[0][0], dots[0][1], dots[2][0], dots[2][1]) == getSlope(dots[1][0], dots[1][1], dots[3][0], dots[3][1]))
			return 1;
		return 0;
	}

	public int solution2(int[][] dots) {

		for (int i = 1; i <= 2; i++) {
			if(getSlope(dots[0][0], dots[0][1], dots[i][0], dots[i][1]) == getSlope(dots[3-i][0], dots[3-i][1], dots[3][0], dots[3][1]))
				return 1;
		}

		return 0;
	}
}
