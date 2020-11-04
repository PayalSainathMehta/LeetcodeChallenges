import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumHeightTrees {

    static List<Integer> getRootOfMHT(int n, int[][] edges){
        //the concept is to keep removing leaves at the same time until we are left with
        //two or less leaves as Any node that has already been a leaf cannot be the root of a MHT, because its adjacent non-leaf node will always be a better candidate.
        List<Integer> leaves = new ArrayList<>();
        if(n <= 1 || edges == null){
            leaves.add(0);
            return leaves;
        }
        //form adjacency list to store the path
        List<Set<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
            adj.add(new HashSet<>());

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        //now find the current leaves
        //wherever the set contains only one element, that's a leaf, as leaves do not have out-degree, only in-degree - incoming
        for(int i = 0; i < n; i++)
        {
            if(adj.get(i).size() == 1)
                leaves.add(i);
        }

        //now we remove leaves until we are left with 2 or less nodes
        while(n > 2)
        {
            n = n - leaves.size(); //we remove leaves, e.g. 5 leaves found then n reduces by 5
            List<Integer> newLeaves = new ArrayList<>();
            for(int leaf: leaves)
            {   //we now find the neighbors - similar to BFS topological sort
                int neighbor = adj.get(leaf).iterator().next();
                adj.get(neighbor).remove(leaf); //remove the leaf as already visited
                if(adj.get(neighbor).size() == 1) //if a leaf now
                    newLeaves.add(neighbor);
            }
            leaves = newLeaves; //keep doing it until n becomes <= 2
        }
        return leaves;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        System.out.println(getRootOfMHT(n, edges).toString());
    }
}
