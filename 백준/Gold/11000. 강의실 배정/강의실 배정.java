import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {
	
	public static void main(String [] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수업의 개수
        
        PriorityQueue<Class> pq = new PriorityQueue<>();
        
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.add(new Class(start,end,end-start));
		}
		
		PriorityQueue<Integer> ends = new PriorityQueue<>();
		ends.add(0);
		
		while(!pq.isEmpty()) {
			Class c = pq.poll();
			if(ends.peek() <= c.start) {
				ends.poll();
			}
			ends.add(c.end);
		}
		
		
		System.out.println(ends.size());
		
	}

}
class Class implements Comparable<Class>{
	public int start;
	public int end;
	public int time;
	public Class(int s, int e, int t) {
		start = s;
		end = e;
		time = t;
	}
	
	public int compareTo(Class o2) {
		if(this.start-o2.start<0) {
			return -1;
		}else if(this.start-o2.start>0) {
			return 1;
		}else {
			if (this.time - o2.time < 0) {
				return -1;
			}else if (this.time - o2.time > 0) {
				return 1;
			}else {
				return 0;
			}
		}
	}
}