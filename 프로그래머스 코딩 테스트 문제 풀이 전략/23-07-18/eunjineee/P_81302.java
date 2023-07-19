// 코드를 역할에 따라 나누어서 설계한 것이 인상적
// 항상 급하게 문제 풀지말고 "자바"스럽게 푸는 연습하기!
public class P_81302 {
    private static final int dx[] = {0,-1,1,0};
    private static final int dy[] = {-1,0,0,1};

    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude){
        for (int d = 0; d < 4; d++){
            if (d == exclude) continue;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            if (room[ny][nx] == 'P') return true;
        }
        return false;
    }

    private boolean isDistanced(char[][] room, int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;

            switch (room[ny][nx]) {
                case 'P':
                    return false;
                case 'O':
                    if (isNextToVolunteer(room, nx, ny, 3 - d)) return false;
                    break;
            }
        }
        return true;
    }
    //코드의 가독성을 위해 오버로딩을 선언 : 만약 파이썬으로 풀었다면 안에 깊이 변수를 넣어서 한 코드안에서 해결했을듯
    private boolean isDistanced(char[][] room){
        // 거리두기 검사
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                if (room[y][x] != 'P') continue;
                if (!isDistanced(room, x, y)) return false;
            }
        }
        return true;
    }


    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < answer.length; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for (int j = 0; j < room.length; j++) {
                room[j] = place[j].toCharArray();
            }
            if (isDistanced(room)){
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }
}