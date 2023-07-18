import java.util.ArrayList;
import java.util.List;


public class Distance {

	private static class Point{ // 큐에 넣을 Point 클래스 선언
		public final int x, y, z;
		private Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

	}


		private final int[] dx = {0,1,0,-1};
		private final int[] dy = {1,0,-1,0};

		private int check_distance(char[][] field, int size){

			List<Point> ps = new ArrayList<>(); // 정점 저장할 리스트 선언
			for (int i = 0; i < size; i++) {    // 탐색할 정점 집어넣기
				for (int j = 0; j < size; j++) {
					if(field[i][j] == 'P'){     // 응시자가 있는 지점 큐에 넣기
						ps.add(new Point(i,j,-1));
					}
				}
			}
			int level = 0;
			while(!ps.isEmpty() && level < 2){  // 큐가 비거나 두 번 돌때까지
				List<Point> new_ps = new ArrayList<>(); // 다음 큐
				for (Point p : ps) {
					for (int i = 0; i < dx.length; i++) {
						if(p.z == i){
							continue;
						}
						int nx = p.x + dx[i];
						int ny = p.y + dy[i];
						if(nx < 0 || nx >= size || ny < 0 || ny >= size){
							continue;
						}
						if(field[nx][ny] == 'P'){   // 다른 응시자를 만나면 0 반환하기
							return 0;
						}
						if(field[nx][ny] == 'O'){   // 이동할 수 있는 곳이면, 큐에 넣기
							new_ps.add(new Point(nx,ny,(i+2)%4));
						}

					}
				}
				level++;    // 레벨 추가 (두 다리까지만 가야됨
				ps = new_ps;   // 새로운 큐로 바꾸기
			}
			return 1;
		}

		public int[] solution(String[][] places) {
			int size = places.length;
			int[] answer = new int[size];
			for (int i = 0; i < size; i++) { // places 순회하면서 가능 여부 확인
				String[] place = places[i]; // 검사 할 대기실
				char[][] field = new char[size][];  // 대기실을 이차원배열화시키기(String을 하나씩 나눠야함)
				for (int j = 0; j < size; j++) {
					field[j] = place[j].toCharArray();
				}
				answer[i] = check_distance(field, size);    // BFS 돌면서 가능 여부 확인
			}
			return answer;
		}

}
