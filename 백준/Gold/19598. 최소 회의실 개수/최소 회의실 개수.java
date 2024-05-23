    import java.io.*;
    import java.util.*;
    import java.lang.Math;
    
    public class Main {
    
        public static void main(String[] args) throws IOException {
    
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());//회의의 개수
    
            PriorityQueue<Meeting> pq = new PriorityQueue<>((o1,o2)->
            {
                if(o1.start!=o2.start){
                    return o1.start-o2.start;
                }
                return o1.end-o2.end;
            });
    
    
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                pq.add(new Meeting(start,end));
            }
    
            PriorityQueue<Integer> ends = new PriorityQueue<>();
            int max = 0;
    
            while(!pq.isEmpty()){
                Meeting m = pq.poll();
                while(!ends.isEmpty() && ends.peek()<=m.start){
                    ends.poll();
                }
                ends.add(m.end);
                max = Math.max(max,ends.size());
            }
    
            System.out.println(max);
        }
    }
    class Meeting{
        public int start;
        public int end;
        public Meeting(int s, int e){
            start = s;
            end = e;
        }
    }