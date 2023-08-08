import java.util.ArrayList;
import java.util.List;

// 해설을 봤지만, 혼자서는 점화식 못 만들 듯.
// 나중에 하노이 고수한테 설명 듣기

public class HanoiTower {
}

class HanoiSol {

	private void hanoi(int n, int from, int to, List<int[]> hanoiList){
		if (n == 1) {
			hanoiList.add(new int[] {from, to});
			return;
		}

		int empty = 6 - from - to;

		hanoi(n-1, from, empty, hanoiList);
		hanoi(1, from, to, hanoiList);
		hanoi(n-1, empty, to, hanoiList);

	}

	public int[][] solution(int n) {
		List<int[]> hanoiList = new ArrayList<>();
		hanoi(n, 1, 3, hanoiList);
		return hanoiList.toArray(new int[0][]);
	}
}
