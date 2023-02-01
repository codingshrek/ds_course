package info.ds.recursion;

public class MoveCharAtEnd {
    static int index = 0;
    static String res="";
    static String tempRes="";

    public static void moveCharToEnd(String input,char c){
        if(index==input.length()){
            System.out.println(res+tempRes);
            return;
        }
        char t = input.charAt(index);
        if(t==c){
            tempRes = tempRes+c;
        }
        else{
            res = res+t;
        }
        index++;
        moveCharToEnd(input,c);
    }

    public static void main(String[] args) {

        moveCharToEnd("axbcxxd",'x');

    }

}
