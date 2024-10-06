public class Solution {
	private static final int[] dx = {1, 0, 0, -1};
	private static final int[] dy = {0, -1, 1, 0};
	
	public int[] solution(String[][] places) {
		int[] answer = new int[places.length];
		for (int i = 0; i < answer.length; i++) {
			String[] place = places[i];
			char[][] room = new char[place.length][];
			for (int j = 0; j < room.length; j++) {
				room[j] = place[j].toCharArray();
			}
			if (isValid(room)) {
				answer[i] = 1;
			} else {
					answer[i] = 0;
			}
		}
		return answer;
	}
	
	private boolean isValid(char[][] room) {
		for (int x = 0; x < room.length; x++) {
			for (int y = 0; y < room[x].length; y++) {
				if (room[x][y] != 'P') continue; // 사람이 없는 곳은 패스
				if (!isValid(room, x, y)) return false;
			}
		}
		return true;
	}
	
	private boolean isValid(char[][] room, int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (!isReachable(room, nx, ny)) continue;
			switch(room[nx][ny]) {
				case 'P': return false;
				case 'O': 
					if (isNearPerson(room, nx, ny, 3-d)) return false;
					break;
			}
		}
		return true;
	}

private boolean isReachable(char[][] room, int x, int y) {
	return x >= 0 && y >= 0 && x < room.length && y < room[x].length;
}

private boolean isNearPerson(char[][] room, int x, int y, int exclude) {
	for (int d = 0; d < 4; d++) {
		if (d == exclude) continue; //이미 지나온 방향 패스
		
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		if (!isReachable(room, nx, ny)) continue;
		if (room[nx][ny] == 'P') return true;
	}
		return false;
	}
}