package solve;

import java.util.LinkedList;

public class pro_������ {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 1, 9, 1, 1, 1},0));
		
	}
	public static int solution(int[] priorities, int location) {
       
        int len = priorities.length;
        LinkedList<Point> list = new LinkedList<>();
        for(int i=0; i<len ;i++) {
        	
        	if(location == i)
        		list.add(new Point(priorities[i],true));
        	else
        		list.add(new Point (priorities[i],false));
        }
        int answer = 1;
        while(!list.isEmpty()) {
        	Point p = list.get(0);
        	int size = list.size();
        	boolean stop = false;
        	if(size>2) {
        		int idx =1;
            	while(idx<size) {
            		Point compare_p = list.get(idx);
            		if(p.priority < compare_p.priority) {
            			stop = true;
            			break;
            		}
            		idx++;
            	}
        	}
        	list.remove(0);
        	
        	if(stop) {        	
        		list.add(p);
        	}else {
        		if(p.flag) {        	
        			break;
        		}else {
        			answer++;
        		}
        		
        	}
        	
        }
        
        return answer;
    }
	static class Point{
		int priority;
		boolean flag;
		
		public Point(int p , boolean f) {
			this.priority = p;
			this.flag = f;
		}
	}
}
