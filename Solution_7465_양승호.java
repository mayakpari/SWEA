import java.util.Scanner;

public class Solution_7465_양승호 {
	static int[] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			parent = new int[N+1];
			boolean[] ans = new boolean[N+1]; 
			for(int i=1; i<N+1; i++) 
				parent[i] = i;
			for(int i=0; i<M; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				if ( find(A) != find(B) ) {
					union(A,B);
				}
			}
			int cnt = 0;
			for(int i=1; i<N+1; i++) {
				int A = find(i);
				if ( !ans[A] ) { 
					cnt++;
				}
				ans[A] = true;
			}
			
			System.out.println("#"+test_case+" "+cnt);
		}
	}
	
	static int find(int n) {
		if ( n == parent[n] ) {
			return n;
		} else {
			return parent[n] = find(parent[n]);
		}
	}
	
	static void union(int n1,int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if ( p1 != p2 ) { 
			parent[p2] = p1; 
		}
	}
}