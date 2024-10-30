package HashMap.back;
import java.util.*;

public class knonEmpty {
    public static boolean subset(int arr[] , int k){
        int totalSum = Arrays.stream(arr).sum();
        if(totalSum % k != 0){
            return false;
        }
        Arrays.sort(arr);// sorts in ascending order
        int target = totalSum/k;
        int n = arr.length;

        if(arr[n-1] > target){
            return false;
        }
        boolean[] used = new boolean[n];
        return backtrack(arr , used , k-1 , 0 ,0,target);
    }
    public static boolean backtrack(int[] arr, boolean[] used, int k, int currentSum, int startIndex, int target) {
        if (k == 0) return true; // All subsets found
        if (currentSum == target) {
            return backtrack(arr, used, k - 1, 0, 0, target); // Found one subset, move to the next
        }

        for (int i = startIndex; i < arr.length; i++) {
            if (used[i] || currentSum + arr[i] > target) continue;
            
            used[i] = true;
            if (backtrack(arr, used, k, currentSum + arr[i], i + 1, target)) {
                return true;
            }
            used[i] = false;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the Size of the Array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i = 0 ; i <n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the sum of subset :");
        int k = sc.nextInt();
       boolean res =  subset(arr , k);
       System.out.println(res);
    }
}
