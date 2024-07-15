import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> exist = new HashSet<>();
        for(int i = 0; i < descriptions.length; i++) {
            int p = descriptions[i][0];
            int c = descriptions[i][1];
            int side = descriptions[i][2];
            TreeNode child;
            if(map.containsKey(c)) {
                child = map.get(c);
            }else {
                child = new TreeNode(c);
                exist.add(c);
                map.put(c, child);
            }
            TreeNode parent;
            if(map.containsKey(p)) {
                parent = map.get(p);
            }else {
                parent = new TreeNode(p);
                exist.add(p);
                map.put(p, parent);
            }
            if(side == 1){
                parent.left = child;
            }else {
                parent.right = child;
            }


        }
        for(TreeNode node : map.values()) {
            if(node.left != null){
                exist.remove(node.left.val);
            }
            if(node.right != null){
                exist.remove(node.right.val);
            }

        }

        for(int node : exist) {
            return map.get(node);
        }
        return null;
    }
}
