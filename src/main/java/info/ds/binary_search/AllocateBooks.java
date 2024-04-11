package info.ds.binary_search;

import java.util.ArrayList;
import java.util.Arrays;

public class AllocateBooks {
    public static int findPages(ArrayList<Integer> books, int n, int students) {

        if(students>books.size()) return -1;
        int tSum = 0;
        int maxP = 0;
        for(Integer pg : books){
            tSum += pg;
            maxP = Math.max(maxP,pg);
        }
        int low = maxP;
        int high = tSum;
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            int pages = allocatePages(books, mid, students);
            if(pages==-1){
                low = mid+1;
            }
            else{
                ans = Math.min(ans,pages);
                high= mid-1;
            }
        }
        return ans;
    }


    private static int allocatePages(ArrayList<Integer> books, int mPages, int students) {
        int curStudentHolding = 0;
        int maxPages = -1;
        for (int book : books) {
            if (curStudentHolding + book > mPages) {
                maxPages = Math.max(maxPages, curStudentHolding);
                curStudentHolding = book;
                students--;
                if (students <= 0) return -1;
                continue;
            }
            curStudentHolding += book;
            maxPages = Math.max(maxPages, curStudentHolding);
        }
        return maxPages;
    }

    public static void main(String[] args) {
        System.out.println(AllocateBooks.findPages(new ArrayList<>(Arrays.asList(8, 15, 3)), 3, 2));
    }
}
