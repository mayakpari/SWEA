import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1238_양승호 {

	
	public static void main(String[] args) {
		int T = 10, N, start, x, y;
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer>[] arr;
		for(int test_case=1; test_case<=T; test_case++) {
			N = sc.nextInt();
			start = sc.nextInt();
			arr = new ArrayList[N];
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = new ArrayList<Integer>();
			}
			
			for(int i=0; i<N/2; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				if(!arr[x].contains(y))
					arr[x].add(y);
			}
			
			System.out.printf("#%d %d\n",test_case, bfs(arr, start));
		}
	}

	private static Integer bfs(ArrayList<Integer>[] arr, int start) {
		int MAX=-1;
		boolean[] v = new boolean[arr.length];
		Queue<Call> Q = new LinkedList<Call>();
		Q.add(new Call(start, 0)); 
		v[start] = true;
		int maxDepth = 0;
		while(!Q.isEmpty()) {
			Call p = Q.poll();
			
			if(maxDepth <= p.depth) {
				if(maxDepth == p.depth)
					MAX = MAX<p.data ? p.data : MAX;
				else {
					MAX = p.data;
					maxDepth = p.depth;
				}
			}
			
			for(int i=0; i<arr[p.data].size(); i++) {
				Integer n = arr[p.data].get(i);
				if(!v[n]) {
					v[n] = true;
					Q.add(new Call(n, p.depth+1));
				}
			}
		}
		return MAX;
		
	}
	
	private static class Call{
		int data;
		int depth;
		
		public Call(int data, int depth) {
			this.data = data;
			this.depth = depth;
		}
	}

}