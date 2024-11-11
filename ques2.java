import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), arr);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] arr) {
        if (tempList.size() == arr.length) result.add(new ArrayList<>(tempList));
        else {
            for (int i = 0; i < arr.length; i++) {
                if (tempList.contains(arr[i])) continue;
                tempList.add(arr[i]);
                backtrack(result, tempList, arr);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations solution = new Permutations();
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = solution.permute(arr);
        System.out.println("Permutations of the array: " + result);
    }
}
