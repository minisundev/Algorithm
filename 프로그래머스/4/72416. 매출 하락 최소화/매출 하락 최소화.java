import java.util.*;

class Solution {
    Map<Integer,List<Integer>> leadToMember = new HashMap<>();
    int min = Integer.MAX_VALUE;
    int [] sales;
    
    public int solution(int[] sales, int[][] links) {
        this.sales = sales;
        
        for(int i=0; i<links.length; i++){
            int [] arr = links[i];
            int lead = arr[0]-1;
            int member = arr[1]-1;
            
            List<Integer> list1 = leadToMember.getOrDefault(lead,new ArrayList<>());
            list1.add(member);
            leadToMember.put(lead, list1);
        }
        
        Node ceo = fillNode(0);
        
        return Math.min(ceo.include, ceo.exclude);
    }
    
    Node fillNode(int i){
        List<Integer> members = leadToMember.getOrDefault(i, new ArrayList());
        List<Node> nodes = new ArrayList<>();
        for(int index : members){
            nodes.add(fillNode(index));
        }
        int price = sales[i];
        Node node = new Node(i,price,nodes);
        
        if(members.size()>0){
            node.lead = true;
            //리프노드가 있으면 
            node.include = price+minOfAll(node);//Min(this.price + Min(members.include,members.exclude)) => Team의 lead인 노드는 반드시 포함해야함!
            node.exclude = minOfInclude(node);//Min(members.include) => Team의 lead인 노드는 반드시 포함해야함!
            
        }else{
            node.lead = false;
            node.include = price;//leaf노드가 아닌 이상은... members가 없으면 leaf노드지 뭐...
        }
        
        return node;
    }
    
    int minOfAll(Node node) {
    // 내가 포함되는 경우: price + sum(min(child.include, child.exclude))
    int sum = 0;
    for (Node child : node.members) {
        sum += Math.min(child.include, child.exclude);
    }
    return sum;
}

int minOfInclude(Node node) {
    // 내가 제외되는 경우: sum(min(child.include, child.exclude)) 
    // 반드시 한 명은 include
    int sum = 0;
    int diff = Integer.MAX_VALUE;
    boolean hasIncluded = false;

    for (Node child : node.members) {
        if (child.include <= child.exclude) {
            sum += child.include;
            hasIncluded = true;
        } else {
            sum += child.exclude;
            diff = Math.min(diff, child.include - child.exclude);
        }
    }

    if (!hasIncluded) {
        sum += diff; // 보정: 최소 한 명을 강제로 include
    }

    return sum;
}
}

class Node{
    public int number;
    public int price;
    public List<Node> members;
    boolean lead = false;
    public int include = 0;//this.price + Min(members.include,members.exclude)) => Team의 lead인 노드는 반드시 포함해야함!
    public int exclude = 0;//Min(members.include) => Team의 lead인 노드는 반드시 포함해야함!
    
    public Node(int n, int p, List<Node> m){
        number = n;
        price = p;
        members = m;
    }
}