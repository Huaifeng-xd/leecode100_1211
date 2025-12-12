import java.util.ArrayList;
import java.util.List;

class 全排列46 {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
    }

    public void dfs (int[] nums, int start, int size) {

        if (size == nums.length)  {
            res.add(new ArrayList<>())
            return;
        }
        for (int i = start; i < nums.length; i++) {
            dfs(nums, i, size);
        }

    }
}
