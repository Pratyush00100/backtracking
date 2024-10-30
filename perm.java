package backtracking;
import java.util.*;


   

public class perm {

    public static List<List<Integer>> permute(int nums[])
    {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result , new ArrayList<>() , nums);
        return result;

    }

    public static void backtrack(List<List<Integer>> result , List<Integer> perm , int []nums)
    {
        if(perm.size() == nums.length){
            result.add(new ArrayList<>(perm));
            return;
        }

        for(int i = 0 ; i<nums.length ; i++)
        {
            //if(perm.contains(nums[i])){
               // continue;
            //}
           // else{
            perm.add(nums[i]);
            backtrack(result, perm, nums);
            perm.remove(perm.size()-1);
       // }
    }
        
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        
        System.out.println(permute(nums));
    }
}
