import java.util.Scanner;

public class Solution_1210 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[100][100];
		for(int test_case = 1;test_case <= 10;test_case++) {
			int x = 99;
			int y = 0;
			int t = sc.nextInt();
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for(int i=0;i<100;i++) {
				if(map[99][i] == 2) { // 도착점 먼저 탐색 후 역탐색
					y = i;
					break;
				}
			}
			
			
			while(true) {
				if(x == 0) // 시작점 도착시 종료
					break;
				
				if(y != 0 && map[x][y-1] == 1) { //좌측 탐색
					y--;
					map[x][y] = 0; // 지나온길은 0으로 초기화
				}else if(y != 99 && map[x][y+1] == 1) {  //우측탐색
					y++;
					map[x][y] = 0; // 지나온길은 0으로 초기화
				}else { //양쪽 길 없을 때 상승
					x--;
					map[x][y] = 0; // 지나온길은 0으로 초기화
				}
			}
			System.out.println("#"+test_case+" "+y);
		}
	}

}
