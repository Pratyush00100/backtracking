public class KEqualSubsetSum {
    public boolean canPartitionKSubsets(int[] arr, int k) {
        int sum = 0;
        for (int num : arr) sum += num;
        if (sum % k != 0) return false;

        boolean[] visited = new boolean[arr.length];
        return canPartition(arr, visited, 0, k, 0, sum / k);
    }

    private boolean canPartition(int[] arr, boolean[] visited, int start, int k, int currSum, int target) {
        if (k == 1) return true;
        if (currSum == target) return canPartition(arr, visited, 0, k - 1, 0, target);

        for (int i = start; i < arr.length; i++) {
            if (!visited[i] && currSum + arr[i] <= target) {
                visited[i] = true;
                if (canPartition(arr, visited, i + 1, k, currSum + arr[i], target)) return true;
                visited[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        KEqualSubsetSum solution = new KEqualSubsetSum();
        int[] arr = {1, 3, 2, 2};
        int k = 2;
        System.out.println("Can partition into k subsets with equal sum: " + solution.canPartitionKSubsets(arr, k));
    }
}
