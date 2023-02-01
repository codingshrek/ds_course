package info.ds.recursion;

public class Backtracking {



    public static void print1ToNUsingBacktracking(int n){
        if(n == 0){
            return;
        }
        print1ToNUsingBacktracking(n-1);
        System.out.println(n);
    }

    public static void printNTo1UsingBacktracking(int n,int index){
        if(index > n){
            return;
        }
        printNTo1UsingBacktracking(n,index+1);
        System.out.println(index);
    }

    public static void main(String[] args) {
        printNTo1UsingBacktracking(5,1);
    }

}
