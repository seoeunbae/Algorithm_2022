package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DFS {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<String>(Arrays.asList("D")));
        graph.put("F", new ArrayList<String>(Arrays.asList("D")));
        graph.put("G", new ArrayList<String>(Arrays.asList("C")));
        graph.put("H", new ArrayList<String>(Arrays.asList("C")));
        graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<String>(Arrays.asList("I")));

        Func("A", graph);
    }

    public static void Func(String first, HashMap<String, ArrayList<String>> graph){
        ArrayList<String> needVisit = new ArrayList<>();
        ArrayList<String> visited = new ArrayList<>();

        needVisit.add(first);

        while (needVisit.size() > 0) {
            String node = needVisit.remove(needVisit.size()-1);

            if(!visited.contains(node)){
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }
        System.out.println(visited);
    }
}
//시간복잡도: O(V+E) 노드수+간선수