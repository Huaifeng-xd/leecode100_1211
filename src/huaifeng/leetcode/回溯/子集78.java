package huaifeng.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 模拟这个子集获得的方式，发现是一个递归树，子节点都是尾数。剪枝或者说是控制访问内容用first来筛选nums的位置。
 * 2. 如果我们获取子集都是到叶子节点的话。nums的个数就是递归深度，我们在递归到叶子节点时，获取
 */
public class 子集78 {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        dfs(nums, new ArrayList<>(), 0);
        return res;
    }

    public void dfs (int[] nums, List<Integer> path,int first) {
        res.add(new ArrayList<>(path));
        if (first == nums.length) return;
        for (int i = first; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, path, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        子集78 t= new 子集78();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result  = t.subsets(nums);
        System.out.println(result);
    }
}