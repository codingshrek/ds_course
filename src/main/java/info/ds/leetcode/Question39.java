package info.ds.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question39 {

    private List<List<Integer>> findCombination(int index,int target,int[] candidates,List<Integer> path , List<List<Integer>> result){

        if(index>=candidates.length){
            if(target==0){
                result.add(new ArrayList<>(path));
            }
            return result;
        }

        Integer ch =candidates[index];
        if(target>=ch){
            path.add(ch);
            findCombination(index,target-ch,candidates,path,result);
            path.remove(path.size()-1);
        }
        findCombination(index+1,target,candidates,path,result);

        return result;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
          return findCombination(0,target,candidates,new LinkedList<>(),new LinkedList<>());
    }

    public static void main(String[] args) {
        Question39 q = new Question39();
        List<List<Integer>> res = q.combinationSum(new int[]{2,3,6,7},7);

        res.stream().forEach(i-> System.out.println(i.toString()));

    }

}
