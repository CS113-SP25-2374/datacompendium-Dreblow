package CS113.Graphs;

import CS113.ArrayList.ArrayListDAD;
import CS113.ListInterface;

public class GraphInterfaceDAD implements GraphInterface {

    public class Edge implements Comparable<Edge> {
        String fromNode;
        String toNode;

        public Edge(String from, String to) {
            fromNode = from;
            toNode = to;

        }

        @Override
        public int compareTo(Edge o) {
            int fromComparison = this.fromNode.compareTo(o.fromNode);
            if (fromComparison != 0) {
                return fromComparison;
            }
            return this.toNode.compareTo(o.toNode);
        }
    }

    ListInterface<String> nodes = new ArrayListDAD<>();
    ListInterface<Edge> edges = new ArrayListDAD<>();


    public GraphInterfaceDAD() {

    }

    @Override
    public void addNode(String node) {
        nodes.add(node);
    }

    @Override
    public void addEdge(String node1, String node2, boolean directed) {
        if (!nodes.contains(node1) ||!nodes.contains(node2)) {
            return;
        }

        Edge edge = new Edge(node1, node2);
        if (!edges.contains(edge)) {
            edges.add(edge);
        }
        if (!directed) {
            edge = new Edge(node2, node1);
            if (!edges.contains(edge)) {
                edges.add(edge);
            }
        }
    }

    @Override
    public ListInterface<String> getNeighbors(String node) {
        ListInterface<String> neighbors = new ArrayListDAD<>();
        for (int i = 0; i < edges.size(); i++) {
            if(edges.get(i).fromNode.equals(node)) {
                neighbors.add(edges.get(i).toNode);
            }
        }

        return neighbors;
    }

    @Override
    public void printGraph() {
        int n = nodes.size();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i< n; i++) {
            for (int j = 0; j < n; j++) {
                String first = nodes.get(i);
                String second = nodes.get(j);
                ListInterface<String> neighbors = getNeighbors(first);
                if (neighbors.contains(second)) {
                    sb.append("1"); 
                } else {
                    sb.append("0");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
