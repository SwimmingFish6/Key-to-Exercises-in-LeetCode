/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Queue<UndirectedGraphNode> newQueue = new LinkedList<UndirectedGraphNode>();

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        queue.offer(node);
        newQueue.offer(newNode);
        map.put(node.label, newNode);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0;i < size;i++) {
                List<UndirectedGraphNode> neighbors = queue.peek().neighbors;
                for (int j = 0;j < neighbors.size();j++) {
                    if (map.containsKey(neighbors.get(j).label)) {
                        newQueue.peek().neighbors.add(map.get(neighbors.get(j).label));
                    }
                    else {
                        UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbors.get(j).label);
                        newQueue.peek().neighbors.add(newNeighbor);
                        queue.offer(neighbors.get(j));
                        newQueue.offer(newNeighbor);
                        map.put(neighbors.get(j).label, newNeighbor);
                    }
                }

                queue.poll();
                newQueue.poll();
            }
        }
        
        return newNode;
    }
}