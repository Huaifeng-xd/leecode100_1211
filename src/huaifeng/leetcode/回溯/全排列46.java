package huaifeng.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 *  1.排列过程可以看成一个根节点出发的多叉树，通过记录是否访问，从而判断剪枝的多叉树。
 *  为了记录所有排列方案，还需要还原递归回归时的状态，从而产生回溯的效果。
 *  因为path是引用传递，一直复用了一个地址，所以在新增res时需要对其进行复制。
 *
 *  2.另一个不需要记录访问的方案是，循环nums交换当前根节点与其他节点，之后dfs到底。为了下一次循环交换，还需要交换回来，
 *  从而也是回溯。因为这个交换分割，让前面是访问过的，后面是未访问过的，所以函数还需要记录一个开始位置
 */
class 全排列46 {
    List<List<Integer>> res;
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        int len = nums.length;
        visited = new boolean[len];
        dfs(nums, new ArrayList<>());
        return res;
    }

    public void dfs (int[] nums, List<Integer> path) {
        if (path.size() == nums.length)  {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.add(nums[i]);
                dfs(nums, path);
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

}

class Main {
    public static void main(String[] args) {
        全排列46 solver = new 全排列46();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solver.permute(nums);
        System.out.println(result);
    }
}
