package info.ds.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MergeAccountsDisjointSet {

    private static int getCellNumber(int curRow,int curCol,int cols){
        return (curRow*cols)+curCol+1;
    }

    public static void main(String[] args) {
        System.out.println(MergeAccountsDisjointSet.getCellNumber(1,3,8));
    }
    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds= new DisjointSet(n);
        TreeMap<String,Integer> mailMapNode = new TreeMap<>();

        //Creating groups. Each account is mapped to a node.
        //First account is 0 , second is one and so on.
        //m*n*4a , m = accounts,n=emails in each account
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String email = accounts.get(i).get(j);
                if(!mailMapNode.containsKey(email)){
                    mailMapNode.put(email,i); // mapping emails to node
                }
                else{
                    ds.unionBySize(i,mailMapNode.get(email)); // mapping already mapped  emails to node.
                }
            }
        }
        //By Now our DS is created.

        //Merging emails.
        //TC-> N -> where n = all emails.
        List<List<String>> mergedMail = new ArrayList<>();
        for(int i=0;i<n;i++) mergedMail.add(new ArrayList<>());
        for(Map.Entry<String,Integer> entry : mailMapNode.entrySet()){
            String mail = entry.getKey();
            int node = entry.getValue();
            int uParent = ds.findUParent(node);
            mergedMail.get(uParent).add(mail);
        }

        List<List<String>> ans = new ArrayList<>();
        //Compiling answer
        //TC-> n
        for(int i=0;i<n;i++){
            if(mergedMail.get(i).size()==0) continue;
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(mergedMail.get(i));
            ans.add(temp);
        }

        return ans;
    }

}
