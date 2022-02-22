import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_4047 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		outer : for(int i=1;i<=N;i++) {
			boolean[][] check = new boolean[4][13];
			int[] shape = {13,13,13,13};
			String line = br.readLine();
			for(int j=0;j<line.length()/3;j++) { //받은 문자열을 3칸씩 처리
				int idx = ((line.charAt(j*3+1)-'0')*10 + line.charAt(j*3+2)-'0')-1; // 3칸씩 끊은 기준으로 2번째 칸은 십의 자리, 3번째 칸은 일의 자리로 카드번호 계산
				switch(line.charAt(j*3)) { // 3칸씩 끊은 기준으로 첫번째 자리로 모양 판별
				case 'S':
					if(check[0][idx]) { // 같은 카드가 있으면
						System.out.println("#"+i+" ERROR"); // Error 출력후 현재 테스트케이스 건너뜀
						continue outer;
					}
					check[0][idx] = true; // 같은 카드가 없으면 표시 후
					shape[0]--; //남은 카드 개수 갱신
					break;
				case 'D':
					if(check[1][idx]) {
						System.out.println("#"+i+" ERROR");
						continue outer;
					}
					check[1][idx] = true;
					shape[1]--;
					break;
				case 'H':
					if(check[2][idx]) {
						System.out.println("#"+i+" ERROR");
						continue outer;
					}
					check[2][idx] = true;
					shape[2]--;
					break;
				case 'C':
					if(check[3][idx]) {
						System.out.println("#"+i+" ERROR");
						continue outer;
					}
					check[3][idx] = true;
					shape[3]--;
					break;
				}
			}
			System.out.print("#"+i);
			for(int j=0;j<4;j++) {
				System.out.print(" "+shape[j]);
			}
			System.out.println();
		}
	}

}
