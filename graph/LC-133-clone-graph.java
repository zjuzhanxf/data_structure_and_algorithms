//LC-133-clone-graph

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
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        
        Map<Integer,UndirectedGraphNode> nodeMap = new HashMap<>(); // put the new generated node in the map! not the original!
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        nodeMap.put(newNode.label, newNode);
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode neighbor : head.neighbors) {
                if (!nodeMap.containsKey(neighbor.label)) {
                    UndirectedGraphNode copiedNeighbor = new UndirectedGraphNode(neighbor.label);
                    nodeMap.put(neighbor.label, copiedNeighbor);
                    queue.add(neighbor);
                }
                nodeMap.get(head.label).neighbors.add(nodeMap.get(neighbor.label));
            }
        }
        
        return newNode;
    }
}