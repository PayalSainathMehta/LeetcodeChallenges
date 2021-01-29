import com.sun.source.tree.Tree;

import java.util.*;

public class VerticalLevelOrderTraversal {

    private class Range {
        public int min = Integer.MAX_VALUE;
        public int max = Integer.MIN_VALUE;
    }

    public List<List<Integer>> verticalTraversal(TreeNode root){
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new HashMap<>();
        Range range = new Range();
        dfs(root, 0, 0, map, range);
        System.out.println(map.toString());
        //{0={0=[1], -2=[3, 7], -4=[8]}, -1={-1=[2], -3=[4]}, 1={-1=[6], -3=[5]}}
        return convertToList(map, range);
    }

    public void dfs(TreeNode node, int x, int y, Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map, Range range){
        if(node == null)
            return;
        //we need x in ascending order as we move on the x axis, and y in desc order as we move top to bottom
        map.putIfAbsent(x, new TreeMap<>((Integer y1, Integer y2) -> y2.compareTo(y1)));
        map.get(x).putIfAbsent(y, new PriorityQueue<>((Integer v1, Integer v2) -> v1.compareTo(v2))); //we need ascending
        map.get(x).get(y).add(node.val);

        range.min = Math.min(range.min, x);
        range.max = Math.max(range.max, x);

        //recursive, every node's left co-ords would be (x + 1, y - 1) and (x + 1, y + 1)
        dfs(node.left, x - 1, y - 1, map, range);
        dfs(node.right, x + 1, y - 1, map, range);
    }

    public List<List<Integer>> convertToList(Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map, Range range){
        List<List<Integer>> result = new ArrayList<>();
        for(int x = range.min; x <= range.max; x++){ // -1 to 1 for below example
            List<Integer> nodeValues = new ArrayList<>();
            for(int y: map.get(x).keySet()){ //this gives me -1 and -3 for -1
                PriorityQueue<Integer> pq = map.get(x).get(y);
                while(!pq.isEmpty())
                    nodeValues.add(pq.poll()); // this gives me 2 and 4 for (-1,-1) and (-1,-3)
            }
            result.add(nodeValues);
        }
        return result;
    }

    public static void main(String[] args) {
        VerticalLevelOrderTraversal obj = new VerticalLevelOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(3);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.left = new TreeNode(8);
        System.out.println(obj.verticalTraversal(root).toString());
    }
}
